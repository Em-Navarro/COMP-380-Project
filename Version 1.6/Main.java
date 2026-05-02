import javax.swing.*;
import java.awt.*;

public class Main {
    static JFrame frame;
    static JLayeredPane layeredPane;
    static Player player;

    public static void main(String[] args) {
        player = new Player();

        frame = new JFrame("Game");
        frame.setSize(1300, 1000);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout(FlowLayout.CENTER,10,10));

        layeredPane = new JLayeredPane();
        layeredPane.setPreferredSize(new Dimension(1300,1000));
        layeredPane.setBounds(0, 0, 1300, 1000);

        //Creating Rooms here
        StartScreen startScreen = new StartScreen(layeredPane);
        StartCutscene startCutscene = new StartCutscene(layeredPane, player);
        StartRoom startRoom = new StartRoom(layeredPane, player);

        A1 a1 = new A1(layeredPane, player);
        A2 a2 = new A2(layeredPane, player);
        A3 a3 = new A3(layeredPane, player);

        B1 b1 = new B1(layeredPane, player);
        B2 b2 = new B2(layeredPane, player);
        B3 b3 = new B3(layeredPane, player);
       
        C2 c2 = new C2(layeredPane, player);
        C3 c3 = new C3(layeredPane, player);

        EndRoom endRoom = new EndRoom(layeredPane, player);
        monsterRoom monsterRoom = new monsterRoom(layeredPane);

        startScreen.create();
        startCutscene.create();
        startRoom.create();

        a1.create();
        a2.create();
        a3.create();

        b1.create();
        b2.create();
        b3.create();
  

        c2.create();
        c3.create();

        endRoom.create();
        monsterRoom.create();

        layeredPane.add(startScreen, Integer.valueOf(0));
        layeredPane.add(startCutscene, Integer.valueOf(0));
        layeredPane.add(startRoom, Integer.valueOf(0));

        layeredPane.add(a1, Integer.valueOf(0));
        layeredPane.add(a2, Integer.valueOf(0));
        layeredPane.add(a3, Integer.valueOf(0));

        layeredPane.add(b1, Integer.valueOf(0));
        layeredPane.add(b2, Integer.valueOf(0));
        layeredPane.add(b3, Integer.valueOf(0));
       
        layeredPane.add(c2, Integer.valueOf(0));
        layeredPane.add(c3, Integer.valueOf(0));

        layeredPane.add(endRoom, Integer.valueOf(0));
        layeredPane.add(monsterRoom, Integer.valueOf(0));

        // ===== LINK ROOMS =====

        // Start
        startScreen.getLinks(startCutscene, null, null, null);

        //Room for cutscene images
        startCutscene.getLinks(startRoom,null,null,null);

        // StartRoom → goes to A1
        startRoom.getLinks(a1, null, null, null);

        // A row
        a1.getLinks(null, startRoom, null, a2);
        a2.getLinks(b2, monsterRoom, a1, a3);
        a3.getLinks(null, null, a2, null);
        monsterRoom.getLinks(startScreen, null, null, null);

        // B row
        b1.getLinks(endRoom, null, null, b2);
        b2.getLinks(c2, a2, b1, b3);
        b3.getLinks(null, null, b2, null);
        

        // C row
        c2.getLinks(endRoom, b2, null, c3);
        c3.getLinks(null, null, c2, null);

        //INITIAL VISIBILITY
        startScreen.showRoom();

        frame.add(layeredPane);
        frame.setVisible(true);
    }

    //ROOM SWITCH METHOD
    public static void switchRooms(JLayeredPane pane, RoomBuilder next, RoomBuilder current) {
        if (next == null) {
            return;
        }
        current.hideRoom();
        next.showRoom();
    }
}
