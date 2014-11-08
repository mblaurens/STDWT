import java.awt.*;

public class Vec2 extends Point.Double {
    public Vec2() {super();}
    public Vec2(double x, double y) {super(x,y);}
    public Vec2(Vec2 v) {super(v.getX(),v.getY());}

    public double magnitude() {return Math.sqrt(x*x+y*y);}
    public double sqMagnitude() {return x*x+y*y;}

    public Vec2 copy() {return new Vec2(x,y);}
    public void setX(double n) {x=n;}
    public void setY(double n) {y=n;}

    public void invert()         {x=-x; y=-y;}
    public void scale(double n)  {x*=n; y*=n;}
    public void add(Vec2 v)      {x+=v.getX(); y+=v.getY();}
    public void subtract(Vec2 v) {x-=v.getX(); y-=v.getY();}

    public Vec2 invVec()           {Vec2 r=copy();  r.invert();     return r;}
    public Vec2 scaleVec(double n) {Vec2 r=copy();  r.scale(n);     return r;}
    public Vec2 sumVec(Vec2 v)     {Vec2 r=copy();  r.add(v);       return r;}
    public Vec2 diffVec(Vec2 v)    {Vec2 r=copy();  r.subtract(v);  return r;}

    public Vec2 compProduct(Vec2 v) {return new Vec2(x*v.getX(), y*v.getY());}
    public double scalarProduct(Vec2 v) {return x*v.getX() + y*v.getY();}

    public Vec2 unitVector() {
	double mag = magnitude();
	if(mag!=0) {return scaleVec(1/magnitude());}
	return this;
    }


    public void xBounce() {
        x=-x;
    }
    public void yBounce() {
       y=-y;
    }
}
