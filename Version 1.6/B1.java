import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class B1 extends JPanel implements ActionListener, RoomBuilder,MouseListener {
    JLayeredPane layeredPane;
    RoomBuilder[] links;
    Player player;
    boolean visited = false;
    boolean open = false;

    JLabel puzzle,background;
    JButton upButton, containerButton, rightButton;
    static B1 instance;
    static  WaterPuzzle waterPuzzle;

    public B1(JLayeredPane x, Player y) {
        setBounds(0,0,1300,1000);
        setLayout(null);
        setVisible(false);
        layeredPane = x;
        player = y;
        instance= this;
        waterPuzzle = new WaterPuzzle(this);
        waterPuzzle.create();
    }

    public void create() {
        ImageIcon roomImage = new ImageIcon("Background Images/B1_Closed.png");
        Image img = roomImage.getImage();
        Image scaledImg = img.getScaledInstance(1300, 1000, Image.SCALE_SMOOTH);
        roomImage = new ImageIcon(scaledImg);

        background = new JLabel(roomImage);
        background.setBounds(0, 0, 1300, 1000);
        add(background);

        puzzle = new JLabel();
        puzzle.setBounds(50,150,300,200);
        puzzle.setVisible(true);
        puzzle.addMouseListener(this);


        upButton = new JButton("↑");
        upButton.setBounds(600,30,60,60);
        upButton.addActionListener(this);
        upButton.setFont(new Font("Arial", Font.BOLD, 20));
        upButton.setEnabled(false);

        containerButton = new JButton("?");
        containerButton.setBounds(100,250,60,60);
        containerButton.addActionListener(this);
        containerButton.setFont(new Font("Arial", Font.BOLD, 20));

        rightButton = new JButton("→");
        rightButton.setBounds(850,250,60,60);
        rightButton.addActionListener(this);
        rightButton.setFont(new Font("Arial", Font.BOLD, 20));


        add(puzzle);
      
        add(upButton);
        
        add(rightButton);
        add(waterPuzzle);
        // force background behind everything
        setComponentZOrder(background, getComponentCount() - 1);
    }

    public void showRoom(){
    setVisible(true);

        if(!visited){
            disableButtons();
            TextBox.writeToTextBox("Another gate? And some kind of puzzle...wonder what will happen if I fill it to the line...?", () ->  activateButtons());
            visited = true;
        }
        else{
          TextBox.writeToTextBox(" ", null);  
        }
    }
    public void hideRoom(){ setVisible(false); }

    public String getRoom() {
        return "B1";
    }

    public void moveUp() {
        if(links[0] != null){
            Main.switchRooms(layeredPane, links[0], this);
        }
    }

    public void moveDown() {}

    public void moveLeft() {}

    public void moveRight() {
        if(links[3] != null){
            Main.switchRooms(layeredPane, links[3], this);
            Player.changeCurrentLocation(links[3].getRoom());
            addPlayerComponents((JPanel)links[3]);
        }
    }

    public void toggleContainers(){
        if (waterPuzzle.isVisible()) {
            waterPuzzle.setVisible(false);
            upButton.setVisible(true);
            rightButton.setVisible(true);
        }else {
            waterPuzzle.setVisible(true);
            upButton.setVisible(false);
            rightButton.setVisible(false);
        }
    }
    public void winPuzzle(){
        if (instance == null) return;

        ImageIcon roomImage = new ImageIcon("Background Images/B1_open.png");
        Image img = roomImage.getImage();
        Image scaledImg = img.getScaledInstance(1300, 1000, Image.SCALE_SMOOTH);
        roomImage = new ImageIcon(scaledImg);
        
        
        open = true;
        instance.background.setIcon(roomImage);
        instance.upButton.setEnabled(true);
        instance.revalidate();
        instance.repaint();


        // text "that did something!"

    }
    public void addPlayerComponents(JPanel panel){
        panel.add(player.getInventory());
        panel.add(player.getTextBox());
        panel.setComponentZOrder(player.getInventory(), 0);
        panel.setComponentZOrder(player.getTextBox(), 0);
    }

    public void disableButtons(){
        upButton.setEnabled(false);
        containerButton.setEnabled(false);
        rightButton.setEnabled(false);
    }

    public void activateButtons(){
        
        if (open) upButton.setEnabled(true);
        containerButton.setEnabled(true);
        rightButton.setEnabled(true);
    }
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == upButton) moveUp();
       if(e.getSource() == containerButton) toggleContainers();
        if(e.getSource() == rightButton) moveRight();
    }
    @Override
   public void mouseClicked(MouseEvent e) {
     toggleContainers();
   }
    @Override
   public void mousePressed(MouseEvent e) {
    //only the pressing down
   }
   @Override
   public void mouseReleased(MouseEvent e) {
    //only the release
   }
   @Override
   public void mouseEntered(MouseEvent e) {
    //when mouse goes inside the object with listener
   }
   @Override
   public void mouseExited(MouseEvent e) {
    //when mouse leaves the object with listener
   }  

    public void getLinks(RoomBuilder up, RoomBuilder down, RoomBuilder left, RoomBuilder right) {
        links = new RoomBuilder[]{up, down, left, right};
    }
}
