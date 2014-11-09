import java.awt.image.*;

public class Sprite {
    private BufferedImage img;
    
    public Sprite(BufferedImage i) {
        img = i;
    }
    
    public BufferedImage getImg() {return img;}
}
