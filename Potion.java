import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Food here.
 * 
 * @author (your name)
 * @version (a version number or a date)
 */
public class Potion extends Actor {
    public int healAmount = 50;

    public Potion() {
        GreenfootImage image = getImage();
        // image.scale(30, 30);
        setImage(image);
    }

    public int use() {
        getWorld().removeObject(this);
        return healAmount;

    }

    /**
     * Act - do whatever the Food wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() {
        // Add your action code here.
    }
}
