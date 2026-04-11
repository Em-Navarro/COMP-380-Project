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

public class A3 extends JPanel implements ActionListener, RoomBuilder{
    JLayeredPane layeredPane;
    RoomBuilder[] links;

    JLabel label;
    JButton leftButton;
    A3(JLayeredPane x){
        setBounds(0,0,1300,1000);
        setOpaque(true);
        setVisible(false);
        setLayout(null);
        layeredPane = x;
    }
     public void create() {
        label = new JLabel("A3");
        leftButton = new JButton("Left");

        label.setBounds(300,300,1000,100);
        label.setFont(new Font("MV Boli",Font.PLAIN,100));

        leftButton.setBounds(50,250,100,100);
        leftButton.setFocusable(false);
        leftButton.addActionListener(this);

        add(label);
        add(leftButton);
    }

    public void showRoom() {
        setVisible(true);
    }

    public void hideRoom() {
        setVisible(false);
    }

    public int getIndex() {
        return -5;
    }

    public void moveUp() {
    }

    public void moveLeft() {
        Main.switchRooms(layeredPane, links[2], this);
    }

    public void moveRight() {
    }

    public void moveDown() {
    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == leftButton){
            moveLeft();
        }
    }

    @Override
     public void getLinks(RoomBuilder up, RoomBuilder down, RoomBuilder left, RoomBuilder right) {
        RoomBuilder[] l = new RoomBuilder[4];
        l[0] = up;
        l[1] = down;
        l[2] = left; //a2
        l[3] = right;
        links = l;
     }   
}
