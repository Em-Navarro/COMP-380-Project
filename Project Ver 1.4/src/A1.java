import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton; 
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import java.awt.Image;

public class A1 extends JPanel implements ActionListener, RoomBuilder{
    JLayeredPane layeredPane;
    RoomBuilder[] links;
    Player player;

    JLabel label;
    JButton downButton;
    JButton rightButton;
    A1(JLayeredPane x, Player y){
        setBounds(0,0,1300,1000);
        setOpaque(true);
        setVisible(false);
        setLayout(null);
        layeredPane = x;
        player = y;
    }  
     public void create() {
        ImageIcon roomImage = new ImageIcon("./Background Images/A1.png");
        Image img = roomImage.getImage();
        Image scaledImg = img.getScaledInstance(1300, 1000, Image.SCALE_SMOOTH);
        roomImage = new ImageIcon(scaledImg);

        JLabel background = new JLabel(roomImage);
        background.setBounds(0, 0, 1300, 1000);
        add(background);

        label = new JLabel("A1");
        downButton = new JButton("↓");
        rightButton = new JButton("→");
        rightButton.setFont(new Font("Arial", Font.BOLD, 20));
        downButton.setFont(new Font("Arial", Font.BOLD, 20));

        label.setBounds(300,300,1000,100);
        label.setFont(new Font("MV Boli",Font.PLAIN,100));

        downButton.setBounds(600,500,60,60);
        downButton.setFocusable(false);
        downButton.addActionListener(this);

        rightButton.setBounds(850,250,60,60);
        rightButton.setFocusable(false);
        rightButton.addActionListener(this);

        add(label);
        add(downButton);
        add(rightButton);
         // force background behind everything
         setComponentZOrder(background, getComponentCount() - 1);
    }

    public void showRoom() {
        setVisible(true);
    }

    public void hideRoom() {
        setVisible(false);
    }

    public int getIndex() {
        return -3;
    }

    public void moveUp() {
    }

    public void moveLeft() {
    }

    public void moveRight() {
        Main.switchRooms(layeredPane, links[3], this);
        addPlayerComponents((JPanel)links[3]);
    }

    public void moveDown() {
        Main.switchRooms(layeredPane, links[1], this);
        addPlayerComponents((JPanel)links[1]);
    }

    public void addPlayerComponents(JPanel panel){
        panel.add(player.getInventory());
        panel.add(player.getTextBox());
        panel.setComponentZOrder(player.getInventory(), 0);
        panel.setComponentZOrder(player.getTextBox(), 0);
    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == downButton){
            moveDown();
        }
        else if(e.getSource() == rightButton){
            moveRight();
        }
    }

    @Override
     public void getLinks(RoomBuilder up, RoomBuilder down, RoomBuilder left, RoomBuilder right) {
        RoomBuilder[] l = new RoomBuilder[4];
        l[0] = up;
        l[1] = down; //startRoom
        l[2] = left; 
        l[3] = right;//a2
        links = l;
     } 
}
