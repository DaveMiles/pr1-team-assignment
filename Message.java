import greenfoot.*;  

public class Message extends Actor {
    private GreenfootImage messageImage;

    public Message(String text) {
        messageImage = new GreenfootImage(text, 40, Color.WHITE, new Color(0, 0, 0, 150));
        setImage(messageImage);
    }
}
