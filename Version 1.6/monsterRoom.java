import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class monsterRoom extends JPanel implements ActionListener, RoomBuilder {
    JLayeredPane layeredPane;
    RoomBuilder[] links;
    boolean visited = false;

    JLabel backgroundLabel;
    JButton endButton;

    public monsterRoom(JLayeredPane x) {
        setBounds(0, 0, 1300, 1000);
        setLayout(null);
        setVisible(false);
        layeredPane = x;
    }

    public void create() {
        ImageIcon roomImage = new ImageIcon("Background Images/Monster.png");
        Image img = roomImage.getImage();
        Image scaledImg = img.getScaledInstance(1300, 1000, Image.SCALE_SMOOTH);
        roomImage = new ImageIcon(scaledImg);

        backgroundLabel = new JLabel(roomImage);
        backgroundLabel.setBounds(0, 0, 1300, 1000);

        endButton = new JButton("Game Over");
        endButton.setBounds(925,520,200,50);
        endButton.setFont(new Font("Arial", Font.BOLD, 20));
        endButton.setFocusable(false);
        endButton.addActionListener(this);

        add(backgroundLabel);
        add(endButton);
        setComponentZOrder(backgroundLabel, getComponentCount() - 1);
    }

    public void showRoom() {
        setVisible(true);
        if(!visited){
            disableButtons();
            TextBox.writeToTextBox("Monster Room Text", () ->  activateButtons());
            visited = true;
        }
    }

    public void hideRoom() {
        setVisible(false);
    }

    public String getRoom() {
        return "MR";
    }

    public void moveUp() {
        if (links != null && links[0] != null) {
            Main.switchRooms(layeredPane, links[0], this);
        }
    }

    public void moveDown() {}
    public void moveLeft() {}
    public void moveRight() {}

    public void disableButtons(){ 
    }

    public void activateButtons(){   
    }


    public void getLinks(RoomBuilder up, RoomBuilder down, RoomBuilder left, RoomBuilder right) {
        links = new RoomBuilder[]{up, down, left, right};
    }

    public void restartGame() {
        moveUp();
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == endButton) {
            System.exit(0);
            //restartGame();
        }
    }
}
