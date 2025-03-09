import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Character here.
 * 
 * @author (your name)
 * @version (a version number or a date)
 */
public class Character extends Actor {

    public Character() {

    }

    /**
     * Act - do whatever the Character wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() {
        // Add your action code here.
    }

    public void dealDamage(int damage, int reach) {
        Actor actor = getOneObjectAtOffset(reach, 0, null);
        if (actor instanceof Enemy) {
            Enemy enemy = (Enemy) actor;
            enemy.removeHealth(damage);
        } else if (actor instanceof Player) {
            Player player = (Player) actor;
            player.removeHealth(damage);
        }
    }

}
