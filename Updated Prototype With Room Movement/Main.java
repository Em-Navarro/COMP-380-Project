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
        StartScreen startScreen = new StartScreen(layeredPane);
        StartRoom startRoom = new StartRoom(layeredPane);
        A1 a1 = new A1(layeredPane);
        A2 a2 = new A2(layeredPane);
        A3 a3 = new A3(layeredPane);
        //B1 b1 = new B1(layeredPane);
        //B2 b2 = new B2(layeredPane); 
        //B3 b3 = new B3(layeredPane); 
        //C1 c1 = new C1(layeredPane);
        //C2 c2 = new C2(layeredPane); 
        //C3 c3 = new C3(layeredPane); 
        //EndRoom endRoom = new EndRoom(layeredPane);  

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

        startScreen.create();
        startRoom.create();
        a1.create();
        a2.create();
        a3.create();
        //b1.create();
        //b2.create();
        //b3.create();
        //c1.create();
        //c2.create();
        //c3.create();
        //endRoom.create();

        layeredPane.add(startScreen,Integer.valueOf(0));
        //layer -1 could either be buffer or "intro cutscene"
        layeredPane.add(startRoom,Integer.valueOf(-2));
        layeredPane.add(a1,Integer.valueOf(-3));
        layeredPane.add(a2,Integer.valueOf(-4));
        layeredPane.add(a3,Integer.valueOf(-5));
        //add all panels to layeredpane by their layer here

        startScreen.getLinks(startRoom,null,null,null);
        startRoom.getLinks(a1,null,null,null);
        a1.getLinks(null,startRoom,null, a2);
        a2.getLinks(null,null,a1,a3); //add b2 to up when made
        a3.getLinks(null,null,a2,null);
        //b1.getLinks(null,null,null,null);
        //b2.getLinks(null,null,null,null);
        //b3.getLinks(null,null,null,null);
        //c1.getLinks(null,null,null,null);
        //c2.getLinks(null,null,null,null);
        //c3.getLinks(null,null,null,null);
        //endRoom.getLinks(null,null,null,null);
        //put links in later 
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

    public static void switchRooms(JLayeredPane layeredPane, RoomBuilder bringToFront, RoomBuilder sendToBack){
        if(bringToFront == null || sendToBack == null){
            return;
        }
        layeredPane.setLayer((JPanel)sendToBack,sendToBack.getIndex());
        layeredPane.setLayer((JPanel)bringToFront,0);
        bringToFront.showRoom();
        sendToBack.hideRoom();
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
