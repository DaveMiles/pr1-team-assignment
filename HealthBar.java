import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class HealthBar extends Character {
    private int maxHealth;
    private int currentHealth;
    private int barWidth;
    private int barHeight;
    private int pixelsPerHealthPoint;

    public HealthBar(int maxHealth, int barWidth, int barHeight) {
        this.maxHealth = maxHealth;
        this.currentHealth = maxHealth;
        this.barWidth = barWidth;
        this.barHeight = barHeight;
        this.pixelsPerHealthPoint = barWidth / maxHealth;
        update();
    }

    public void act() {
        // Add your action code here.
    }

    public void update() {
        GreenfootImage image = new GreenfootImage(barWidth, barHeight);
        image.setColor(Color.BLACK);
        image.drawRect(0, 0, barWidth + 1, barHeight + 1);
        image.setColor(Color.RED);
        image.fillRect(1, 1, currentHealth * pixelsPerHealthPoint, barHeight);
        setImage(image);
    }

    public void setHealth(int health) {
        this.currentHealth = health;
        update();
    }
}