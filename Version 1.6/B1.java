import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class B1 extends JPanel implements ActionListener, RoomBuilder {
    JLayeredPane layeredPane;
    RoomBuilder[] links;
    Player player;
    boolean visited = false;

    JLabel label,background;
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

        label = new JLabel("B1");
        label.setBounds(500,300,300,100);
        label.setFont(new Font("MV Boli",Font.PLAIN,70));

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


        add(label);
        add(upButton);
        add(containerButton);
        add(rightButton);
        add(waterPuzzle);
        // force background behind everything
        setComponentZOrder(background, getComponentCount() - 1);
    }

    public void showRoom(){
    setVisible(true);

        if(!visited){
            disableButtons();
            TextBox.writeToTextBox("B1 Text", () ->  activateButtons());
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
        upButton.setEnabled(true);
        containerButton.setEnabled(true);
        rightButton.setEnabled(true);
    }
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == upButton) moveUp();
       if(e.getSource() == containerButton) toggleContainers();
        if(e.getSource() == rightButton) moveRight();
    }

    public void getLinks(RoomBuilder up, RoomBuilder down, RoomBuilder left, RoomBuilder right) {
        links = new RoomBuilder[]{up, down, left, right};
    }
}
