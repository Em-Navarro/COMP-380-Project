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

public class A2 extends JPanel implements ActionListener, RoomBuilder{
    JLayeredPane layeredPane;
    RoomBuilder[] links;

    JLabel label;
    JButton upButton; //deactivate until puzzle solved
    JButton leftButton;
    JButton rightButton;
    A2(JLayeredPane x){
        setBounds(0,0,1300,1000);
        setOpaque(true);
        setVisible(false);
        setLayout(null);
        layeredPane = x;
    }
     public void create() {
        label = new JLabel("A2");
        upButton = new JButton("Up");
        leftButton = new JButton("Left");
        rightButton = new JButton("Right");

        label.setBounds(300,300,1000,100);
        label.setFont(new Font("MV Boli",Font.PLAIN,100));

        upButton.setBounds(600,0,100,100);
        upButton.setEnabled(false); //set enabled true when puzzle is solved
        upButton.setFocusable(false);
        upButton.addActionListener(this);

        leftButton.setBounds(50,250,100,100);
        leftButton.setFocusable(false);
        leftButton.addActionListener(this);

        rightButton.setBounds(1150,250,100,100);
        rightButton.setFocusable(false);
        rightButton.addActionListener(this);


        add(label);
        add(upButton);
        add(leftButton);
        add(rightButton);
    }

    public void showRoom() {
        setVisible(true);
    }

    public void hideRoom() {
        setVisible(false);
    }

    public int getIndex() {
        return -4;
    }

    public void moveUp() {
        Main.switchRooms(layeredPane, links[0], this);
    }

    public void moveLeft() {
        Main.switchRooms(layeredPane, links[2], this);
    }

    public void moveRight() {
        Main.switchRooms(layeredPane, links[3], this);
    }

    public void moveDown() {
    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == upButton){
            moveUp();
        }
        else if(e.getSource() == leftButton){
            moveLeft();
        }
        else if(e.getSource() == rightButton){
            moveRight();
        }
    }

   @Override
     public void getLinks(RoomBuilder up, RoomBuilder down, RoomBuilder left, RoomBuilder right) {
        RoomBuilder[] l = new RoomBuilder[4];
        l[0] = up;//will be b2 when we get there
        l[1] = down;
        l[2] = left;//a1
        l[3] = right;//a3
        links = l;
     }  
}
