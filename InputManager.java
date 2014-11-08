import java.awt.event.*;
import java.io.*;
import java.util.*;

public class InputManager {
    private Game game;
    private GfxStuff gfx;
    private LinkedList<KeyEvent> keyHeldB;
    private LinkedList<KeyEvent> keyPressB;
    private LinkedList<MouseEvent> mouseInB;
    
    public InputManager(Game g) {
        game = g;
        gfx = g.getGfx();
        keyHeldB = new LinkedList<KeyEvent>();
        keyPressB = new LinkedList<KeyEvent>();
        mouseInB = new LinkedList<MouseEvent>();
    }

    public void clearInput() {
        keyHeldB.clear();
        keyPressB.clear();
        mouseInB.clear();
    }

    public void doInput() {
        LinkedList<KeyEvent> curkeyheld = (LinkedList<KeyEvent>) keyHeldB.clone();
        LinkedList<KeyEvent> curkeypress = (LinkedList<KeyEvent>) keyPressB.clone();
        LinkedList<MouseEvent> curmousein = (LinkedList<MouseEvent>) mouseInB.clone();
        keyPressB.clear();
        mouseInB.clear();
        Iterator<KeyEvent> khit = curkeyheld.iterator();
        Iterator<KeyEvent> kpit = curkeypress.iterator();
        Iterator<MouseEvent> mit = curmousein.iterator();
        while(khit.hasNext()) {
            doCommand(khit.next(),true);
        }
        while(kpit.hasNext()) {
            KeyEvent cur = kpit.next();
            boolean press=true;
            for(KeyEvent k : curkeyheld) {
                if(k.getKeyCode()==cur.getKeyCode()) {press=false; break;}
            }
            if(press) {
                doCommand(cur,false); 
                pushKeyHeld(cur);
            }
        }
        while(mit.hasNext()) {
            doCommand(mit.next(),false);
        }
	
    }

    public void pushKeyHeld(KeyEvent e) {
        for(KeyEvent k : keyHeldB) {
            if(k.getKeyCode()==e.getKeyCode()) {return;}
        }
        keyHeldB.add(e);
    }
    public void pushKeyPress(KeyEvent e) {
        keyPressB.add(e);
    }
    public void removeKeyInput(KeyEvent e) {
        Iterator<KeyEvent> kit;
        kit = keyHeldB.iterator();
        while(kit.hasNext()) {
            if(kit.next().getKeyCode()==e.getKeyCode()) {kit.remove();}
        }
        kit = keyPressB.iterator();
        while(kit.hasNext()) {
            if(kit.next().getKeyCode()==e.getKeyCode()) {kit.remove();}
        }
    }
    public void pushMouseInput(MouseEvent e) {
        mouseInB.add(e);
    }
    
    public void doCommand(InputEvent e, boolean held) {
        Command c = Command.inputEventToCommand(e);
        switch (c) {
        case MOVE_LEFT: 
            break;
        case MOVE_RIGHT: 
            break;
        case MOVE_UP:
            break;
        case DEBUG_DUMPDISPLAYS: 
            gfx.dumpDisplays(); 
            break;
        case INVALID_KEY_COMMAND: 
            System.out.println(((KeyEvent) e).getKeyChar()); break;
        case INVALID_MOUSE_COMMAND: 
            String r = ((MouseEvent) e).getButton()+" : ";
            r += ((MouseEvent) e).getX()+","+((MouseEvent) e).getY();
            System.out.println(r);
            break;
        case NO_COMMAND: 
            System.out.println("null InputEvent...?");
            break;
        case WTF: 
            System.out.println("not a KeyEvent or MouseEvent?");
            break;
        default: 
            System.out.println("unimplemented command: "+c); 
            break;
        }
    }	

    public LinkedList<KeyEvent> getKeyHeldBuffer() {return keyHeldB;}
    public LinkedList<KeyEvent> getKeyPressBuffer() {return keyPressB;}
    public LinkedList<MouseEvent> getMouseBuffer() {return mouseInB;}
}
