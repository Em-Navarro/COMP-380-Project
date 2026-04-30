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

public class StartScreen extends JPanel implements ActionListener, RoomBuilder{
    JLayeredPane layeredPane;
    RoomBuilder[] links;
    

    JLabel title;
    JLabel background;
    JButton startButton; // maybe drawn buttons
    JButton creditButton;
    ImageIcon backgroundImage;

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

        creditButton.setBounds(400,400,500,100);
        creditButton.setFocusable(false);
        creditButton.addActionListener(this);
        
        add(title);
        add(startButton);
        add(creditButton);
        add(background);
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
            System.out.println("Options pressed");
            //probably its own class since its not a room; can't implement roombuilder
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
