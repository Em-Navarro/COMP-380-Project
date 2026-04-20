import javax.swing.JPanel;
import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import java.awt.Font;


public class TextBox extends JPanel{
    Color panelColor = Color.decode("#18230F");
    Color borderColor = Color.decode("#27391C");
    JLabel label;

    TextBox(){
        setBounds(100,550,925,150);
        setBackground(panelColor);
        setBorder(BorderFactory.createLineBorder(borderColor,10));
        setLayout(new FlowLayout(FlowLayout.LEFT));
    }

    void create(){
        label = new JLabel();
        label.setBounds(100,550,925,150);
        label.setFont(new Font("MV Boli",Font.PLAIN,20));
        label.setForeground(Color.white);
        label.setText("<html><body style='width: 675px; padding: 5px;'>This is a really long string that I am trying to see will wrap around if I put html tags around them. IDk what to type I just want to make sure that the wrapping is working so Im going to keep typing until I think I put enough words to show it working.</html>");
        //could also use <html>Long<br>String</html> to add a break in the middle
        add(label);
    }

    static void writeToTextBox(){

    }
}
