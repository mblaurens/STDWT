public class Button extends GfxEffect {
    ButtonAction action;
    
    public Button(ButtonAction ba, Sprite s, Vec2 p) {
        super(s,p);
        action = ba;
    }

    public void activate() {
        switch(action) {
        case NOTHING:
            break;
        case WTF:
            System.out.println("wtf");
            break;
        default:
            System.out.println("how?");
            break;
        }
    }
}
