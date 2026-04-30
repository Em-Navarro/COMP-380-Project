import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;

public class C2 extends JPanel implements ActionListener, RoomBuilder {
    JLayeredPane layeredPane;
    RoomBuilder[] links;
    Player player;
    boolean visited = false;
    static C2 instance;
    static boolean gateUnlocked = false;

    JLabel background;
    JLabel label;
    JButton upButton, downButton, rightButton;

    public C2(JLayeredPane x, Player y) {
        setBounds(0,0,1300,1000);
        setLayout(null);
        setVisible(false);
        layeredPane = x;
        player = y;
        instance = this;
    }

    public void create() {
        ImageIcon roomImage = new ImageIcon("Background Images/C2_Closed.png");
        Image img = roomImage.getImage();
        Image scaledImg = img.getScaledInstance(1300, 1000, Image.SCALE_SMOOTH);
        roomImage = new ImageIcon(scaledImg);

        background = new JLabel(roomImage);
        background.setBounds(0, 0, 1300, 1000);
        add(background);

        label = new JLabel("C2");
        //label.setBounds(500,300,300,100);
        //label.setFont(new Font("MV Boli",Font.PLAIN,70));

        upButton = new JButton("↑");
        upButton.setBounds(600,30,60,60);
        upButton.setFont(new Font("Arial", Font.BOLD, 20));
        upButton.setEnabled(false);


        downButton = new JButton("↓");
        downButton.setBounds(600,500,60,60);
        downButton.setFont(new Font("Arial", Font.BOLD, 20));


        rightButton = new JButton("→");
        rightButton.setBounds(850,250,60,60);
        rightButton.setFont(new Font("Arial", Font.BOLD, 20));


        upButton.addActionListener(this);
        downButton.addActionListener(this);
        rightButton.addActionListener(this);

        add(label);
        add(upButton);
        add(downButton);
        add(rightButton);
        // force background behind everything
        setComponentZOrder(background, getComponentCount() - 1);
    }

    static void unlockGateWithNote() {
        if (gateUnlocked) return;
        gateUnlocked = true;
        if (instance == null) return;

        String openPath = "Background Images/C2_Open.png";
        if (!new File(openPath).exists()) {
            openPath = "Background Images/C2_open.png";
        }

        ImageIcon roomImage = new ImageIcon(openPath);
        Image img = roomImage.getImage();
        Image scaledImg = img.getScaledInstance(1300, 1000, Image.SCALE_SMOOTH);
        roomImage = new ImageIcon(scaledImg);
        instance.background.setIcon(roomImage);
        instance.upButton.setEnabled(true);
        instance.revalidate();
        instance.repaint();
    }

    public void showRoom(){
        setVisible(true);
        if(!visited){
            disableButtons();
            TextBox.writeToTextBox("You have to be kidding me. This has to be the last one, right?", () ->  activateButtons());
            visited = true;
        }
        else{
          TextBox.writeToTextBox(" ", null);  
        } 
    }
    public void hideRoom(){ setVisible(false); }

    public String getRoom() {
        return "C2";
     }

    public void moveUp() {
        if(!gateUnlocked) return;
        if(links[0] != null){
            Main.switchRooms(layeredPane, links[0], this);
            Player.changeCurrentLocation(links[0].getRoom());
        }
    }

    public void moveDown() {
        if(links[1] != null){
            Main.switchRooms(layeredPane, links[1], this);
            Player.changeCurrentLocation(links[1].getRoom());
            addPlayerComponents((JPanel)links[1]);
        }
    }

    public void moveRight() {
        if(links[3] != null){
            Main.switchRooms(layeredPane, links[3], this);
            Player.changeCurrentLocation(links[3].getRoom());
            addPlayerComponents((JPanel)links[3]);
        }
    }

    public void moveLeft() {}

    public void addPlayerComponents(JPanel panel){
        panel.add(player.getInventory());
        panel.add(player.getTextBox());
        panel.setComponentZOrder(player.getInventory(), 0);
        panel.setComponentZOrder(player.getTextBox(), 0);
    }

    public void disableButtons(){
        downButton.setEnabled(false); 
        rightButton.setEnabled(false);    
    }

    public void activateButtons(){
        downButton.setEnabled(true); 
        rightButton.setEnabled(true);    
    }


    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == upButton) moveUp();
        if(e.getSource() == downButton) moveDown();
        if(e.getSource() == rightButton) moveRight();
    }

    public void getLinks(RoomBuilder up, RoomBuilder down, RoomBuilder left, RoomBuilder right) {
        links = new RoomBuilder[]{up, down, left, right};
    }
}