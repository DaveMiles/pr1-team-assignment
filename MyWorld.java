import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name)
 * @version (a version number or a date)
 */
public class MyWorld extends World {
    final static int WORLD_WIDTH = 1920;
    final static int WORLD_HEIGHT = 540;
    final static int WORLD_PIXEL = 1;
    private GreenfootImage background;

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld() {
        // Create a new world with 1920x540 cells with a cell size of 1x1 pixels.
        super(WORLD_WIDTH, WORLD_HEIGHT, WORLD_PIXEL);
        GreenfootImage background = new GreenfootImage("DARK-CASTLE2.jpg");
        setBackground(background);
        Player player = new Player();
        addObject(player, 20, WORLD_HEIGHT - player.height / 2);
        
    
    }
}
