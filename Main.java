import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JPanel; 
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.Image;
import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        JFrame frame = new JFrame();
        JLayeredPane layeredPane = new JLayeredPane();
        StartScreen startScreen = new StartScreen();
        //put rest of panel classes here
        //maybe array of panels to intizlize in enhanced for loop?
        JPanel dummyPanel = new JPanel(); //just red rn

        //---end of component declaration/initialization-------------------------

        frame.setTitle("Start Screen Prototype");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);
		frame.setResizable(false);
		frame.setSize(1300,1000);
		frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        layeredPane.setBounds(0,0,1300,1000);
        frame.add(layeredPane);

        dummyPanel.setBounds(0,0,1300,1000);
        dummyPanel.setOpaque(true);
		dummyPanel.setBackground(Color.red);
        dummyPanel.setVisible(true);

        startScreen.create();

        layeredPane.add(startScreen,Integer.valueOf(0));
        layeredPane.add(dummyPanel,Integer.valueOf(-1));

        writeText();
    }

    static void writeText(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Type string below to see it repeated with style lol:");
        String input = scan.nextLine();
        try {
            for(char c: input.toCharArray()){
            System.out.print(c);
            Thread.sleep(100); //change speed here; in milliseconds (seconds x 1000)
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        scan.close();
    } 
}

/* 
Curr room layout im thinking with
------e
|     |
|    c2---c3
|     |
b1---b2---b3
      |
a1---a2---a3
|
s

proposed layeredPane layers for each panel (for getIndex method)

curr block s  a1 a2 a3 b1 b2 b3 c2 c3  e
  0   -1  -2 -3 -4 -5 -6 -7 -8 -9 -10 -11

  key:
  s = start
  e = end
  curr = current panel being shown
  block = panel that hides behind/show us if we did something wrong

  **further slots can be for options button and water puzzle panel
  **maybe lock buttons until texts panel finishes in text box
*/
