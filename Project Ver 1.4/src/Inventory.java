import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;

public class Inventory extends JPanel implements ActionListener{
    JButton[] slots; 

    Inventory(){
        setBounds(950,100,200,500);
        setBackground(Color.DARK_GRAY);
        setOpaque(true);
        setVisible(true);
        setLayout(null);
    }

    void create(){
        slots = new JButton[4];

        slots[0] = new JButton("0"); //add siloutee images maybe or just darked out
        slots[1] = new JButton("1");
        slots[2] = new JButton("2");
        slots[3] = new JButton("3");

        slots[0].setFocusable(false);
        slots[1].setFocusable(false);
        slots[2].setFocusable(false);
        slots[3].setFocusable(false);

        slots[0].setEnabled(false);
        slots[1].setEnabled(false);
        slots[2].setEnabled(false);
        slots[3].setEnabled(false);

        slots[0].setBounds(50,20,100,100);
        slots[1].setBounds(50,140,100,100);
        slots[2].setBounds(50,260,100,100);
        slots[3].setBounds(50,380,100,100);

        add(slots[0]);
        add(slots[1]);
        add(slots[2]);
        add(slots[3]);
    }

    public JPanel getPanel(){
        return this;
    }

    void getItemZero(){
        slots[0].setEnabled(true);
    }

    void getItemOne(){
        slots[1].setEnabled(true);
    }

    void getItemTwo(){
        slots[2].setEnabled(true);
    }

    void getItemThree(){
        slots[3].setEnabled(true);
    }

    public void actionPerformed(ActionEvent e){
        
    }
    
}
