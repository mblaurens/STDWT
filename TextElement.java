public class TextElement {
    private Vec2 pos;
    private String str;

    public TextElement(Vec2 p, String s) {
        pos = p;
        str = s;
    }

    public Vec2 getPos() {return pos;}
    public String getStr() {return str;}
    public void setPos(Vec2 p) {pos = p;}
    public void setStr(String s) {str = s;}
}
