public interface RoomBuilder {
    public void create(); //initilize/add all components to panel
    public void showRoom(); //put setVisible(true) to all components
    public void hideRoom(); // put setVisible(false) to all components
    public String getRoom(); //return string with room, so player can track where they are
    public void getLinks(RoomBuilder up, RoomBuilder down, RoomBuilder left, RoomBuilder right);
    public void disableButtons();
    public void activateButtons();
    //^ put references to each room for movement, initialized in main
    /*
    -below methods could be empty methods if curr room doesn't have that option
    --would be inside the actionPerformed if-else tower
    */ 
    public void moveUp();
    public void moveDown();
    public void moveLeft();
    public void moveRight();
}