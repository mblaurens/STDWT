import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.util.*;
import java.io.*;

public class Game {
    private final long TARGET_FPS = 30;
    private final boolean SHOW_PERFORMANCE_NONSENSE = true;
    
    private Random rng = new Random();
    private GfxStuff gfx = new GfxStuff();
    private InputManager input = new InputManager(this);
    private Gui gui = new Gui(this);

    private long gamestarttime;
    private long framestarttime;
    private long frametime;
    private long sleeptime;
    private long curframe = 0;
    private long totalrun = 0;
    private long totalwork = 0;
    private long totalsleep = 0;
    private long catchup = 0;
    
    public Game() {
        initGame();
    }

    public void initGame() {
        gamestarttime = System.currentTimeMillis();
        gfx.refresh();
        test();
    }
    
    public void run() {
        boolean gogogo = true;
        while(gogogo) {gameLoop();}
    }

    public void gameLoop() {
        framestarttime = System.currentTimeMillis();
        doInput();
        render();
        sleepy();
        if(curframe%30==0 && SHOW_PERFORMANCE_NONSENSE) {
            printPerformanceNonsense();
        }
        curframe++;
    }

    public void sleepy() {
        frametime = System.currentTimeMillis()-framestarttime;
        if (TARGET_FPS > 0) {
            sleeptime = 1000/TARGET_FPS-frametime;
            if (sleeptime>0) {
                try {
                    Thread.sleep(sleeptime);
                } catch(InterruptedException e) {
                    System.out.println(e);
                    Thread.currentThread().interrupt();
                }
                totalsleep+=sleeptime;
            } else {
                catchup-=sleeptime;
            }
        }
        totalwork += frametime;
        totalrun = System.currentTimeMillis()-gamestarttime;
    }

    public void printPerformanceNonsense() {
        String p = "\n";
        p+="Frame: "+curframe+"\n";
        p+="  Total Run Time:"+totalrun+"ms\n";
        p+="  Total Work Time:"+totalwork+"ms\n";
        p+="  Total Sleep Time:"+totalsleep+"ms\n";
        p+="  Total Catchup Time:"+catchup+"ms\n";
        p+="  % Total Work Time:"+(Math.round(10000.0*(double)totalwork/(double)totalrun)/100.0)+"%";
        System.out.println(p);
    }
	
    public void doInput() {input.doInput();}
    public void render() {gfx.refresh();}

    public void pushKeyInput(KeyEvent e) {input.pushKeyPress(e);}
    public void removeKeyInput(KeyEvent e) {input.removeKeyInput(e);}
    public void pushMouseInput(MouseEvent e) {input.pushMouseInput(e);}

    public Gui getGui() {return gui;}
    public GfxStuff getGfx() {return gfx;}

    public void test() {
        //gfx.getDisplays()[0].tileBG(gfx.readImage("img/dirt.png"));
        gfx.getDisplays()[1].tileBG(gfx.readImage("img/diamond.png"));
        gfx.getDisplays()[2].tileBG(gfx.readImage("img/dirt.png"));
    }
}
