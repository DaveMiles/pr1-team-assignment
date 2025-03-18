import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name)
 * @version (a version number or a date)
 */
public class MyWorld extends World {
    final static int WORLD_WIDTH = 1350;
    final static int WORLD_HEIGHT = 540;
    final static int WORLD_PIXEL = 1;
    final static int enemy_height = 28;
    private GreenfootImage background;

    int[][] platformPositions = {
            { 200, 520 }, { 240, 520 }, { 280, 520 }, { 240, 480 }, { 280, 480 }, { 280, 440 },
            { 360, 440 }, { 440, 440 }, { 440, 480 }, { 440, 520 }, { 480, 480 }, { 480, 480 },
            { 480, 520 }, { 520, 520 }, { 240, 520 }, { 240, 520 }, { 240, 520 }, { 240, 520 },
            { 240, 520 }, { 240, 520 }, { 240, 520 }, { 240, 520 }, { 240, 520 }, { 240, 520 }
    };
    // Add as many as needed to the coords

    int[][] enemyPositions = {
            { 100, WORLD_HEIGHT - enemy_height / 2 }, { 600, WORLD_HEIGHT - enemy_height / 2 }
    };

    int[][] potionPositions = {
            { 360, 405 }
    };

    public MyWorld() {
        super(WORLD_WIDTH, WORLD_HEIGHT, WORLD_PIXEL);
        GreenfootImage background = new GreenfootImage("DARK-CASTLE2.jpg");
        setBackground(background);
        Player player = new Player();
        addObject(player, 20, WORLD_HEIGHT - player.height / 2);
        WinFlag flag = new WinFlag();
        addObject(flag, 1100, 510);

        Water water = new Water(120, 40);
        addObject(water, 360, 560);
        addPlatforms();
        addEnemies();
        addPotions();
    }

    public void addPlatforms() {
        for (int i = 0; i < platformPositions.length; i++) {
            int x = platformPositions[i][0];
            int y = platformPositions[i][1];
            Platform platform = new Platform();
            addObject(platform, x, y);
        }
    }

    public void addPotions() {
        for (int i = 0; i < potionPositions.length; i++) {
            int x = potionPositions[i][0];
            int y = potionPositions[i][1];
            Potion potion = new Potion();
            addObject(potion, x, y);
        }
    }

    public void addEnemies() {
        for (int i = 0; i < enemyPositions.length; i++) {
            int x = enemyPositions[i][0];
            int y = enemyPositions[i][1];
            Enemy enemy = new Enemy();
            addObject(enemy, x, y);
        }

    }
}
