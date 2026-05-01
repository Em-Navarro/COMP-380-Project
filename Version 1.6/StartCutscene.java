import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import java.awt.Image;
import java.awt.Color;

public class StartCutscene extends JPanel implements ActionListener, RoomBuilder{
    JLayeredPane layeredPane;
    RoomBuilder[] links;
    JButton button;
    Player player;
    JLabel background;
    ImageIcon scene1;
    ImageIcon scene2;
    ImageIcon scene3;
    int count = 1;
    Color buttonColor = Color.decode("#7d6b45");
    Color buttonBorderColor = Color.decode("#c4ae86");


    StartCutscene(JLayeredPane x, Player y){
        setBounds(0,0,1300,1000);
        setOpaque(true);
        setVisible(false);
        setLayout(null);
        layeredPane = x;
        player = y;
    }
    
    public void create(){

        scene1 = new ImageIcon("Cutscene Images/Intro1.png");
        Image img = scene1.getImage();
        Image scaledImg1 = img.getScaledInstance(1300, 1000, Image.SCALE_SMOOTH);
        scene1 = new ImageIcon(scaledImg1);

        scene2 = new ImageIcon("Cutscene Images/Intro2.png");
        Image img2 = scene2.getImage();
        Image scaledImg2 = img2.getScaledInstance(1300, 1000, Image.SCALE_SMOOTH);
        scene2 = new ImageIcon(scaledImg2);

        scene3 = new ImageIcon("Cutscene Images/Intro3.png");
        Image img3 = scene3.getImage();
        Image scaledImg3 = img3.getScaledInstance(1300, 1000, Image.SCALE_SMOOTH);
        scene3 = new ImageIcon(scaledImg3);

        background = new JLabel(scene1);
        background.setBounds(0, 0, 1300, 1000);
        add(background);

        button = new JButton("→");
        button.setBounds(925,520,200,50);
        button.setFont(new Font("Arial", Font.BOLD, 50));
        button.setBackground(buttonColor);
        button.setBorder(BorderFactory.createLineBorder(buttonBorderColor,10));
        button.addActionListener(this);

        add(player.getTextBox());
        add(button);
    }

    public void showRoom() {
        setVisible(true);
        disableButtons();
        TextBox.writeToTextBox("The King had called for you, the bravest knight in the land.", () -> activateButtons());
        setComponentZOrder(player.getTextBox(), 2);
        setComponentZOrder(button, 1);
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
        setComponentZOrder(player.getTextBox(), 2);
        setComponentZOrder(button, 1);
    }


    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == button){
            if(count == 1){
                disableButtons();
                TextBox.writeToTextBox("The princess had been kidnapped by a dragon, and it was up to you to rescue her.", () -> activateButtons());
                background.setIcon(scene2);
                count++;
                background.repaint();
            }
            else if(count == 2){
                disableButtons();
                TextBox.writeToTextBox("Your journey was long, but you are finally here. Now you simply have to find the princess.", () -> activateButtons());
                count++;
                background.setIcon(scene3);
                background.repaint();
            }
            else{
                moveUp();
            }
        }
    }    
    
}
