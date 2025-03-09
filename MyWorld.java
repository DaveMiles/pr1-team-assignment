import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name)
 * @version (a version number or a date)
 */
public class MyWorld extends World {
    final static int WORLD_WIDTH = 600;
    final static int WORLD_HEIGHT = 400;
    final static int WORLD_PIXEL = 1;

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld() {
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(WORLD_WIDTH, WORLD_HEIGHT, WORLD_PIXEL);
        Player player = new Player();

        addObject(player, 20, WORLD_HEIGHT - player.height / 2);

        Enemy enemy = new Enemy();

        addObject(enemy, 100, WORLD_HEIGHT - enemy.height / 2);
    }

}
