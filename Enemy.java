import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Enemy here.
 * 
 * @author (your name)
 * @version (a version number or a date)
 */
public class Enemy extends Character

{
    // animation properties
    private GreenfootImage[] idleFrames;
    private GreenfootImage[] runFrames;
    private GreenfootImage[] deathFrames;
    private int currentFrame = 0;
    private int frameDelay = 0;
    private int delayCount = 10;
    protected boolean isFacingRight = true;

    // image properties
    protected GreenfootImage image;
    protected int height;
    protected int width;

    // role play properties
    protected int health = 100;
    protected int damage = 10;
    private int attackDelay = 30;
    private int attackCounter = 0;

    public Enemy() {
        loadFrames();
        scaleAllFrames();
        image = idleFrames[0];
        setImage(image);
        width = image.getWidth();
        height = image.getHeight();
    }

    private void loadFrames() {
        loadIdleFrames();
        loadWalkingFrames();
        loadDeathFrames();
    }

    private void scaleAllFrames() {
        for (GreenfootImage frame : idleFrames) {
            frame.scale((int) (frame.getWidth() * 2), (int) (frame.getHeight() * 2));
        }
        for (GreenfootImage frame : runFrames) {
            frame.scale((int) (frame.getWidth() * 2), (int) (frame.getHeight() * 2));
        }
        for (GreenfootImage frame : deathFrames) {
            frame.scale((int) (frame.getWidth() * 2), (int) (frame.getHeight() * 2));
        }
    }

    private void loadIdleFrames() {
        idleFrames = new GreenfootImage[4];
        for (int i = 0; i < idleFrames.length; i++) {
            idleFrames[i] = new GreenfootImage("SKELETON-IDLE-" + i + ".png");
            if (!isFacingRight) {
                idleFrames[i].mirrorHorizontally();
            }
        }
    }

    private void loadWalkingFrames() {
        runFrames = new GreenfootImage[4];
        for (int i = 0; i < runFrames.length; i++) {
            runFrames[i] = new GreenfootImage("SKELETON-WALK-" + i + ".png");
            if (!isFacingRight) {
                runFrames[i].mirrorHorizontally();
            }
        }
    }

    private void loadDeathFrames() {
        deathFrames = new GreenfootImage[4];
        for (int i = 0; i < deathFrames.length; i++) {
            deathFrames[i] = new GreenfootImage("SKELETON-DEATH-" + i + ".png");
        }

    }

    /**
     * Act - do whatever the Enemy wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() {
        attackCounter++;
        if (attackCounter >= attackDelay) {
            attack();
            attackCounter = 0;
        }
        if (frameDelay >= delayCount) {
            setImage(idleFrames[currentFrame]);
            currentFrame = (currentFrame + 1) % idleFrames.length;
            frameDelay = 0;
        } else {
            frameDelay++;
        }

    }

    private void attack() {
        dealDamage(Enemy.class, damage, 0);
    }

    public void removeHealth(int damage) {
        health -= damage;
        if (health <= 0) {
            for (GreenfootImage frame : deathFrames) {
                setImage(frame);
                Greenfoot.delay(5);
            }
            getWorld().removeObject(this);
        }
    }

    private void mirrorAllFrames() {
        for (GreenfootImage frame : idleFrames) {
            frame.mirrorHorizontally();
        }
        for (GreenfootImage frame : runFrames) {
            frame.mirrorHorizontally();
        }
        for (GreenfootImage frame : deathFrames) {
            frame.mirrorHorizontally();
        }

    }
}
