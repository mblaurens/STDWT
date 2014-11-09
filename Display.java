import java.awt.*;
import java.awt.image.*; 
import javax.swing.*;

public class Display {
    private String name; //identifies display for debug commands
    private Rectangle rect; //represents area occupied by display
    private Layer[] layers; //
    
    public Display(String n, Rectangle l) {
        name = n;
        rect = l;
        layers = new Layer[3];
        for(int i=0; i<3; i++) {
            layers[i] = new Layer(this);
        }
    }

    public void drawTo(Graphics2D target) {
        getBG().drawTo(target);
        getFG().drawTo(target);
        getUI().drawTo(target);
    }

    public BufferedImage getImg() {
        BufferedImage r = new BufferedImage((int)rect.getWidth(),(int)rect.getHeight(),BufferedImage.TYPE_4BYTE_ABGR);
        Graphics2D g = r.createGraphics();
        for(int i=2; i>=0; i--) {
            g.drawImage(getLayers()[i].getImg(),null,0,0);
        }
        return r;
    }

    public void tileBG(BufferedImage tile) {
        BufferedImage img;
        Graphics2D g;
        GfxEffect bgfx;
        img = new BufferedImage(rect.getSize().width,
                                rect.getSize().height,
                                BufferedImage.TYPE_4BYTE_ABGR);
        g = img.createGraphics();
        for(int x=0; x<640; x++) {
            for(int y=0; y<480; y++) {
                if(x%10==0 && y%10==0)
                    g.drawImage(tile,null,x,y);
            }
        }
        bgfx = new GfxEffect(new Sprite(img),new Vec2(0,0));
        getBG().addSpritable(bgfx);
    }

    public void addToUI(Button b) {
        getUI().addSpritable(b);
    }

    public String getName() {return name;}
    public Rectangle getLocation() {return rect;}
    public Layer[] getLayers() {return layers;}
    public Layer getUI() {return layers[0];}
    public Layer getFG() {return layers[1];}
    public Layer getBG() {return layers[2];}
}
