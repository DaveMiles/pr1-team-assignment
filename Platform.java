import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Platform here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Platform extends Actor{
    public Platform() {
        this(40, 40);
    }

    public Platform(int width, int height) {
        GreenfootImage platform = getImage();
        platform.scale(width, height);
        setImage(platform);
    }

    public void act()
    {
        // Add your action code here.
    }
}

