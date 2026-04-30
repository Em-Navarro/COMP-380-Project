import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JButton;  

public class StartCutscene extends JPanel implements ActionListener, RoomBuilder{
    JLayeredPane layeredPane;
    RoomBuilder[] links;
    JButton testButton;
    Player player;


    StartCutscene(JLayeredPane x, Player y){
        setBounds(0,0,1300,1000);
        setOpaque(true);
        setVisible(false);
        setLayout(null);
        layeredPane = x;
        player = y;
    }
    
    public void create(){
        testButton = new JButton("Press me to continue");
        testButton.setBounds(0,0,500,200);
        testButton.addActionListener(this);

        add(player.getTextBox());
        add(testButton);
    }

    public void showRoom() {
        setVisible(true);
        //add cascading if else with story and background changes with button
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
        addPlayerTextBox((JPanel)links[0]);
        return;
    }

    public void addPlayerTextBox(JPanel panel){
        panel.add(player.getTextBox());
        panel.setComponentZOrder(player.getTextBox(), 0);
    }

    public void moveDown() {}
    public void moveLeft() {}
    public void moveRight() {}

    public void disableButtons(){ 
    }

    public void activateButtons(){  
    }


    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == testButton){
            moveUp();
        }
    }    
    
}
