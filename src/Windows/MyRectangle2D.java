package Windows;

import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;

import Shapes.MyPoint;
import Shapes.MyRectangle;

public class MyRectangle2D extends MyRectangle{
	private static final long serialVersionUID = 1L;
	private static final double A = 5;
	public MyRectangle2D()
	{
	}
	public MyRectangle2D(MyPoint p,double longth,double width)
	{
		this.p = p;
		this.longth = longth;
		this.width = width;
	}
	public boolean contains(Point2D p)
	{
		double x = p.getX();
		double y = p.getY();
		if(this.p.getX()<x && x<this.p.getX()+this.longth && 
				this.p.getY()<y && y<this.p.getY()+this.width)
			return true;
		return false;
	}

	public int on(Point2D p)
	{
		double x = p.getX();
		double y = p.getY();
		if(this.p.getX()-A<x && x<this.p.getX()+A && this.p.getY()-A<y && y<this.p.getY()+A)
			return Cursor.NW_RESIZE_CURSOR;
		else if(this.p.getX()-A<x && x<this.p.getX()+A && this.p.getY()<y && y<this.p.getY()+this.width)
			return Cursor.W_RESIZE_CURSOR;
		else if(this.p.getY()-A<y && y<this.p.getY()+A && this.p.getX()<x && x<this.p.getX()+this.longth)
			return Cursor.N_RESIZE_CURSOR;
		else if(this.p.getX()+this.longth-A<x && x<this.p.getX()+this.longth+A && this.p.getY()-A<y && y<this.p.getY()+A)
			return Cursor.NE_RESIZE_CURSOR;
		else if(this.p.getX()+this.longth-A<x && x<this.p.getX()+this.longth+A && this.p.getY()<y && y<this.p.getY()+this.width)
			return Cursor.E_RESIZE_CURSOR;
		else if(this.p.getX()+this.longth-A<x && x<this.p.getX()+this.longth+A && this.p.getY()+this.width-A<y && y<this.p.getY()+this.width+A)
			return Cursor.SE_RESIZE_CURSOR;
		else if(this.p.getY()+this.width-A<y && y<this.p.getY()+this.width+A && this.p.getX()<x && x<this.p.getX()+this.longth)
			return Cursor.S_RESIZE_CURSOR;
		else if(this.p.getX()-A<x && x<this.p.getX()+A && this.p.getY()+this.width-A<y && y<this.p.getY()+this.width+A)
			return Cursor.SW_RESIZE_CURSOR;
		else
			return 0;		
	}

	public void onSize(double newX,double newY,double oldX,double oldY,int state)
	{
		switch (state)
		{
		case Cursor.E_RESIZE_CURSOR:
			this.longth += newX-oldX;
			break;
		case Cursor.S_RESIZE_CURSOR:
			this.width += newY-oldY;
			break;
		case Cursor.SE_RESIZE_CURSOR:
			this.longth += newX-oldX;
			this.width += newY-oldY;
			break;
		case Cursor.N_RESIZE_CURSOR:
			this.p.Offset(0, newY-oldY);
			this.width -= newY-oldY;
			break;
		case Cursor.W_RESIZE_CURSOR:
			this.p.Offset(newX-oldX, 0);
			this.longth -= newX-oldX;
			break;
		case Cursor.NW_RESIZE_CURSOR:
			this.p.Offset(newX-oldX, newY-oldY);
			this.longth -= newX-oldX;
			this.width -= newY-oldY;
			break;
		case Cursor.NE_RESIZE_CURSOR:
			this.p.Offset(0, newY-oldY);
			this.longth += newX-oldX;
			this.width -= newY-oldY;
			break;
		case Cursor.SW_RESIZE_CURSOR:
			this.p.Offset(newX-oldX, 0);
			this.longth -= newX-oldX;
			this.width += newY-oldY;
			break;
		}
	}

	//»­¾ØÐÎ
	public void draw(Graphics g)
	{
		double x = this.p.getX();
		double y = this.p.getY();
		var g2 = (Graphics2D)g;
		g2.draw(new Line2D.Double(x,y,x+this.longth,y));
		g2.draw(new Line2D.Double(x,y,x,y+this.width));
		g2.draw(new Line2D.Double(x+this.longth,y,x+this.longth,y+this.width));
		g2.draw(new Line2D.Double(x,y+this.width,x+this.longth,y+this.width));
	}
}
