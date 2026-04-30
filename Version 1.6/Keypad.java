import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class Keypad extends JPanel implements ActionListener {
   JButton one,two,three,four,five,six,seven,eight,nine,zero;
   JButton clear, check;
   JTextField display;
   String code = "";
   boolean complete = false;
   C2 c2;

   JPanel buttonPanel;
   

    Keypad(C2 room){
        setBounds(260, 150, 300,500);
        setBackground(Color.darkGray);
        
        setVisible(false);
        setLayout(null);
        c2 = room;

    }
    public void create(){
        display = new JTextField();
        display.setBounds(50,10,200, 100 );
        display.setFont(new Font("helvetica",Font.BOLD, 80));
        display.setForeground(Color.white);
        display.setBackground(Color.black);

        buttonPanel = new JPanel();
        buttonPanel.setBounds(50, 110, 200, 300);
        buttonPanel.setLayout(new GridLayout(4,3,1,1));


        one = new JButton("1");
        two = new JButton("2");
        three = new JButton("3");
        four = new JButton("4");
        five = new JButton("5");
        six = new JButton("6");
        seven = new JButton("7");
        eight = new JButton("8");
        nine = new JButton("9");
        zero = new JButton("0");
        clear = new JButton("X");
        check = new JButton("✓");



        buttonPanel.add(one);
        buttonPanel.add(two);
        buttonPanel.add(three);

        buttonPanel.add(four);
        buttonPanel.add(five);
        buttonPanel.add(six);


        buttonPanel.add(seven);
        buttonPanel.add(eight);
        buttonPanel.add(nine);

        buttonPanel.add(clear);
        buttonPanel.add(zero);
        buttonPanel.add(check);

        one.addActionListener(this);
        two.addActionListener(this);
        three.addActionListener(this);
        four.addActionListener(this);
        five.addActionListener(this);
        six.addActionListener(this);
        seven.addActionListener(this);
        eight.addActionListener(this);
        nine.addActionListener(this);
        zero.addActionListener(this);

        clear.addActionListener(this);
        check.addActionListener(this);










        add(display);
        add(buttonPanel);


   

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == one){
          if (code.length() < 4) {
              code = code + "1";
              display.setText(code);
          }
        }
        else if(e.getSource() == two) {
            if (code.length() < 4) {
                code = code + "2";
                display.setText(code);
            }
        }
         else   if(e.getSource() == three){
                if (code.length() < 4) {
                    code = code + "3";
                    display.setText(code);
                }
            }

            else if(e.getSource() == four ){
                if (code.length() < 4) {
                    code = code + "4";
                    display.setText(code);
                }
            }
          else  if(e.getSource() == five){
                if (code.length() < 4) {
                    code = code + "5";
                    display.setText(code);
                }
            }
            else if(e.getSource() == six){
                if (code.length() < 4) {
                    code = code + "6";
                    display.setText(code);
                }
            }
            else if(e.getSource() == seven){
                if (code.length() < 4) {
                    code = code + "7";
                    display.setText(code);
                }
            }
            else if(e.getSource() == eight){
                if (code.length() < 4) {
                    code = code + "8";
                    display.setText(code);
                }
            }
            else if(e.getSource() == nine){
                if (code.length() < 4) {
                    code = code + "9";
                    display.setText(code);
                }
            }
            else if(e.getSource() == zero){
                if (code.length() < 4) {
                    code = code + "0";
                    display.setText(code);
                }
            }
            else if (e.getSource() ==clear){
              if (!complete) {
                  code = "";
                  display.setText(code);
                  display.setForeground(Color.white);
              }
        }
            else if (e.getSource() == check){
                if (Objects.equals(code, "1726")){
                    display.setForeground(Color.green);
                    c2.unlockGate();
                    complete = true;

                }
                else {
                    display.setForeground(Color.red);
                }

        }


        }



}