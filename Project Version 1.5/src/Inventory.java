import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.BorderFactory;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;

public class Inventory extends JPanel implements ActionListener{
    static JButton[] slots;
    static boolean hasKeyItem = false;
    static boolean hasNoteItem = false;
    Color panelColor = Color.decode("#18230F");
    Color borderColor = Color.decode("#27391C");
    Color buttonColor = Color.decode("#1F7D53");
    Color buttonBorderColor = Color.decode("#255F38");
    

    Inventory(){
        setBounds(1050,25,200,500);
        setBackground(panelColor);
        setOpaque(true);
        setVisible(true);
        setLayout(null);
        setBorder(BorderFactory.createLineBorder(borderColor,10));
    }

    void create(){
        slots = new JButton[4];

        slots[0] = new JButton("0"); //add siloutee images maybe or just darked out
        slots[1] = new JButton("1");
        slots[2] = new JButton("2");
        slots[3] = new JButton("3");

        slots[0].setBounds(50,20,100,100);
        slots[1].setBounds(50,140,100,100);
        slots[2].setBounds(50,260,100,100);
        slots[3].setBounds(50,380,100,100);

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
        slots[1].setText("Note");
        hasNoteItem = true;
    }

    public static void getItemTwo(){
        slots[2].setEnabled(true);
    }

    public static void getItemThree(){
        slots[3].setEnabled(true);
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
        if (!hasNoteItem) return;
        if (!"C2".equals(Player.getCurrentLocation())) return;

        C2.unlockGateWithNote();
        hasNoteItem = false;
        slots[1].setText("Used");
        slots[1].setEnabled(false);
    }

    public static void useItemTwo(){
        
    }

    public static void useItemThree(){
        
    }

    public void actionPerformed(ActionEvent e){
        if (e.getSource() == slots[0]) {
            useItemZero();
        } else if (e.getSource() == slots[1]) {
            useItemOne();
        }
    }
    
}
