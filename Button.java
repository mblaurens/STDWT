public class Button extends GfxEffect {
    
    
    public Button(Sprite s, Vec2 p) {
        super(s,p);
    }

    public void activate() {
        System.out.println("ACTIVATE!");
    }
}
