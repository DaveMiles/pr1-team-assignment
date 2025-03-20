import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name)
 * @version (a version number or a date)
 */
public class MyWorld extends World {
    final static int WORLD_WIDTH = 1340;
    final static int WORLD_HEIGHT = 540;
    final static int WORLD_PIXEL = 1;
    final static int enemy_height = 28;
    private GreenfootImage background;

    int[][] platformPositions = {
            { 200, 520 }, { 240, 520 }, { 280, 520 }, { 240, 480 }, { 280, 480 }, { 280, 440 },
            { 360, 440 }, { 440, 440 }, { 440, 480 }, { 440, 520 }, { 480, 480 }, { 480, 480 },
            { 480, 520 }, { 520, 520 }, { 600, 480 }, { 640, 480 }, { 680, 480 }, { 760, 440 },
            { 800, 440 }, { 880, 480 }, { 960, 440 }, {1040, 480 }, {1080, 480 }, {1160, 480 },
            {1240, 440 }, {1320, 400 }, {1240, 320 }, {1200, 320 }, {1160, 320 }, {1080, 320 },
            {1040, 280 }, { 960, 240 }, { 840, 280 }, { 880, 280 }, { 800, 280 }, { 680, 320 },
            { 680, 280 }, { 640, 280 }, { 640, 240 }, { 520, 280 }, { 440, 280 }, { 360, 280 }, 
            { 280, 280 }, { 200, 320 }, { 120, 280 }, { 80, 280  }, { 40, 240  }, { 120, 160 }, 
            { 200, 80  }, { 240, 80  }, { 280, 80  }, { 360, 80  }, { 400, 120 }, { 480, 120 },
            { 520, 80  }, { 600, 80  }, { 640, 80  }, { 720, 80  }, { 800, 80  }, { 840, 80  },
            { 920, 80  }, { 960, 80  }, { 1040, 120}, { 1320, 80 }, { 1280, 80 }, { 1240, 80 },
            { 1200, 80 }, { 1160, 80}
    };
    // Add as many as needed to the coords

    int[][] enemyPositions = {
            { 360, (WORLD_HEIGHT - enemy_height / 2) - 120 }, { 640, (WORLD_HEIGHT - enemy_height / 2) - 80 },
            { 1080, (WORLD_HEIGHT - enemy_height / 2) - 80 }, { 1200, (WORLD_HEIGHT - enemy_height / 2) - 240 },
            { 360, (WORLD_HEIGHT - enemy_height / 2) - 280 }, { 840, (WORLD_HEIGHT - enemy_height / 2) - 280  },
            { 240, (WORLD_HEIGHT - enemy_height / 2) - 480 }, { 720, (WORLD_HEIGHT - enemy_height / 2) - 480  },
            { 840, (WORLD_HEIGHT - enemy_height / 2) - 480 }, { 960, (WORLD_HEIGHT - enemy_height / 2) - 480  },
            { 1040, (WORLD_HEIGHT - enemy_height / 2) - 440}, { 1200, (WORLD_HEIGHT - enemy_height / 2) - 480 },
            { 40, (WORLD_HEIGHT - enemy_height / 2) - 320 },
    };

    int[][] potionPositions = {
            { 760, 405 }, { 960, 200 }, { 640, 40 },
    };

    public MyWorld() {
        super(WORLD_WIDTH, WORLD_HEIGHT, WORLD_PIXEL);
        GreenfootImage background = new GreenfootImage("DARK-CASTLE2.jpg");
        setBackground(background);
        Player player = new Player();
        addObject(player, 20, WORLD_HEIGHT - player.height / 2);
        WinFlag flag = new WinFlag();
        addObject(flag, 1330, 30);

        addPlatforms();
        addEnemies();
        addPotions();
        Water water = new Water(120, 40);
        addObject(water, 360, 560);
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
