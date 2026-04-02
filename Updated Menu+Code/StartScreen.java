import javax.swing.JPanel;
import javax.swing.JLabel; 
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton; 
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import java.awt.Image;

public class StartScreen extends JPanel implements ActionListener, RoomBuilder{
    JLabel title;
    JLabel background;
    JButton startButton; // maybe drawn buttons
    JButton optionButton;
    ImageIcon backgroundImage;

    public StartScreen(){
        setBounds(0,0,1300,1000);
        setOpaque(true);
		//setBackground(Color.darkGray);
        setVisible(true);
        setLayout(null);
        return;
    }

    public void create(){
        title = new JLabel("We Need A Title");
        startButton = new JButton("Start");
        optionButton = new JButton("Options");

        title.setBounds(150,120,1000,100);
        title.setHorizontalAlignment(JLabel.CENTER);
        title.setForeground(Color.green);
        title.setFont(new Font("MV Boli",Font.PLAIN,100));

        //maybe a special background
        backgroundImage = new ImageIcon("Temp_Background.png");
		Image newImage = backgroundImage.getImage();
		Image resizedImage = newImage.getScaledInstance(1300,1000,Image.SCALE_SMOOTH);
		backgroundImage = new ImageIcon(resizedImage); 
        background = new JLabel(backgroundImage);
        background.setBounds(0,0,1300,1000);

        startButton.setBounds(400,250,500,100);
        startButton.setFocusable(false);
        startButton.addActionListener(this);

        optionButton.setBounds(400,400,500,100);
        optionButton.setFocusable(false);
        optionButton.addActionListener(this);
        
        add(title);
        add(startButton);
        add(optionButton);
        add(background);
        return;
    }

    public void showRoom(){
        setVisible(true);
        validate();
        repaint();
        return;
    }

    public void hideRoom(){
        setVisible(false);
        validate();
        repaint();
        return;
    }

     public int getIndex() {
        return -2;
     }

     public void moveUp() {
        return;
     }

     public void moveLeft() {
        return;
     }

     public void moveRight() {
        return;
     }

     public void MoveDown() {
        return;
     }

    @Override
     public void actionPerformed(ActionEvent e) {
        if(e.getSource() == startButton){
            hideRoom();
        }
        else if(e.getSource() == optionButton){
            System.out.println("Options pressed");
            //probably its own class since its not a room; can't implement roombuilder
            return;
        }
    }
}
