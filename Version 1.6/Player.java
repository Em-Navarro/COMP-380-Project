import javax.swing.JPanel;

public class Player{
    static Inventory inventory;
    static TextBox textBox;
    static String currLocation; //change with
    
    Player(){
        inventory = new Inventory();
        inventory.create();
        textBox = new TextBox();
        textBox.create();
        currLocation = "SR";
        //SR = start room, ER = End room, rest are just A1, A2, etc
    }

    JPanel getInventory(){
        return inventory.getPanel();
    }

    JPanel getTextBox(){
        return textBox;
    }

    static void changeCurrentLocation(String loc){
        currLocation = loc;
        System.out.println(currLocation);
    }

    static String getCurrentLocation(){
        return currLocation;
    }

}
