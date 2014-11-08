import java.awt.*;
import java.awt.image.*; 
import javax.swing.*;

public class Display {
    private String name; //identifies display for debug commands
    private Rectangle rect; //represents area occupied by display
    private Layer fg,bg; //
    
    public Display(String n, Rectangle l) {
	name = n;
	rect = l;
	fg = new Layer(this);
	bg = new Layer(this);
    }

    public void drawTo(Graphics2D target) {
	bg.drawTo(target);
	fg.drawTo(target);
    }

    public BufferedImage getImg() {
	BufferedImage r = new BufferedImage((int)rect.getWidth(),(int)rect.getHeight(),BufferedImage.TYPE_4BYTE_ABGR);
	Graphics2D g = r.createGraphics();
	g.drawImage(bg.getImg(),null,0,0);
	g.drawImage(fg.getImg(),null,0,0);
	return r;
    }
    public String getName() {return name;}
    public Rectangle getLocation() {return rect;}
    public Layer getFG() {return fg;}
    public Layer getBG() {return bg;}
}
