import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class EndScore here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EndScore extends World
{

    /**
     * Constructor for objects of class EndScore.
     * 
     */
    public EndScore()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(41, 41, 15); 
        showText("Score : "+ (int)(Easy.score),getWidth()/2, getHeight()/2);
        showText("Score : "+ (int)(Mudium.score),getWidth()/2, getHeight()/2);
        showText("Score : "+ (int)(Hard.score),getWidth()/2, getHeight()/2);
        addObject(new R(), 35, 5);
    }
}
