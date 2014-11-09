import java.awt.*;
import java.awt.image.*;
import java.io.*;
import java.util.*;
import javax.swing.*;
import javax.imageio.*;

public class GfxStuff extends JLayeredPane {
    private Dimension size;
    private BufferedImage img;
    private Display[] displays;

    public GfxStuff() {
        size = new Dimension(640,480);
        img = new BufferedImage(size.width,size.height,BufferedImage.TYPE_4BYTE_ABGR);
        displays = new Display[3];
        displays[0] = new Display("charDisp" ,new Rectangle(  0,  0,180,480));
        displays[1] = new Display("enemyDisp",new Rectangle(180,  0,480,320));
        displays[2] = new Display("logDisp"  ,new Rectangle(180,320,480,160));
    }
    
    public void paintComponent(Graphics g) {
        g.drawImage(img,0,0,null);
        paintComponents(g);
        Toolkit.getDefaultToolkit().sync();
    }

    public LinkedList<Button> effectAt(double x, double y) {
        LinkedList<Button> r = new LinkedList<Button>();
        Display curdisp = null;
        for(Display d : displays) {
            if(d.getLocation().contains(x,y)) {
                curdisp = d;
            }
        } 
        if(curdisp!=null) {
            for (Layer l : curdisp.getLayers()) {
                for (Spritable s : l.getSprites()) {
                    if(s instanceof Button) {
                        Rectangle rt;
                        Sprite spr = s.getSprite();
                        rt = new Rectangle((int) s.getPos().getX() +
                                           (int) l.getRect().getX(),
                                           (int) s.getPos().getY() +
                                           (int) l.getRect().getY(),
                                           spr.getImg().getWidth(),
                                           spr.getImg().getHeight());
                        if(rt.contains(x,y)) {
                            r.add((Button)s);
                        }
                    }
                }
            }
        }
        return r;
    }

    public void refresh() {
        BufferedImage newimg = new BufferedImage(size.width,size.height,BufferedImage.TYPE_4BYTE_ABGR);
        Graphics2D newg2d = newimg.createGraphics();
        for(int i=0; i<displays.length; i++) {
            Display d = displays[i];
            d.drawTo(newg2d);
        }
        img = newimg;
        repaint();
    }

    public Dimension getSize() {return size;}
    public Display[] getDisplays() {return displays;}
    public BufferedImage getImg() {return img;}

    public BufferedImage readImage(String path) {
        BufferedImage r = null;
        try {
            r = ImageIO.read(new File(path));
        } catch (IOException e) {
            System.out.println(e);
            System.out.println(path);
        }
        return r;
    }

    public void dumpDisplays() {
        dumpImage(img,"GfxStuff");
        for (Display d : displays) {
            dumpImage(d.getImg(),d.getName());
            dumpImage(d.getUI().getImg(),d.getName()+"UI");
            dumpImage(d.getFG().getImg(),d.getName()+"FG");
            dumpImage(d.getBG().getImg(),d.getName()+"BG");
        }
        System.out.println("Displays dumped.");
    }
    private void dumpImage(BufferedImage c, String s) {
        new File("DUMP").mkdir();
        try {
            ImageIO.write(c,"png",new File("DUMP/"+s+".png"));
        } catch (IOException e) {
            System.out.println(e);
        }   
    }
}
