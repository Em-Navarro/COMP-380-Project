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

public class EndRoom extends JPanel implements ActionListener, RoomBuilder {
   JLayeredPane layeredPane;
   RoomBuilder[] links;
   JButton button;
   Player player;

   boolean isTyping;
   JLabel background;
   ImageIcon scene1;
   ImageIcon scene2;
   int count = 1;
   JLabel cutSceneTextBox;
   JPanel textBoxPanel;
   Color panelColor = Color.decode("#2f3123");
   Color borderColor = Color.decode("#56584b");
   Color buttonColor = Color.decode("#7d6b45");
   Color buttonBorderColor = Color.decode("#c4ae86");

   EndRoom(JLayeredPane x, Player y) {
      setBounds(0,0,1300,1000);
      setOpaque(true);
      setVisible(false);
      setLayout(null);
      isTyping = false;
      layeredPane = x;
      player = y;
   }

   public void create(){
      scene1 = new ImageIcon("Cutscene Images/True_End1.png");
      Image img1 = scene1.getImage();
      Image scaledImg1 = img1.getScaledInstance(1300, 1000, Image.SCALE_SMOOTH);
      scene1 = new ImageIcon(scaledImg1);
   
      scene2 = new ImageIcon("Cutscene Images/True_End2.png");
      Image img2 = scene2.getImage();
      Image scaledImg2 = img2.getScaledInstance(1300, 1000, Image.SCALE_SMOOTH);
      scene2 = new ImageIcon(scaledImg2);
   
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
      TextBox.writeToTextBoxForCutScene(cutSceneTextBox,"You overcame every trial before you. You triumphed over every hardship. You burst through the final door, ready to finally complete your journey, only to be stopped in your tracks.",() -> stopTyping());
   }

   public void hideRoom() {
      setVisible(false);
   }

   public String getRoom() {
      return "ER";
   }

   public void getLinks(RoomBuilder up, RoomBuilder down, RoomBuilder left, RoomBuilder right) {
      links = new RoomBuilder[]{up, down, left, right};//up = Quit Game
   }

   public void moveUp() {
      if (links != null && links[0] != null) {
         Main.switchRooms(layeredPane, links[0], this);
      }
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
            if(isTyping){
               return;}
            background.setIcon(scene2);
            textBoxPanel.setComponentZOrder(cutSceneTextBox, 0);
            setComponentZOrder(textBoxPanel, 1);
            setComponentZOrder(button, 1);
            background.repaint();
            background.validate();
            startTyping();
            TextBox.writeToTextBoxForCutScene(cutSceneTextBox,"As it turns out, the King should pay more attention to his daughter's friends...", () -> stopTyping());
            count++;
         }
         else{
            System.exit(0);
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
