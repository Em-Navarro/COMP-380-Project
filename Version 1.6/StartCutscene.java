import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.Color;

public class StartCutscene extends JPanel implements ActionListener, RoomBuilder{
    JLayeredPane layeredPane;
    RoomBuilder[] links;
    JButton button;
    Player player;

    boolean isTyping;
    JLabel background;
    ImageIcon scene1;
    ImageIcon scene2;
    ImageIcon scene3;
    int count = 1;
    JLabel cutSceneTextBox;
    JPanel textBoxPanel;
    Color panelColor = Color.decode("#2f3123");
    Color borderColor = Color.decode("#56584b");
    Color buttonColor = Color.decode("#7d6b45");
    Color buttonBorderColor = Color.decode("#c4ae86");

    StartCutscene(JLayeredPane x, Player y){
        setBounds(0,0,1300,1000);
        setOpaque(true);
        setVisible(false);
        setLayout(null);
        isTyping = false;
        layeredPane = x;
        player = y;
    }
    
    public void create(){
        scene1 = new ImageIcon("Cutscene Images/Intro1.png");
        Image img1 = scene1.getImage();
        Image scaledImg1 = img1.getScaledInstance(1300, 1000, Image.SCALE_SMOOTH);
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

        textBoxPanel = new JPanel();
        textBoxPanel.setBounds(200,570,925,140);
        textBoxPanel.setBackground(panelColor);
        textBoxPanel.setBorder(BorderFactory.createLineBorder(borderColor,10));
        textBoxPanel.setLayout(new FlowLayout(FlowLayout.LEFT));

        cutSceneTextBox = new JLabel();
        cutSceneTextBox.setBounds(100,450,925,150);
        cutSceneTextBox.setFont(new Font("MV Boli",Font.PLAIN,20));
        cutSceneTextBox.setForeground(Color.white);
        textBoxPanel.add(cutSceneTextBox);

        button = new JButton("→");
        button.setBounds(925,520,200,50);
        button.setFont(new Font("Arial", Font.BOLD, 50));
        button.setBackground(buttonColor);
        button.setBorder(BorderFactory.createLineBorder(buttonBorderColor,10));
        button.addActionListener(this);

        add(button);
        add(background);
        add(textBoxPanel);
        add(cutSceneTextBox);
    }

    public void showRoom() {
        setVisible(true);
        textBoxPanel.setComponentZOrder(cutSceneTextBox, 0);
        setComponentZOrder(textBoxPanel, 1);
        setComponentZOrder(button, 1);
        startTyping();
        TextBox.writeToTextBoxForCutScene(cutSceneTextBox,"The King had called for you, the bravest knight in the land.",() -> stopTyping());
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
    public void disableButtons(){}
    public void activateButtons(){}

    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == button){
            if(count == 1){
                if(isTyping){return;}
                background.setIcon(scene2);
                textBoxPanel.setComponentZOrder(cutSceneTextBox, 0);
                setComponentZOrder(textBoxPanel, 1);
                setComponentZOrder(button, 1);
                background.repaint();
                background.validate();
                startTyping();
                TextBox.writeToTextBoxForCutScene(cutSceneTextBox,"The princess had been kidnapped by a dragon, and it was up to you to rescue her.", () -> stopTyping());
                count++;
            }
            else if(count == 2){
                if(isTyping){return;}
                background.setIcon(scene3);
                textBoxPanel.setComponentZOrder(cutSceneTextBox, 0);
                setComponentZOrder(textBoxPanel, 1);
                setComponentZOrder(button, 1);
                background.repaint();
                background.validate();
                startTyping();
                TextBox.writeToTextBoxForCutScene(cutSceneTextBox,"Your journey was long, but you are finally here. Now you simply have to find the princess.", () -> stopTyping());
                count++;
            }
            else{
                if(isTyping){return;}
                moveUp();
            }
        }
    }
    public void startTyping(){
        isTyping = true;
    }
    public void stopTyping(){
        isTyping = false;
    }
}
