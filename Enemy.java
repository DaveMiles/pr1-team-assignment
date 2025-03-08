import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Enemy here.
 * 
 * @author (your name)
 * @version (a version number or a date)
 */
public class Enemy extends Character

{

    // image properties
    protected GreenfootImage image;
    protected int height;
    protected int width;

    public Enemy() {
        image = getImage();
        width = image.getWidth();
        height = image.getHeight();
    }

    /**
     * Act - do whatever the Enemy wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() {
        // Add your action code here.
    }
}
