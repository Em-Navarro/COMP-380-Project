import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class C3 extends JPanel implements ActionListener, RoomBuilder {
    JLayeredPane layeredPane;
    RoomBuilder[] links;

    JLabel label;
    JButton leftButton;

    public C3(JLayeredPane x) {
        setBounds(0,0,1300,1000);
        setLayout(null);
        setVisible(false);
        layeredPane = x;
    }

    public void create() {
        ImageIcon roomImage = new ImageIcon("Background Images/C3.png");
        Image img = roomImage.getImage();
        Image scaledImg = img.getScaledInstance(1300, 1000, Image.SCALE_SMOOTH);
        roomImage = new ImageIcon(scaledImg);

        JLabel background = new JLabel(roomImage);
        background.setBounds(0, 0, 1300, 1000);
        add(background);

        label = new JLabel("C3");
        label.setBounds(500,300,300,100);
        label.setFont(new Font("MV Boli",Font.PLAIN,80));

        leftButton = new JButton("←");
        leftButton.setBounds(350,250,60,60);
        leftButton.addActionListener(this);
        leftButton.setFont(new Font("Arial", Font.BOLD, 20));


        add(label);
        add(leftButton);
        // force background behind everything
        setComponentZOrder(background, getComponentCount() - 1);
    }

    public void showRoom(){ setVisible(true); }
    public void hideRoom(){ setVisible(false); }

    public int getIndex(){ return -1; }

    public void moveLeft() {
        if(links[2] != null)
            Main.switchRooms(layeredPane, links[2], this);
    }

    public void moveUp() {}
    public void moveDown() {}
    public void moveRight() {}

    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == leftButton) moveLeft();
    }

    public void getLinks(RoomBuilder up, RoomBuilder down, RoomBuilder left, RoomBuilder right) {
        links = new RoomBuilder[]{up, down, left, right};
    }
}