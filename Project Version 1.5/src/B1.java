import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class B1 extends JPanel implements ActionListener, RoomBuilder {
    JLayeredPane layeredPane;
    RoomBuilder[] links;
    Player player;

    JLabel label;
    JButton upButton,leftButton, rightButton;

    public B1(JLayeredPane x, Player y) {
        setBounds(0,0,1300,1000);
        setLayout(null);
        setVisible(false);
        layeredPane = x;
        player = y;
    }

    public void create() {
        ImageIcon roomImage = new ImageIcon("src/Background Images/B1_Closed.png");
        Image img = roomImage.getImage();
        Image scaledImg = img.getScaledInstance(1300, 1000, Image.SCALE_SMOOTH);
        roomImage = new ImageIcon(scaledImg);

        JLabel background = new JLabel(roomImage);
        background.setBounds(0, 0, 1300, 1000);
        add(background);

        label = new JLabel("B1");
        label.setBounds(500,300,300,100);
        label.setFont(new Font("MV Boli",Font.PLAIN,70));

        upButton = new JButton("↑");
        upButton.setBounds(600,30,60,60);
        upButton.addActionListener(this);
        upButton.setFont(new Font("Arial", Font.BOLD, 20));

        leftButton = new JButton("←");
        leftButton.setBounds(350,250,60,60);
        leftButton.addActionListener(this);
        leftButton.setFont(new Font("Arial", Font.BOLD, 20));

        rightButton = new JButton("→");
        rightButton.setBounds(850,250,60,60);
        rightButton.addActionListener(this);
        rightButton.setFont(new Font("Arial", Font.BOLD, 20));


        add(label);
        add(upButton);
        add(leftButton);
        add(rightButton);
        // force background behind everything
        setComponentZOrder(background, getComponentCount() - 1);
    }

    public void showRoom(){ setVisible(true); }
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

    public void moveLeft() { 
        if(links[2] != null)
            Main.switchRooms(layeredPane, links[2], this);
        Player.changeCurrentLocation(links[2].getRoom());
            addPlayerComponents((JPanel)links[2]);
         }

    public void moveRight() {
        if(links[3] != null){
            Main.switchRooms(layeredPane, links[3], this);
            Player.changeCurrentLocation(links[3].getRoom());
            addPlayerComponents((JPanel)links[3]);
        }
    }

    public void addPlayerComponents(JPanel panel){
        panel.add(player.getInventory());
        panel.add(player.getTextBox());
        panel.setComponentZOrder(player.getInventory(), 0);
        panel.setComponentZOrder(player.getTextBox(), 0);
    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == upButton) moveUp();
        if(e.getSource() == leftButton) moveLeft();
        if(e.getSource() == rightButton) moveRight();
    }

    public void getLinks(RoomBuilder up, RoomBuilder down, RoomBuilder left, RoomBuilder right) {
        links = new RoomBuilder[]{up, down, left, right};
    }
}
