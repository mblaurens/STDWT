import java.util.*;
import java.awt.*;
import java.awt.geom.*;
import java.awt.image.*;

public class Layer {
    private Display parent;
    private Rectangle rect;
    private LinkedList<Spritable> sprites;
    
    public Layer(Display disp) {
        parent = disp;
        rect = disp.getLocation();
        sprites = new LinkedList<Spritable>();
    }

    public void putSpritable(Spritable s, Graphics2D target) {
        target.drawImage(s.getSprite().getImg(),
                         null,
                         (int)s.getPos().getX(),
                         (int)s.getPos().getY());
    }
    public void putImg(BufferedImage i, Vec2 p, Graphics2D target) {
        target.drawImage(i,null,(int)p.getX(),(int)p.getY());
    }
    public void addSpritable(Spritable s) {
        sprites.add(s);
    }
    public void removeSpritable(Spritable s) {
        sprites.remove(s);
    }
    public void drawTo(Graphics2D target) {
        target.drawImage(getImg(),
                         new AffineTransform(1f, 0f, 0f, 1f, 
                                              rect.getX(),rect.getY()),
                         null);
    }

    public BufferedImage getImg() {
        BufferedImage r = new BufferedImage((int)rect.getWidth(),(int)rect.getHeight(),BufferedImage.TYPE_4BYTE_ABGR);
        Graphics2D g = r.createGraphics();
        Iterator<Spritable> it = sprites.iterator();
        Spritable s;
        while(it.hasNext()) {
            s = it.next();
            putSpritable(s,g);
        }
        return r;
    }

    public Rectangle getRect() {return rect;}
    public LinkedList<Spritable> getSprites() {return sprites;}
}
