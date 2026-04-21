import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class Player {
    Inventory inventory;
    //Map map;
    JPanel textBox = new JPanel();
    Color panelColor = Color.decode("#18230F");
    Color borderColor = Color.decode("#27391C");
    
    Player(){
        inventory = new Inventory();
        inventory.create();
        //map = new Map();
        //map.create(); //would also have a getMap method to get the button/panel 
        textBox.setBounds(200,600,925,200);
        textBox.setBackground(panelColor);
        textBox.setBorder(BorderFactory.createLineBorder(borderColor,10));
    }

    JPanel getInventory(){
        return inventory.getPanel();
    }

    /*
    JPanel getMap(){
        return map.getPanel();
    } */

    JPanel getTextBox(){
        return textBox;
    }

}
