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

public class A3 extends JPanel implements ActionListener, RoomBuilder{
    JLayeredPane layeredPane;
    RoomBuilder[] links;
    Player player;

    JLabel label;
    JButton leftButton;
    A3(JLayeredPane x, Player y){
        setBounds(0,0,1300,1000);
        setOpaque(true);
        setVisible(false);
        setLayout(null);
        layeredPane = x;
        player = y;
    }
     public void create() {
         ImageIcon roomImage = new ImageIcon("./Background Images/A3.png");
         Image img = roomImage.getImage();
         Image scaledImg = img.getScaledInstance(1300, 1000, Image.SCALE_SMOOTH);
         roomImage = new ImageIcon(scaledImg);

         JLabel background = new JLabel(roomImage);
         background.setBounds(0, 0, 1300, 1000);
         add(background);

        label = new JLabel("A3");
        leftButton = new JButton("←");
        leftButton.setFont(new Font("Arial", Font.BOLD, 20));


         label.setBounds(300,300,1000,100);
        label.setFont(new Font("MV Boli",Font.PLAIN,100));

        leftButton.setBounds(350,250,60,60);
        leftButton.setFocusable(false);
        leftButton.addActionListener(this);

        add(label);
        add(leftButton);
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
        return -5;
    }

    public void moveUp() {
    }

    public void moveLeft() {
        Main.switchRooms(layeredPane, links[2], this);
        addPlayerComponents((JPanel)links[2]);
    }

    public void moveRight() {
    }

    public void moveDown() {
    }

    public void addPlayerComponents(JPanel panel){
        panel.add(player.getInventory());
        panel.setComponentZOrder(player.getInventory(), 0);
    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == leftButton){
            moveLeft();
        }
    }

    @Override
     public void getLinks(RoomBuilder up, RoomBuilder down, RoomBuilder left, RoomBuilder right) {
        RoomBuilder[] l = new RoomBuilder[4];
        l[0] = up;
        l[1] = down;
        l[2] = left; //a2
        l[3] = right;
        links = l;
     }   
}
