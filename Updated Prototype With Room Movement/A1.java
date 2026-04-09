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

    JLabel label;
    JButton downButton;
    JButton rightButton;
    A1(JLayeredPane x){
        setBounds(0,0,1300,1000);
        setOpaque(true);
        setVisible(false);
        setLayout(null);
        layeredPane = x;
    }  
     public void create() {
        label = new JLabel("A1");
        downButton = new JButton("Down");
        rightButton = new JButton("Right");

        label.setBounds(300,300,1000,100);
        label.setFont(new Font("MV Boli",Font.PLAIN,100));

        downButton.setBounds(600,500,100,100);
        downButton.setFocusable(false);
        downButton.addActionListener(this);

        rightButton.setBounds(1150,250,100,100);
        rightButton.setFocusable(false);
        rightButton.addActionListener(this);

        add(label);
        add(downButton);
        add(rightButton);
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
    }

    public void moveDown() {
        Main.switchRooms(layeredPane, links[1], this);
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
