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

public class StartRoom extends JPanel implements ActionListener, RoomBuilder{
    JLayeredPane layeredPane;
    RoomBuilder[] links;
    Player player;

    JLabel label;
    JButton upButton;
    StartRoom(JLayeredPane x, Player y){
        setBounds(0,0,1300,1000);
        setOpaque(true);
        setVisible(false);
        setLayout(null);
        layeredPane = x;
        player = y;
    }

    public void create() {
        ImageIcon roomImage = new ImageIcon("Background Images/Start_Area.png");
        Image img = roomImage.getImage();
        Image scaledImg = img.getScaledInstance(1300, 1000, Image.SCALE_SMOOTH);
        roomImage = new ImageIcon(scaledImg);

        JLabel background = new JLabel(roomImage);
        background.setBounds(0, 0, 1300, 1000);
        add(background);

        label = new JLabel("Start Room");
        upButton = new JButton("↑");
        upButton.setFont(new Font("Arial", Font.BOLD, 20));

        label.setBounds(300,300,1000,100);
        label.setFont(new Font("MV Boli",Font.PLAIN,100));

        upButton.setBounds(600,30,60,60);
        upButton.setFocusable(false);
        upButton.addActionListener(this);

        add(label);
        add(upButton);
        add(player.getInventory());
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
        return -2;
    }

    public void moveUp() {
        Main.switchRooms(layeredPane, links[0], this);
        addPlayerComponents((JPanel)links[0]);
    }

    public void moveLeft() {
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
        if(e.getSource() == upButton){
            moveUp();
        }
    }

    @Override
     public void getLinks(RoomBuilder up, RoomBuilder down, RoomBuilder left, RoomBuilder right) {
        RoomBuilder[] l = new RoomBuilder[4];
        l[0] = up;//a1
        l[1] = down;
        l[2] = left;
        l[3] = right;
        links = l;
     }
    
}
