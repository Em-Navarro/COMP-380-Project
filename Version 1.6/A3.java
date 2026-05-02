import javax.swing.JPanel;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton; 
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import java.awt.Image;

public class A3 extends JPanel implements ActionListener, RoomBuilder, MouseListener{
    JLayeredPane layeredPane;
    RoomBuilder[] links;
    Player player;
    boolean visited = false;

    
    JLabel key;
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
        ImageIcon roomImage = new ImageIcon("Background Images/A3.png");
        Image img = roomImage.getImage();
        Image scaledImg = img.getScaledInstance(1300, 1000, Image.SCALE_SMOOTH);
        roomImage = new ImageIcon(scaledImg);

        JLabel background = new JLabel(roomImage);
        background.setBounds(0, 0, 1300, 1000);

       

        ImageIcon keyIcon = new ImageIcon("Background Images/Item_Key_200x200.png");
        key = new JLabel();
        key.setIcon(keyIcon);
        key.setBounds(850,450,200,200);
        key.setVisible(true);
        key.addMouseListener(this);

        leftButton = new JButton("←");
        leftButton.setFont(new Font("Arial", Font.BOLD, 20));
        leftButton.setBounds(350,250,60,60);
        leftButton.setFocusable(false);
        leftButton.addActionListener(this);

        add(key);
        add(leftButton);
        add(background);
         // force background behind everything
         setComponentZOrder(background, getComponentCount() - 1);

     }

    public void showRoom() {
        setVisible(true);
        if(!visited){
            disableButtons();
            TextBox.writeToTextBox("Hmmm...is there something that could help...?", () ->  activateButtons());
            visited = true;
        }
        else{
          TextBox.writeToTextBox(" ", null);  
        }
    }

    public void hideRoom() {
        setVisible(false);
    }

    public String getRoom() {
        return "A3";
     }

    public void moveUp() {
    }

    public void moveLeft() {
        Main.switchRooms(layeredPane, links[2], this);
        Player.changeCurrentLocation(links[2].getRoom());
        addPlayerComponents((JPanel)links[2]);
    }

    public void moveRight() {
    }

    public void moveDown() {
    }

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
        if(e.getSource() == leftButton){
            moveLeft();
        }
    }

    @Override
   public void mouseClicked(MouseEvent e) {
    //pressed and released
    Inventory.getItemZero();
    remove(key);
    revalidate();
    repaint();
   }
   @Override
   public void mousePressed(MouseEvent e) {
    //only the pressing down
   }
   @Override
   public void mouseReleased(MouseEvent e) {
    //only the release
   }
   @Override
   public void mouseEntered(MouseEvent e) {
    //when mouse goes inside the object with listener
   }
   @Override
   public void mouseExited(MouseEvent e) {
    //when mouse leaves the object with listener
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
