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

    JLabel label, waterLargeLabel,waterSmallLabel, capacityLargeLabel, capacitySmallLabel;
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
    
    
      
        ImageIcon roomImage = new ImageIcon("Background Images/B1_Closed.png");
        Image img = roomImage.getImage();
        Image scaledImg = img.getScaledInstance(1300, 1000, Image.SCALE_SMOOTH);
        roomImage = new ImageIcon(scaledImg);
        
        
        JLabel background = new JLabel(roomImage);
        background.setBounds(0, 0, 1300, 1000);
        add(background);
        
        label = new JLabel("Water Puzzle");
        label.setBounds(500,150,450,100);
        label.setFont(new Font("MV Boli",Font.PLAIN,70));
        
        waterLargeLabel= new JLabel("0");
        waterLargeLabel.setBounds(265, 400, 60,60);
        waterLargeLabel.setFont(new Font("Arial",Font.BOLD, 60));
        
        capacityLargeLabel = new JLabel("/5");
        capacityLargeLabel.setBounds(295, 400, 75,75);
        capacityLargeLabel.setFont(new Font("Arial",Font.BOLD, 60));
                
        waterSmallLabel= new JLabel("0");
        waterSmallLabel.setBounds(675, 400, 60,60);
        waterSmallLabel.setFont(new Font("Arial",Font.BOLD, 60));


        capacitySmallLabel = new JLabel("/3");
        capacitySmallLabel.setBounds(705, 400, 75,75);
        capacitySmallLabel.setFont(new Font("Arial",Font.BOLD, 60));



        rightButton = new JButton("→");
        rightButton.setBounds(850,250,60,60);
        rightButton.setFont(new Font("Arial", Font.BOLD, 20));
        
        fillLargeButton = new JButton("Fill");
        fillLargeButton.setBounds (150, 600, 100,100);
        fillLargeButton.setFont(new Font("Arial",Font.BOLD, 15));
        
        emptyLargeButton = new JButton("Empty");
        emptyLargeButton.setBounds (260, 600, 100,100);
        emptyLargeButton.setFont(new Font("Arial",Font.BOLD, 15));
        
        transferLargeButton = new JButton("Transfer");
        transferLargeButton.setBounds (370, 600, 100,100);
        transferLargeButton.setFont(new Font("Arial",Font.BOLD, 15));
        
        fillSmallButton = new JButton("Fill");
        fillSmallButton.setBounds (560, 600, 100,100);
        fillSmallButton.setFont(new Font("Arial",Font.BOLD, 15));
        
        emptySmallButton = new JButton("Empty");
        emptySmallButton.setBounds (670, 600, 100,100);
        emptySmallButton.setFont(new Font("Arial",Font.BOLD, 15));
        
        transferSmallButton = new JButton("Transfer");
        transferSmallButton.setBounds (780, 600, 100,100);
        transferSmallButton.setFont(new Font("Arial",Font.BOLD, 15));


        rightButton.addActionListener(this);
        
        fillLargeButton.addActionListener(this);
        emptyLargeButton.addActionListener(this);
        transferLargeButton.addActionListener(this);
        
        fillSmallButton.addActionListener(this);
        emptySmallButton.addActionListener(this);
        transferSmallButton.addActionListener(this);


        add(label);
        add(waterLargeLabel);
        add(waterSmallLabel);
        
        add(capacityLargeLabel);
        add(capacitySmallLabel);
        
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
    
    
  


   public void showRoom(){ setVisible(true); }
    public void hideRoom(){ setVisible(false); }

    public String getRoom() {
        return null;
     }

    public void moveUp() {}

    public void moveDown() {}

    public void moveLeft() {}

    public void moveRight() {
        if(links[3] != null)
            Main.switchRooms(layeredPane, links[3], this);
            addPlayerComponents((JPanel)links[3]);
    }
    
    public void addPlayerComponents(JPanel panel){
        panel.add(player.getInventory());
    }
    
    // this will get replaced with simple animation
    public void changeValueDisplay(JLabel display, int value){
    display.setText ("" + value);     
    } 
    
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == rightButton) moveRight();
        
        if(e.getSource() == fillLargeButton){
        largeContainer.fill();
        changeValueDisplay (waterLargeLabel, largeContainer.water);
        }    
       
        
        if(e.getSource() == emptyLargeButton){
        largeContainer.empty();
        changeValueDisplay (waterLargeLabel, largeContainer.water);
        }  
        
        if(e.getSource() == transferLargeButton){
        largeContainer.transfer(smallContainer);
        changeValueDisplay (waterLargeLabel, largeContainer.water);
        changeValueDisplay (waterSmallLabel, smallContainer.water);
        if (largeContainer.water == 4){
        // victory condition
        // open up path in B1
        }
        }  
        
        
        
        
        if(e.getSource() == fillSmallButton){
        smallContainer.fill();
        changeValueDisplay (waterSmallLabel, smallContainer.water);
        }    
       
        
        if(e.getSource() == emptySmallButton){
        smallContainer.empty();
        changeValueDisplay (waterSmallLabel, smallContainer.water);
        }  
        
        if(e.getSource() == transferSmallButton){
        smallContainer.transfer(largeContainer);
        changeValueDisplay (waterLargeLabel, largeContainer.water);
        changeValueDisplay (waterSmallLabel, smallContainer.water);
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
