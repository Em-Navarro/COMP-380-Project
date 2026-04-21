import javax.swing.*;
import java.awt.*;

public class EndRoom extends JPanel implements RoomBuilder {
    JLayeredPane layeredPane;

    public EndRoom(JLayeredPane x) {
        setBounds(0,0,1300,1000);
        setLayout(null);
        setVisible(false);
        layeredPane = x;
    }

    public void create() {
        JLabel label = new JLabel("YOU WIN!");
        label.setBounds(400,300,700,200);
        label.setFont(new Font("MV Boli",Font.BOLD,100));
        add(label);
    }

    public void showRoom(){ setVisible(true); }
    public void hideRoom(){ setVisible(false); }

    public String getRoom() {
        return "ER";
     }

    public void moveUp(){}
    public void moveDown(){}
    public void moveLeft(){}
    public void moveRight(){}

    public void getLinks(RoomBuilder up, RoomBuilder down, RoomBuilder left, RoomBuilder right){}
}