import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class C3 extends JPanel implements ActionListener, RoomBuilder, MouseListener {
    JLayeredPane layeredPane;
    RoomBuilder[] links;
    Player player;
    boolean visited = false;

    JLabel label;
    JLabel note;
    JButton leftButton;

    public C3(JLayeredPane x, Player y) {
        setBounds(0,0,1300,1000);
        setLayout(null);
        setVisible(false);
        layeredPane = x;
        player = y;
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
        //label.setBounds(500,300,300,100);
        //label.setFont(new Font("MV Boli",Font.PLAIN,80));

        ImageIcon noteIcon = new ImageIcon("Background Images/Item_Note_200x200.png");
        note = new JLabel();
        note.setIcon(noteIcon);
        note.setBounds(500,410,200,200);
        note.setVisible(true);
        note.addMouseListener(this);

        leftButton = new JButton("←");
        leftButton.setBounds(350,250,60,60);
        leftButton.addActionListener(this);
        leftButton.setFont(new Font("Arial", Font.BOLD, 20));


        add(label);
        add(note);
        add(leftButton);
        // force background behind everything
        setComponentZOrder(background, getComponentCount() - 1);
    }

    public void showRoom(){
        setVisible(true);
        if(!visited){
            disableButtons();
            TextBox.writeToTextBox("Any hints in here? Maybe?", () ->  activateButtons());
            visited = true;
        }
        else{
          TextBox.writeToTextBox(" ", null);  
        } 
    }
    public void hideRoom(){ setVisible(false); }

    public String getRoom() {
        return "C3";
     }

    public void moveLeft() {
        if(links[2] != null){
            Main.switchRooms(layeredPane, links[2], this);
            Player.changeCurrentLocation(links[2].getRoom());
            addPlayerComponents((JPanel)links[2]);
        }
    }

    public void moveUp() {}
    public void moveDown() {}
    public void moveRight() {}

    public void addPlayerComponents(JPanel panel){
        panel.add(player.getInventory());
        panel.add(player.getTextBox());
        panel.setComponentZOrder(player.getInventory(), 0);
        panel.setComponentZOrder(player.getTextBox(), 0);
    }

    public void disableButtons(){
        leftButton.setEnabled(false);     
    }

    public void activateButtons(){
        leftButton.setEnabled(true);  
    }


    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == leftButton) moveLeft();
    }

    public void getLinks(RoomBuilder up, RoomBuilder down, RoomBuilder left, RoomBuilder right) {
        links = new RoomBuilder[]{up, down, left, right};
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        Inventory.getItemTwo();
        remove(note);
        revalidate();
        repaint();
    }

    @Override
    public void mousePressed(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}
}