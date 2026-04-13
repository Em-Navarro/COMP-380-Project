import javax.swing.JPanel;

public class Player {
    Inventory inventory;
    //map soon
    
    Player(){
        inventory = new Inventory();
        inventory.create();
        //map = new Map();
        //map.create(); //would also have a getMap method to get the button/panel 
    }

    JPanel getInventory(){
        return inventory.getPanel();
    }

}
