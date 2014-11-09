import java.awt.*;

public class GfxEffect implements Spritable {
    private Sprite sprite;
    private int lifetime;
    private Vec2 pos;
    private Vec2 vel;
    private double rotation;
    private double angVel;
    
    public GfxEffect(Sprite s, Vec2 p) {
        sprite = s;
        lifetime = -1;
        pos = p;
        vel = new Vec2(0.0,0.0);
        rotation = 0;
        angVel = 0;
    }
    
    public Sprite getSprite() {return sprite;}
    public Vec2 getPos() {return pos;}
    public double getRotation() {return rotation;}
}
