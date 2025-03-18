import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class WinFlag extends Actor {
    private GreenfootImage[] flagWave;
    private GreenfootImage[] flagWaveWin;
    protected GreenfootImage flagImage;
    private int currentFrame = 0;     // Index to keep track of the current frame
    private int frameDelay = 0;       // Counter to track delay before switching frames
    private int delayCount = 10;      // How long to wait before switching to the next frame
    protected boolean hasWon = false; // To determine if the flag has won

    public WinFlag() {
        loadFlagFrames();  // Load both waving and winning flag frames
        setImage(flagWave[0]);  // Initially show the first wave image
    }

    private void loadFlagFrames() {
        loadWavingFlag();
        loadWinningFlag();
    }

    private void loadWavingFlag() {
        flagWave = new GreenfootImage[5];
        for (int i = 0; i < flagWave.length; i++) {
            flagWave[i] = new GreenfootImage("FLAG-WAVE-" + i + ".png");
        }
    }

    private void loadWinningFlag() {
        flagWaveWin = new GreenfootImage[5];
        for (int i = 0; i < flagWaveWin.length; i++) {
            flagWaveWin[i] = new GreenfootImage("FLAG-WAVE-WIN-" + i + ".png");
        }
    }

    public void act() {
        // Select the current flag frames based on whether the flag has won
        GreenfootImage[] currentFrames = hasWon ? flagWaveWin : flagWave;

        // Update the flag animation based on frameDelay and delayCount
        if (frameDelay >= delayCount) {
            // Update the image to the current frame
            setImage(currentFrames[currentFrame]);

            // Increment the frame, looping back to 0 if necessary
            currentFrame = (currentFrame + 1) % currentFrames.length;

            // Reset frameDelay to 0
            frameDelay = 0;
        } else {
            // Increment frameDelay until it reaches delayCount
            frameDelay++;
        }
    }
}
