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

public class StartRoom extends JPanel implements ActionListener, RoomBuilder{
    JLayeredPane layeredPane;
    RoomBuilder[] links;

    JLabel label;
    JButton upButton;
    StartRoom(JLayeredPane x){
        setBounds(0,0,1300,1000);
        setOpaque(true);
        setVisible(false);
        setLayout(null);
        layeredPane = x;
    }

    public void create() {
        label = new JLabel("Start Room");
        upButton = new JButton("Up");

        label.setBounds(300,300,1000,100);
        label.setFont(new Font("MV Boli",Font.PLAIN,100));

        upButton.setBounds(600,0,100,100);
        upButton.setFocusable(false);
        upButton.addActionListener(this);

        add(label);
        add(upButton);
    }

    public void showRoom() {
        setVisible(true);
    }

    public void hideRoom() {
        setVisible(false);
    }

    public int getIndex() {
        return -2;
    }

    public void moveUp() {
        Main.switchRooms(layeredPane, links[0], this);
    }

    public void moveLeft() {
    }

    public void moveRight() {
    }

    public void moveDown() {
    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == upButton){
            moveUp();
        }
    }

    @Override
     public void getLinks(RoomBuilder up, RoomBuilder down, RoomBuilder left, RoomBuilder right) {
        RoomBuilder[] l = new RoomBuilder[4];
        l[0] = up;//a1
        l[1] = down;
        l[2] = left;
        l[3] = right;
        links = l;
     }
    
}
