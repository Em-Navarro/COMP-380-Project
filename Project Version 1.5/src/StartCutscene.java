import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JButton;  

public class StartCutscene extends JPanel implements ActionListener, RoomBuilder{
    JLayeredPane layeredPane;
    RoomBuilder[] links;
    JButton testButton;


    StartCutscene(JLayeredPane x){
        setBounds(0,0,1300,1000);
        setOpaque(true);
        setVisible(false);
        setLayout(null);
        layeredPane = x;
    }
    
    public void create(){
        testButton = new JButton("Press me to continue");
        testButton.setBounds(0,0,500,500);
        testButton.addActionListener(this);

        add(testButton);
    }

    public void showRoom() {
        setVisible(true);
    }

    public void hideRoom() {
        setVisible(false);
    }

    public String getRoom() {
        return null;
    }

    public void getLinks(RoomBuilder up, RoomBuilder down, RoomBuilder left, RoomBuilder right) {
        links = new RoomBuilder[]{up, down, left, right};//up = StartRoom
    }

    public void moveUp() {
        Main.switchRooms(layeredPane, links[0], this);
        return;
    }

    public void moveDown() {}
    public void moveLeft() {}
    public void moveRight() {}

    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == testButton){
            moveUp();
        }
    }    
    
}
