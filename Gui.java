import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class Gui extends JFrame implements ActionListener {
    //final private Font font = new Font("Lucida Console",Font.PLAIN,12);
    private Dimension guiDim = new Dimension();
    private Container content;
    private MyKeyListener keylisten = new MyKeyListener();
    private MyMouseInputListener mouselisten = new MyMouseInputListener();
    private Game g;
    private GfxStuff gfx;

    public void actionPerformed(ActionEvent e) {
	System.out.println(e);
    }

    private class MyKeyListener implements KeyListener {
	public void keyPressed(KeyEvent e) {
	    //System.out.println(e);
	    g.pushKeyInput(e);
	}
	public void keyTyped(KeyEvent e) {
	    //System.out.println(e);
	}
	public void keyReleased(KeyEvent e) {
	    //System.out.println(e);
	    g.removeKeyInput(e);
	}
    }

    private class MyMouseInputListener implements MouseInputListener {
	public void mousePressed(MouseEvent e) {
	    //System.out.println(e);
	    g.pushMouseInput(e);
	}
	public void mouseReleased(MouseEvent e) {
	    //System.out.println(e);
	}
	public void mouseEntered(MouseEvent e) {
	    //System.out.println(e);
	}
	public void mouseExited(MouseEvent e) {
	    //System.out.println(e);
	}
	public void mouseClicked(MouseEvent e) {
	    //System.out.println(e);
	}
	public void mouseMoved(MouseEvent e) {
	    //System.out.println(e);
	}
	public void mouseDragged(MouseEvent e) {
	    //System.out.println(e);
	}
    }

    public Gui(Game g) {
	this.g = g;
	gfx = g.getGfx();
	setTitle("idk");
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	setResizable(false);
	content = getContentPane();
	content.setBackground(Color.DARK_GRAY);
        
	pack();
	guiDim.height = 480+
	    getInsets().top+getInsets().bottom;
	guiDim.width = 640+
	    getInsets().left+getInsets().right;

	setSize(guiDim);

	content.add(gfx);
	setVisible(true);
	addKeyListener(keylisten);
	addMouseListener(mouselisten);
	addMouseMotionListener(mouselisten);
	requestFocusInWindow();
    }
}
