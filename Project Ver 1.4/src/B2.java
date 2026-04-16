import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class B2 extends JPanel implements ActionListener, RoomBuilder {
    JLayeredPane layeredPane;
    RoomBuilder[] links;
    Player player;

    JLabel label;
    JButton upButton, downButton, leftButton, rightButton;

    public B2(JLayeredPane x, Player y) {
        setBounds(0,0,1300,1000);
        setLayout(null);
        setVisible(false);
        layeredPane = x;
        player = y;
    }

    public void create() {
        ImageIcon roomImage = new ImageIcon("Background Images/B2_Closed.png");
        Image img = roomImage.getImage();
        Image scaledImg = img.getScaledInstance(1300, 1000, Image.SCALE_SMOOTH);
        roomImage = new ImageIcon(scaledImg);

        JLabel background = new JLabel(roomImage);
        background.setBounds(0, 0, 1300, 1000);
        add(background);

        label = new JLabel("B2");
        label.setBounds(500,300,300,100);
        label.setFont(new Font("MV Boli",Font.PLAIN,100));

        upButton = new JButton("↑");
        upButton.setBounds(600,30,60,60);
        upButton.setFont(new Font("Arial", Font.BOLD, 20));


        downButton = new JButton("↓");
        downButton.setBounds(600,500,60,60);
        downButton.setFont(new Font("Arial", Font.BOLD, 20));


        leftButton = new JButton("←");
        leftButton.setBounds(350,250,60,60);
        leftButton.setFont(new Font("Arial", Font.BOLD, 20));



        rightButton = new JButton("→");
        rightButton.setBounds(850,250,60,60);
        rightButton.setFont(new Font("Arial", Font.BOLD, 20));


        upButton.addActionListener(this);
        downButton.addActionListener(this);
        leftButton.addActionListener(this);
        rightButton.addActionListener(this);

        add(label);
        add(upButton);
        add(downButton);
        add(leftButton);
        add(rightButton);
        // force background behind everything
        setComponentZOrder(background, getComponentCount() - 1);
    }

    public void showRoom(){ setVisible(true); }
    public void hideRoom(){ setVisible(false); }

    public int getIndex(){ return -1; }

    public void moveUp() {
        if(links[0] != null){
            Main.switchRooms(layeredPane, links[0], this);
            addPlayerComponents((JPanel)links[0]);
        }
    }

    public void moveDown() {
        if(links[1] != null){
            Main.switchRooms(layeredPane, links[1], this);
            addPlayerComponents((JPanel)links[1]);
        }
    }

    public void moveLeft() {
        if(links[2] != null){
            Main.switchRooms(layeredPane, links[2], this);
            addPlayerComponents((JPanel)links[2]);
        }
    }

    public void moveRight() {
        if(links[3] != null){
            Main.switchRooms(layeredPane, links[3], this);
            addPlayerComponents((JPanel)links[3]);
        }
    }

    public void addPlayerComponents(JPanel panel){
        panel.add(player.getInventory());
        panel.setComponentZOrder(player.getInventory(), 0);
    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == upButton) moveUp();
        if(e.getSource() == downButton) moveDown();
        if(e.getSource() == leftButton) moveLeft();
        if(e.getSource() == rightButton) moveRight();
    }

    public void getLinks(RoomBuilder up, RoomBuilder down, RoomBuilder left, RoomBuilder right) {
        links = new RoomBuilder[]{up, down, left, right};
    }
}