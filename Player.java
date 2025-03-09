import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Player here.
 * 
 * @version (a version number or a date)
 */
public class Player extends Character {

    // animation properties
    private GreenfootImage[] idleFrames;
    private GreenfootImage[] jumpFrames;
    private GreenfootImage[] runFrames;
    private GreenfootImage[] attackFrames;
    private GreenfootImage[] deathFrames;
    private int currentFrame = 0;
    private int frameDelay = 0;
    private int delayCount = 10;
    protected boolean isFacingRight = true;

    // movement properties
    protected int speed = 2;
    protected int jumpStrength = 10;
    protected int gravity = 1;
    protected int verticalSpeed = 0;
    protected boolean isJumping = false;
    protected boolean isAttacking = false;

    // image properties
    protected GreenfootImage image;
    protected int height;
    protected int width;

    // roleplay properties
    protected int health = 100;
    protected int damage = 50;
    protected int weaponReach;

    public Player() {
        loadPlayerFrames();
        image = new GreenfootImage("PLAYER-IDLE-0.png");
        setImage(image);
        width = image.getWidth();
        height = image.getHeight();
        weaponReach = width / 2;
    }

    private void loadPlayerFrames() {
        loadRunningFrames();
        loadIdleFrames();
        loadJumpFrames();
        loadAttackingFrames();
        loadDeathFrames();
    }

    private void loadIdleFrames() {
        idleFrames = new GreenfootImage[7];
        for (int i = 0; i < idleFrames.length; i++) {
            idleFrames[i] = new GreenfootImage("PLAYER-IDLE-" + i + ".png");
            if (!isFacingRight) {
                idleFrames[i].mirrorHorizontally();
            }
        }
    }

    private void loadRunningFrames() {
        runFrames = new GreenfootImage[7];
        for (int i = 0; i < runFrames.length; i++) {
            runFrames[i] = new GreenfootImage("PLAYER-RUN-" + i + ".png");
            if (!isFacingRight) {
                runFrames[i].mirrorHorizontally();
            }
        }
    }

    private void loadAttackingFrames() {
        attackFrames = new GreenfootImage[6];
        for (int i = 0; i < attackFrames.length; i++) {
            attackFrames[i] = new GreenfootImage("PLAYER-ATTACK-" + i + ".png");
            if (!isFacingRight) {
                attackFrames[i].mirrorHorizontally();
            }
        }
    }

    private void loadJumpFrames() {
        jumpFrames = new GreenfootImage[5];
        for (int i = 0; i < jumpFrames.length; i++) {
            jumpFrames[i] = new GreenfootImage("PLAYER-JUMP-" + i + ".png");
            if (!isFacingRight) {
                jumpFrames[i].mirrorHorizontally();
            }
        }
    }

    private void loadDeathFrames() {
        deathFrames = new GreenfootImage[12];
        for (int i = 0; i < deathFrames.length; i++) {
            deathFrames[i] = new GreenfootImage("PLAYER-DEATH-" + i + ".png");
            if (!isFacingRight) {
                deathFrames[i].mirrorHorizontally();
            }
        }
    }

    /**
     * Act - do whatever the Player wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() {
        if (!isInAction()) {
            GreenfootImage[] currentFrames = isMoving() ? runFrames : idleFrames;
            if (frameDelay >= delayCount) {
                setImage(currentFrames[currentFrame]);
                currentFrame = (currentFrame + 1) % currentFrames.length;
                frameDelay = 0;
            } else {
                frameDelay++;
            }

        }
        handleInput();
        applyGravity();
    }

    private boolean isMoving() {
        return (Greenfoot.isKeyDown("left") || Greenfoot.isKeyDown("right"));
    }

    private boolean isInAction() {
        return isJumping && isAttacking;
    }

    private void handleInput() {
        int x = getX();
        int y = getY();

        if (Greenfoot.isKeyDown("left")) {

            x -= speed;
            if (isFacingRight) {
                mirrorAllFrames();
                isFacingRight = false;
            }

        }
        if (Greenfoot.isKeyDown("right")) {
            x += speed;
            if (!isFacingRight) {
                mirrorAllFrames();
                isFacingRight = true;
            }
        }

        if (Greenfoot.isKeyDown("up")) {
            if (!isJumping) {
                jump();
            }
        }
        if (Greenfoot.isKeyDown("space")) {
            if (!isAttacking && !isJumping) {
                attack();
            }
        }

        setLocation(x, y);
    }

    private void jump() {
        verticalSpeed = -jumpStrength;
        isJumping = true;
    }

    private void attack() {
        isAttacking = true;
        for (GreenfootImage frame : attackFrames) {
            setImage(frame);
            Greenfoot.delay(5);
        }
        dealDamage(damage, width / 2 + weaponReach);
        isAttacking = false;
    }

    private void applyGravity() {
        if (isJumping) {
            setLocation(getX(), getY() + verticalSpeed);
            verticalSpeed += gravity;

            // Update the jump frame based on the vertical speed
            int jumpFrame = Math.min(Math.abs(verticalSpeed / 2), jumpFrames.length - 1);
            setImage(jumpFrames[jumpFrame]);

            // Check if the player has landed
            if (getY() >= getWorld().getHeight() - height / 2) {
                isJumping = false;
                verticalSpeed = 0;
            }
        }
    }

    public void removeHealth(int damage) {
        health -= damage;
        if (health <= 0) {
            for (GreenfootImage frame : deathFrames) {
                setImage(frame);
                Greenfoot.delay(5);
            }
            getWorld().showText("Game Over", getWorld().getWidth() / 2, getWorld().getHeight() / 2);
        }
    }

    private void mirrorAllFrames() {
        for (GreenfootImage frame : idleFrames) {
            frame.mirrorHorizontally();
        }
        for (GreenfootImage frame : jumpFrames) {
            frame.mirrorHorizontally();
        }
        for (GreenfootImage frame : runFrames) {
            frame.mirrorHorizontally();
        }
        for (GreenfootImage frame : attackFrames) {
            frame.mirrorHorizontally();
        }
        for (GreenfootImage frame : deathFrames) {
            frame.mirrorHorizontally();
        }

    }
}
