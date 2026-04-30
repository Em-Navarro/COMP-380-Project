import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.BorderFactory;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Inventory extends JPanel implements ActionListener{
    static JButton[] slots;
    static boolean hasKeyItem = false;
    static boolean hasItemOne = false;
    static boolean hasItemTwo = false;
    Color panelColor = Color.decode("#2f3123");
    Color borderColor = Color.decode("#56584b");
    Color buttonColor = Color.decode("#7d6b45");
    Color buttonBorderColor = Color.decode("#c4ae86");
    

    Inventory(){
        setBounds(1050,50,200,380);
        setBackground(panelColor);
        setOpaque(true);
        setVisible(true);
        setLayout(null);
        setBorder(BorderFactory.createLineBorder(borderColor,10));
    }

    void create(){
        slots = new JButton[3];

        slots[0] = new JButton();
        slots[1] = new JButton();
        slots[2] = new JButton();

        slots[0].setBounds(50,20,100,100);
        slots[1].setBounds(50,140,100,100);
        slots[2].setBounds(50,260,100,100);

        for(JButton button:slots){
            button.setFocusable(false);
            button.setEnabled(false);
            button.setBackground(buttonColor);
            button.setBorder(BorderFactory.createLineBorder(buttonBorderColor,10));
            button.addActionListener(this);
            add(button);
        }
    }

    public JPanel getPanel(){
        return this;
    }

    public static void getItemZero(){
        slots[0].setEnabled(true);
        slots[0].setText("Key");
        hasKeyItem = true;
    }

    public static void getItemOne(){
        slots[1].setEnabled(true);
        slots[1].setText("B3 Note");
        hasItemOne = true;
    }

    public static void getItemTwo(){
        slots[2].setEnabled(true);
        slots[2].setText("C3 Note");
        hasItemTwo = true;
    }

    public static void useItemZero(){
        if (!hasKeyItem) return;
        if (!"A2".equals(Player.getCurrentLocation())) return;

        A2.unlockGateWithKey();
        hasKeyItem = false;
        slots[0].setText("Used");
        slots[0].setEnabled(false);
    }

    public static void useItemOne(){
        if (!hasItemOne) return;
        if ("B2".equals(Player.getCurrentLocation())) {
            B2.tryUnlockGateWithCodePrompt();
        }
    }

    public static void markItemOneUsed(){
        hasItemOne = false;
        slots[1].setText("Used");
        slots[1].setEnabled(false);
    }

    public static void useItemTwo(){
        if (!hasItemTwo) return;
        if ("C2".equals(Player.getCurrentLocation())) {
            //C2.unlockGateWithNote();
            hasItemTwo = false;
            slots[2].setText("Used");
            slots[2].setEnabled(false);
            return;
        }
        if ("B2".equals(Player.getCurrentLocation())) {
            B2.tryUnlockGateWithCodePrompt();
        }
    }

    public static boolean hasItemTwo() {
        return hasItemTwo;
    }

    public void actionPerformed(ActionEvent e){
        if (e.getSource() == slots[0]) {
            useItemZero();
        } else if (e.getSource() == slots[1]) {
            useItemOne();
        } else if (e.getSource() == slots[2]) {
            useItemTwo();
        }
    }
    
}
