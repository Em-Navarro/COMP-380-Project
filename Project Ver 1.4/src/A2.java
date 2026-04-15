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

public class A2 extends JPanel implements ActionListener, RoomBuilder{
    JLayeredPane layeredPane;
    RoomBuilder[] links;
    Player player;

    JLabel label;
    JButton upButton; //deactivate until puzzle solved
    JButton leftButton;
    JButton rightButton;
    A2(JLayeredPane x, Player y){
        setBounds(0,0,1300,1000);
        setOpaque(true);
        setVisible(false);
        setLayout(null);
        layeredPane = x;
        player = y;
    }
     public void create() {
         ImageIcon roomImage = new ImageIcon("../Background Images/A2_Closed.png");
         Image img = roomImage.getImage();
         Image scaledImg = img.getScaledInstance(1300, 1000, Image.SCALE_SMOOTH);
         roomImage = new ImageIcon(scaledImg);

         JLabel background = new JLabel(roomImage);
         background.setBounds(0, 0, 1300, 1000);
         add(background);

        label = new JLabel("A2");
        upButton = new JButton("↑");
        leftButton = new JButton("←");
        rightButton = new JButton("→");
        rightButton.setFont(new Font("Arial", Font.BOLD, 20));
        upButton.setFont(new Font("Arial", Font.BOLD, 20));
        leftButton.setFont(new Font("Arial", Font.BOLD, 20));




         label.setBounds(300,300,1000,100);
        label.setFont(new Font("MV Boli",Font.PLAIN,100));

        upButton.setBounds(600,30,60,60);
        upButton.setEnabled(true); //set enabled true when puzzle is solved
        upButton.setFocusable(false);
        upButton.addActionListener(this);

        leftButton.setBounds(350,250,60,60);
        leftButton.setFocusable(false);
        leftButton.addActionListener(this);

        rightButton.setBounds(850,250,60,60);
        rightButton.setFocusable(false);
        rightButton.addActionListener(this);


        add(label);
        add(upButton);
        add(leftButton);
        add(rightButton);
         // force background behind everything
         setComponentZOrder(background, getComponentCount() - 1);
    }

    public void showRoom() {
        setVisible(true);
    }

    public void hideRoom() {
        setVisible(false);
    }

    public int getIndex() {
        return -4;
    }

    public void moveUp() {
        Main.switchRooms(layeredPane, links[0], this);
        addPlayerComponents((JPanel)links[0]);
    }

    public void moveLeft() {
        Main.switchRooms(layeredPane, links[2], this);
        addPlayerComponents((JPanel)links[2]);
    }

    public void moveRight() {
        Main.switchRooms(layeredPane, links[3], this);
        addPlayerComponents((JPanel)links[3]);
    }

    public void moveDown() {
    }

    public void addPlayerComponents(JPanel panel){
        panel.add(player.getInventory());
    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == upButton){
            moveUp();
        }
        else if(e.getSource() == leftButton){
            moveLeft();
        }
        else if(e.getSource() == rightButton){
            moveRight();
        }
    }

   @Override
     public void getLinks(RoomBuilder up, RoomBuilder down, RoomBuilder left, RoomBuilder right) {
        RoomBuilder[] l = new RoomBuilder[4];
        l[0] = up;//will be b2 when we get there
        l[1] = down;
        l[2] = left;//a1
        l[3] = right;//a3
        links = l;
     }  
}
