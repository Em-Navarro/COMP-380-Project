import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class B3 extends JPanel implements ActionListener, RoomBuilder {
    JLayeredPane layeredPane;
    RoomBuilder[] links;
    Player player;

    JLabel label;
    JButton leftButton;

    public B3(JLayeredPane x, Player y) {
        setBounds(0,0,1300,1000);
        setLayout(null);
        setVisible(false);
        layeredPane = x;
        player = y;
    }

    public void create() {
        ImageIcon roomImage = new ImageIcon("Background Images/B3.png");
        Image img = roomImage.getImage();
        Image scaledImg = img.getScaledInstance(1300, 1000, Image.SCALE_SMOOTH);
        roomImage = new ImageIcon(scaledImg);

        JLabel background = new JLabel(roomImage);
        background.setBounds(0, 0, 1300, 1000);
        add(background);

        label = new JLabel("B3");
        label.setBounds(500,300,300,100);
        label.setFont(new Font("MV Boli",Font.PLAIN,80));

        leftButton = new JButton("←");
        leftButton.setBounds(350,250,60,60);
        leftButton.setFont(new Font("Arial", Font.BOLD, 20));

        leftButton.addActionListener(this);

        add(label);
        add(leftButton);
        // force background behind everything
        setComponentZOrder(background, getComponentCount() - 1);
    }

    public void showRoom(){ setVisible(true); }
    public void hideRoom(){ setVisible(false); }

    public int getIndex(){ return -1; }

    public void moveLeft() {
        if(links[2] != null){
            Main.switchRooms(layeredPane, links[2], this);
            addPlayerComponents((JPanel)links[2]);
        }
    }

    public void moveUp() {}
    public void moveDown() {}
    public void moveRight() {}

    public void addPlayerComponents(JPanel panel){
        panel.add(player.getInventory());
    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == leftButton) moveLeft();
    }

    public void getLinks(RoomBuilder up, RoomBuilder down, RoomBuilder left, RoomBuilder right) {
        links = new RoomBuilder[]{up, down, left, right};
    }
}