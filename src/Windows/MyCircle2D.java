package Windows;

import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Point2D;

import Shapes.MyCircle;
import Shapes.MyPoint;

public class MyCircle2D extends MyCircle{
	private static final long serialVersionUID = 1L;
	private static final double A = 5;
	private static final double B = 10;

	public MyCircle2D()
	{
	}
	public MyCircle2D(MyPoint o,double r)
	{
		this.o = o;
		this.r = r;
	}
	public boolean contains(Point2D p)
	{
		MyPoint d = new MyPoint(p.getX(),p.getY());
		double R1 = getArea();
		double R2 = getArea(d);
		//判断点是否在圆形内
		if(0<=R2 && R2<R1-B)
			return true;
		return false;
	}

	public int on(Point2D p)
	{
		double R = Math.sqrt(Math.pow(p.getX()-o.getX(),2) + Math.pow(p.getY()-o.getY(),2));
		if(r-A<R && R<r+A)
			return Cursor.HAND_CURSOR;
		else
			return 0;		
	}

	public void onSize(double newX,double newY,double oldX,double oldY,int state)   //拉伸
	{
		this.r = Math.sqrt(Math.pow(newX-this.o.getX(), 2) + Math.pow(newY-this.o.getY(), 2));
	}

	//画圆形
	public void draw(Graphics g)
	{
		var g2 = (Graphics2D)g;
		g2.drawOval((int)(this.o.getX()-this.r), (int)(this.o.getY()-this.r), (int)this.r*2, (int)this.r*2);
	}
}
