import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Water here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Water extends Actor{
    public Water() {
        this(40, 40);
    }

    public Water(int width, int height) {
        GreenfootImage water = getImage();
        water.scale(width, height);
        setImage(water);
    }

    public void act()
    {
        // Add your action code here.
    }
}

