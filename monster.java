import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
/**
 * Write a description of class monster here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class monster extends Actor
{
    /**
     * Act - do whatever the monster wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    //public void act(){}
    private GreenfootImage image1, image2;
    
    private int currentImage, direction;
    private long imageSwapCounter;

    private static final int RIGHT = 0;
    private static final int LEFT = 1;
    private static final int UP = 2;
    private static final int DOWN = 3;

    
    private String []word = {"right","left","up","down"};
    public monster() {

        image1 = new GreenfootImage("g1.png");
        image2 = new GreenfootImage("g2.png");

        

        currentImage = 0;
        imageSwapCounter = System.currentTimeMillis();

        setImage(image1);
        
    }

    public void act() {
        
        picmonster();
        /*if(canMove()) {
            moveAround();
            
        } else {
            switchDirection();
        }*/
    }    
    public void picmonster() {

        if(System.currentTimeMillis() - imageSwapCounter > 100) {
            imageSwapCounter = System.currentTimeMillis();
            currentImage++;
            if(currentImage > 1) {
                currentImage = 0;
            }
            if(currentImage == 0) {
                setImage(image1);
            } else {
                setImage(image2);
            }
        }
        if(isTouching(player.class)){
            Greenfoot.stop();
            Greenfoot.playSound("Dead.wav");
            Greenfoot.setWorld(new EndScore());
        }
    }
    /*public void moveAround() {

        if(!canMove()) {
            return;
        }

        switch(direction) {
            case RIGHT: move(1); break;
            case LEFT: move(-1); break;
            case UP: setLocation(getX(), getY() - 1); break;
            case DOWN: setLocation(getX(), getY() + 1); break;
        }
    }
    public boolean canMove() {

        World world = getWorld();
        GreenfootImage background = world.getBackground();

        int x = getX();
        int y = getY();

        switch(direction) {
            case RIGHT: x += 6; break;
            case LEFT: x -= 6; break;
            case UP: y -= 6; break;
            case DOWN: y += 6; break;
        }

        if(isTouching(grey.class)) {
            return false;
        }
        return true;
    }

    public void switchDirection() {

        switch(direction) {
            case RIGHT: setDirection(DOWN); break;
            case DOWN: setDirection(UP); break;
            case UP: setDirection(LEFT); break;
            case LEFT: setDirection(RIGHT); break;
        }
    }

    public void setDirection(int direction) {

        this.direction = direction;

        switch(direction) {
            case RIGHT: move(1); break;
            case LEFT: move(-1); break;
            case UP: setLocation(getX(), getY() - 1); break;
            case DOWN: setLocation(getX(), getY() + 1); break;
        }
    }*/
    
}
