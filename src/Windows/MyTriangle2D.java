package Windows;

import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;

import Shapes.MyPoint;
import Shapes.MyTriangle;

public class MyTriangle2D extends MyTriangle{
	private static final long serialVersionUID = 1L;
	private static final double A = 5;
	private static final double B = 0.000001;
	public MyTriangle2D()
	{
	}
	public MyTriangle2D(MyPoint a,MyPoint b,MyPoint c)
	{
		this.a = a;
		this.b = b;
		this.c = c;
	}
	public boolean contains(Point2D p)
	{
		MyPoint d = new MyPoint(p.getX(),p.getY());
		double ABC = getArea(this.a, this.b, this.c);
		double ALL = getArea(d, this.b, this.c) + getArea(this.a, d, this.c) + getArea(this.a, this.b, d);
		//判断点是否在三角形内
		if(-B<(ABC-ALL) && (ALL-ABC)<B)
			return true;
		return false;
	}

	public int on(Point2D p)
	{
		double x = p.getX();
		double y = p.getY();
		if(this.a.getX()-A<x && x<this.a.getX()+A && this.a.getY()-A<y && y<this.a.getY()+A)
			return Cursor.N_RESIZE_CURSOR;
		else if(this.b.getX()-A<x && x<this.b.getX()+A && this.b.getY()-A<y && y<this.b.getY()+A)
			return Cursor.SW_RESIZE_CURSOR;
		else if(this.c.getX()-A<x && x<this.c.getX()+A && this.c.getY()-A<y && y<this.c.getY()+A)
			return Cursor.SE_RESIZE_CURSOR;
		else
			return 0;		
	}

	public void onSize(double newX,double newY,double oldX,double oldY,int state)   //拉伸
	{
		if(state == Cursor.N_RESIZE_CURSOR)
			this.a.Offset(newX-oldX, newY-oldY);
		else if(state == Cursor.SW_RESIZE_CURSOR)
			this.b.Offset(newX-oldX, newY-oldY);
		else if(state == Cursor.SE_RESIZE_CURSOR)
			this.c.Offset(newX-oldX, newY-oldY);
	}

	//画三角形
	public void draw(Graphics g)
	{
		var g2 = (Graphics2D)g;
		g2.draw(new Line2D.Double(this.a.getX(),this.a.getY(),this.b.getX(),this.b.getY()));
		g2.draw(new Line2D.Double(this.a.getX(),this.a.getY(),this.c.getX(),this.c.getY()));
		g2.draw(new Line2D.Double(this.c.getX(),this.c.getY(),this.b.getX(),this.b.getY()));
	}
}
