import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class player extends Actor
{
    /**
     * Act - do whatever the player wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private GreenfootImage right = new GreenfootImage("right.jpg");
    private GreenfootImage yellow = new GreenfootImage("yellow.png");
    private GreenfootImage left = new GreenfootImage("left.jpg");
    private GreenfootImage up = new GreenfootImage("up.jpg");
    private GreenfootImage down = new GreenfootImage("down.jpg");
    private int currentImage;
    private long imageSwapCounter;
    public player(){
        setImage(right);
        currentImage = 0;
        imageSwapCounter = System.currentTimeMillis();
    }
    public void act() 
    {
        lookForFood();
        checkKeys();
        if(isTouching(flag.class)){
            Greenfoot.stop();
            Greenfoot.playSound("Dead.wav");
            Greenfoot.setWorld(new EndScore());
        }
    }    
    private void checkKeys() {
        if(System.currentTimeMillis() - imageSwapCounter > 100) {
            imageSwapCounter = System.currentTimeMillis();
            currentImage++;
            if(currentImage > 1) {
                currentImage = 0;
            }
            if(currentImage == 0) {
                setImage(right);
            } else {
                setImage(yellow);
            }
        }
        if(Greenfoot.isKeyDown("left")){
            if(getObjectsAtOffset(-1, 0, grey.class).isEmpty()){
                setLocation(getX()-1,getY());Greenfoot.delay(5);
                if(getImage() == left) setImage(yellow);
                else setImage(left);
            }
            else setImage(left);
        }
        if(Greenfoot.isKeyDown("right")){
            if(getObjectsAtOffset(1, 0, grey.class).isEmpty()){
                setLocation(getX()+1,getY());Greenfoot.delay(5);
                if(getImage() == right) setImage(yellow);
                else setImage(right);
            }
            else setImage(right);
        }
        if(Greenfoot.isKeyDown("up")){
            if(getObjectsAtOffset(0, -1, grey.class).isEmpty()){
                setLocation(getX(),getY()-1);Greenfoot.delay(5);
                if(getImage() == up) setImage(yellow);
                else setImage(up);
            }else setImage(up);
        }
        if(Greenfoot.isKeyDown("down")){
            if(getObjectsAtOffset(0, 1, grey.class).isEmpty()){
                setLocation(getX(),getY()+1);Greenfoot.delay(5);
                if(getImage() == down) setImage(yellow);
                else setImage(down);
            }else setImage(down);
        }
    }
    public void lookForFood(){
        if(isTouching(food.class)){
            removeTouching(food.class);
            Easy.score++;
            Mudium.score++;
            Hard.score++;
        }
    }
}
