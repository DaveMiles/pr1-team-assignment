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

    public void dealDamage(Class whoAmI, int damage, int reach) {
        Actor actor = null;
        switch (whoAmI.getName()) {
            case "Player":
                // player will deal damage in the direction they are facing + the reach of the
                // sword
                actor = getOneObjectAtOffset(reach, 0, null);
                if (actor instanceof Enemy) {
                    Enemy enemy = (Enemy) actor;
                    enemy.removeHealth(damage);
                }
                break;
            case "Enemy":
                // enemy will deal damage to the player if they are touching
                actor = getOneIntersectingObject(null);
                if (actor instanceof Player) {
                    Player player = (Player) actor;
                    player.removeHealth(damage);
                }
                break;
            default:
                break;
        }

    }

}
