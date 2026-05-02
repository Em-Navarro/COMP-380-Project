import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.SwingUtilities;
import java.awt.Image;

public class StartScreen extends JPanel implements ActionListener, RoomBuilder{
    JLayeredPane layeredPane;
    RoomBuilder[] links;
    Color buttonColor = Color.decode("#7d6b45");
    Color buttonBorderColor = Color.decode("#c4ae86");
    JLabel title;
    JLabel background;
    JButton startButton;
    JButton creditButton;
    ImageIcon backgroundImage;

    JPanel creditsPanel;
    JLabel creditsNamesLabel;
    JButton closeCreditsButton;

    public StartScreen(JLayeredPane x){
        setBounds(0,0,1300,1000);
        setOpaque(true);
        setVisible(true);
        setLayout(null);
        layeredPane = x;
        return;
    }

    public void create(){
        title = new JLabel("A Knight's Story");
        startButton = new JButton("Start");
        creditButton = new JButton("Credit");

        title.setBounds(150,120,1000,110);
        title.setHorizontalAlignment(JLabel.CENTER);
        title.setForeground(Color.decode("#203a1e"));
        title.setFont(new Font("MV Boli",Font.PLAIN,100));

        backgroundImage = new ImageIcon("Temp_Background.png");
		Image newImage = backgroundImage.getImage();
		Image resizedImage = newImage.getScaledInstance(1300,1000,Image.SCALE_SMOOTH);
		backgroundImage = new ImageIcon(resizedImage); 
        background = new JLabel(backgroundImage);
        background.setBounds(0,0,1300,1000);

        startButton.setBounds(400,250,500,150);
        startButton.setFocusable(false);
        startButton.addActionListener(this);
        startButton.setBackground(buttonColor);
        startButton.setBorder(BorderFactory.createLineBorder(buttonBorderColor,10));

        creditButton.setBounds(400,450,500,150);
        creditButton.setFocusable(false);
        creditButton.addActionListener(this);
        creditButton.setBackground(buttonColor);
        creditButton.setBorder(BorderFactory.createLineBorder(buttonBorderColor,10));
        
        creditsPanel = new JPanel(null);
        creditsPanel.setBounds(250, 175, 800, 550);
        creditsPanel.setOpaque(true);
        creditsPanel.setBackground(new Color(245, 240, 230));
        creditsPanel.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(buttonBorderColor, 4),
            BorderFactory.createEmptyBorder(16, 24, 24, 24)));
        creditsPanel.setVisible(false);

        creditsNamesLabel = new JLabel("<html><div style='text-align:center;width:720px;'>"
            + "<p style='font-family:MV Boli;font-size:28px;color:#203a1e;margin:12px 0;'>Emily Navarro</p>"
            + "<p style='font-family:MV Boli;font-size:28px;color:#203a1e;margin:12px 0;'>Dylan Kiedman</p>"
            + "<p style='font-family:MV Boli;font-size:28px;color:#203a1e;margin:12px 0;'>Carlos Cuba</p>"
            + "<p style='font-family:MV Boli;font-size:28px;color:#203a1e;margin:12px 0;'>Narek Sarkiskian Sh.</p>"
            + "</div></html>");
        creditsNamesLabel.setOpaque(false);
        creditsNamesLabel.setVerticalAlignment(JLabel.TOP);
        creditsNamesLabel.setBounds(40, 70, 720, 400);

        closeCreditsButton = new JButton("×");
        closeCreditsButton.setBounds(730, 12, 48, 48);
        closeCreditsButton.setFont(new Font("Arial", Font.BOLD, 28));
        closeCreditsButton.setFocusable(false);
        closeCreditsButton.setBackground(buttonColor);
        closeCreditsButton.setBorder(BorderFactory.createLineBorder(buttonBorderColor, 3));
        closeCreditsButton.addActionListener(this);

        creditsPanel.add(creditsNamesLabel);
        creditsPanel.add(closeCreditsButton);

        add(title);
        add(startButton);
        add(creditButton);
        add(background);
        add(creditsPanel);
        setComponentZOrder(creditsPanel, 0);
        setComponentZOrder(background, getComponentCount() - 1);
        return;
    }

    public void showRoom(){
        setVisible(true);
        return;
    }

    public void hideRoom(){
        setVisible(false);
        return;
    }

     public String getRoom() {
        return null;
     }

    public void disableButtons(){   
    }

    public void activateButtons(){  
    }


    @Override
     public void actionPerformed(ActionEvent e) {
        if(e.getSource() == startButton){
            moveUp();
        }
        else if(e.getSource() == creditButton){
            startButton.setEnabled(false);
            creditButton.setEnabled(false);
            startButton.setRolloverEnabled(false);
            creditButton.setRolloverEnabled(false);
            creditsPanel.setVisible(true);
            setComponentZOrder(creditsPanel, 0);
            creditsPanel.revalidate();
            creditsPanel.repaint();
            SwingUtilities.invokeLater(() -> closeCreditsButton.requestFocusInWindow());
            return;
        }
        else if(e.getSource() == closeCreditsButton){
            creditsPanel.setVisible(false);
            startButton.setEnabled(true);
            creditButton.setEnabled(true);
            startButton.setRolloverEnabled(true);
            creditButton.setRolloverEnabled(true);
            return;
        }
    }

     public void moveUp() {
        Main.switchRooms(layeredPane, links[0], this);
        return;
     }

     public void moveLeft() {
        return;
     }

     public void moveRight() {
        return;
     }

     public void moveDown() {
        return;
     }

     @Override
     public void getLinks(RoomBuilder up, RoomBuilder down, RoomBuilder left, RoomBuilder right) {
        RoomBuilder[] l = new RoomBuilder[4];
        l[0] = up; //startRoom
        l[1] = down;
        l[2] = left;
        l[3] = right;
        links = l;
     }
    }
