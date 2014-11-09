import java.awt.event.*;

public enum Command {
    MOVE_UP,
    MOVE_LEFT,
    MOVE_DOWN,
    MOVE_RIGHT,
    DEBUG_DUMPDISPLAYS,
    INVALID_KEY_COMMAND,
    LEFT_CLICK,
    INVALID_MOUSE_COMMAND,
    NO_COMMAND,
    WTF
    ;

    public boolean hasRun=false;
    
    public static Command inputEventToCommand(InputEvent e) {
	if (e==null) {return NO_COMMAND;}
	if (e instanceof KeyEvent) {
	    switch (((KeyEvent)e).getKeyChar()) {
	    case 'w': return MOVE_UP;
	    case 'a': return MOVE_LEFT;
	    case 's': return MOVE_DOWN;
	    case 'd': return MOVE_RIGHT;
	    case '=': return DEBUG_DUMPDISPLAYS;
	    default:  return INVALID_KEY_COMMAND;
	    }
	} else if (e instanceof MouseEvent) {
	    switch(((MouseEvent) e).getButton()) {
	    case MouseEvent.BUTTON1: return LEFT_CLICK;
	    default: return INVALID_MOUSE_COMMAND;
	    }
	} else {
	    return WTF;
	}
    }
}
	
