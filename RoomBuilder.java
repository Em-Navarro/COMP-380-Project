public interface RoomBuilder {
    public void create(); //initilize/add all components to panel
    public void showRoom(); //put setVisible(true) to all components
    public void hideRoom(); // put setVisible(false) to all components
    public int getIndex(); //put index in which the frame resides in the backscenes
    /*
    -below methods could be empty methods if curr room doesn't have that option
    --would be inside the actionPerformed if-else tower
    */ 
    public void moveUp();
    public void moveLeft();
    public void moveRight();
    public void MoveDown();
    //maybe add map button/inventory/textbox
    //also maybe have switch method in here too??
}

        /* Random example for changing sizing of image i remember that could be useful	
        xIcon = new ImageIcon("xMark.png"); //xIcon of type ImageIcon 
		Image newX = xIcon.getImage();
		Image croppedXImage = newX.getScaledInstance(100,100,Image.SCALE_SMOOTH);//size change here
		xIcon = new ImageIcon(croppedXImage); 
        */
