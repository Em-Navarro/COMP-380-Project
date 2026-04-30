import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JButton;  
import java.awt.Font;

public class StartCutscene extends JPanel implements ActionListener, RoomBuilder{
    JLayeredPane layeredPane;
    RoomBuilder[] links;
    JButton button;
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
        button = new JButton("→");
        button.setBounds(925,520,200,50);
        button.setFont(new Font("Arial", Font.BOLD, 50));
        button.addActionListener(this);

        add(player.getTextBox());
        add(button);
    }

    public void showRoom() {
        setVisible(true);
        disableButtons();
        TextBox.writeToTextBox("Start Cutscene Text", () ->  activateButtons());
        //maybe make diffeent methods, and add a counter to actionPerformed
        // so it can call diff methods w/ diff parts of the story
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
        button.setEnabled(false);
    }

    public void activateButtons(){  
        button.setEnabled(true);
    }


    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == button){
            moveUp();
        }
    }    
    
}
