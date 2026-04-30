import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

    class Container {
    public final int size;
    public int water = 0;

    public Container(int size) {
        this.size = size;
    }

  
    public int capacity(){
        return size - water;
    }
    
    public void fill (){
        this.water = this.size;
             
    }
    public  void empty (){
        this.water = 0;
        
    }
     public void transfer(Container destination){
        if (this.water <= destination.capacity()){
            destination.water+= this.water;
            this.empty();
           
                   } else {
            this.water -= destination.capacity();
            destination.fill();
            
        
        }
    }
    }
    
    
public class WaterPuzzle extends JPanel implements ActionListener, RoomBuilder {
    JLayeredPane layeredPane;
    RoomBuilder[] links;
    Player player;

    JLabel smallOneLabel, smallTwoLabel, largeOneLabel, largeTwoLabel, largeThreeLabel, largeFourLabel;
    JButton rightButton, fillLargeButton, emptyLargeButton, transferLargeButton, fillSmallButton, emptySmallButton, transferSmallButton;
    Container smallContainer = new Container(3);
    Container largeContainer = new Container(5);
    
    public WaterPuzzle(JLayeredPane x, Player y) {
        setBounds(0,0,1300,1000);
        setLayout(null);
        setVisible(false);
        layeredPane = x;
        player =y;
    }
    
    public void create(){
    
    
      
        ImageIcon roomImage = new ImageIcon("src/Background Images/B1_Closed.png");
        Image img = roomImage.getImage();
        Image scaledImg = img.getScaledInstance(1300, 1000, Image.SCALE_SMOOTH);
        roomImage = new ImageIcon(scaledImg);
        
        
        JLabel background = new JLabel(roomImage);
        background.setBounds(0, 0, 1300, 1000);
        add(background);
        
     
        smallOneLabel = new JLabel("1");
        smallOneLabel. setBounds(215,315,30,30);
        smallOneLabel.setFont(new Font("MV Boli",Font.PLAIN,30));
        smallOneLabel.setForeground(Color.white);

        smallTwoLabel = new JLabel("2");
        smallTwoLabel. setBounds(215,255,30,30);
        smallTwoLabel.setFont(new Font("MV Boli",Font.PLAIN,30));
        smallTwoLabel.setForeground(Color.white);

        largeOneLabel = new JLabel("1");
        largeOneLabel. setBounds(565,315,30,30);
        largeOneLabel.setFont(new Font("MV Boli",Font.PLAIN,30));
        largeOneLabel.setForeground(Color.white);

        largeTwoLabel = new JLabel("2");
        largeTwoLabel. setBounds(565,255,30,30);
        largeTwoLabel.setFont(new Font("MV Boli",Font.PLAIN,30));
        largeTwoLabel.setForeground(Color.white);



        largeThreeLabel = new JLabel("3");
        largeThreeLabel. setBounds(565,195,30,30);
        largeThreeLabel.setFont(new Font("MV Boli",Font.PLAIN,30));
        largeThreeLabel.setForeground(Color.white);

        largeFourLabel = new JLabel("4");
        largeFourLabel. setBounds(565,135,30,30);
        largeFourLabel.setFont(new Font("MV Boli",Font.PLAIN,30));
        largeFourLabel.setForeground(Color.white);



        rightButton = new JButton("→");
        rightButton.setBounds(850,250,60,60);
        rightButton.setFont(new Font("Arial", Font.BOLD, 20));
        
        fillLargeButton = new JButton("Fill");
        fillLargeButton.setBounds (370, 400, 85,85);
        fillLargeButton.setFont(new Font("Arial",Font.BOLD, 13));
        
        emptyLargeButton = new JButton("Empty");
        emptyLargeButton.setBounds (470, 400, 85,85);
        emptyLargeButton.setFont(new Font("Arial",Font.BOLD, 13));
        
        transferLargeButton = new JButton("Transfer");
        transferLargeButton.setBounds (570, 400, 85,85);
        transferLargeButton.setFont(new Font("Arial",Font.BOLD, 13));
        
        fillSmallButton = new JButton("Fill");
        fillSmallButton.setBounds (20, 400, 85,85);
        fillSmallButton.setFont(new Font("Arial",Font.BOLD, 13));
        
        emptySmallButton = new JButton("Empty");
        emptySmallButton.setBounds (120, 400, 85,85);
        emptySmallButton.setFont(new Font("Arial",Font.BOLD, 13));
        
        transferSmallButton = new JButton("Transfer");
        transferSmallButton.setBounds (220, 400, 85,85);
        transferSmallButton.setFont(new Font("Arial",Font.BOLD, 13));


        rightButton.addActionListener(this);
        
        fillLargeButton.addActionListener(this);
        emptyLargeButton.addActionListener(this);
        transferLargeButton.addActionListener(this);
        
        fillSmallButton.addActionListener(this);
        emptySmallButton.addActionListener(this);
        transferSmallButton.addActionListener(this);


 
        add(smallOneLabel);
        add(smallTwoLabel);

        add(largeOneLabel);
        add(largeTwoLabel);
        add(largeThreeLabel);
        add(largeFourLabel);


        add(rightButton);
        
        add(fillLargeButton);
        add(emptyLargeButton);
        add(transferLargeButton);
        
        add(fillSmallButton);
        add(emptySmallButton);
        add(transferSmallButton);
        // force background behind everything
        setComponentZOrder(background, getComponentCount() - 1);
        
        
        
        
      
    }
    
    


 public void paint(Graphics g){

super.paint(g);
   Graphics2D g2D =(Graphics2D) g;



     g2D.setPaint(Color.black);
     g2D.setStroke(new BasicStroke(5));

     //large container
     g2D.drawRect(460, 90, 100, 300);
     g2D.setPaint(Color.cyan);
     g2D.fillRect(462,392- 60 * largeContainer.water  , 95, (60* largeContainer.water )-4 );
     g2D.setPaint(Color.yellow);
     g2D. drawLine(465,150,555, 150);
     g2D.setPaint(Color.lightGray);
     g2D. drawLine(465,210,555, 210);
     g2D. drawLine(465,270,555, 270);
     g2D. drawLine(465,330,555, 330);


     //small container
     g2D.setPaint(Color.black);
     g2D.drawRect(110, 210, 100, 180);
     g2D.setPaint(Color.cyan);
     g2D.fillRect(112,392 - 60 * smallContainer.water , 95, (60* smallContainer.water)- 4);

     g2D.setPaint(Color.lightGray);

     g2D. drawLine(114,270,206, 270);
     g2D. drawLine(114,330,206, 330);

 }


   public void showRoom(){ setVisible(true); }
    public void hideRoom(){ setVisible(false); }

    public String getRoom() {
        return "BW";
     }

    public void moveUp() {}

    public void moveDown() {}

    public void moveLeft() {}

    public void moveRight() {
        if(links[3] != null)
        Main.switchRooms(layeredPane, links[3], this);
        Player.changeCurrentLocation(links[3].getRoom());
        addPlayerComponents((JPanel)links[3]);
    }
    
    public void addPlayerComponents(JPanel panel){
        panel.add(player.getInventory());
        panel.add(player.getTextBox());
        panel.setComponentZOrder(player.getInventory(), 0);
        panel.setComponentZOrder(player.getTextBox(), 0);
    }
    
    public void disableButtons(){   
    }

    public void activateButtons(){  
    }


    
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == rightButton) moveRight();
        
        if(e.getSource() == fillLargeButton){
        largeContainer.fill();
      
        repaint();
        }    
       
        
        if(e.getSource() == emptyLargeButton){
        largeContainer.empty();
        repaint();
        }  
        
        if(e.getSource() == transferLargeButton){
        largeContainer.transfer(smallContainer);

        repaint();
        if (largeContainer.water == 4){
        // victory condition
        // open up path in B1
        }
        }  
        
        
        
        
        if(e.getSource() == fillSmallButton){
        smallContainer.fill();

        repaint();
        }    
       
        
        if(e.getSource() == emptySmallButton){
        smallContainer.empty();
 
        repaint();
        }  
        
        if(e.getSource() == transferSmallButton){
        smallContainer.transfer(largeContainer);
     
        repaint();
        if (largeContainer.water == 4){
        // victory condition
        // open up path in B1
        }
        }  

        
           }
    
    
      public void getLinks(RoomBuilder up, RoomBuilder down, RoomBuilder left, RoomBuilder right) {
        links = new RoomBuilder[]{up, down, left, right};
    }
}
