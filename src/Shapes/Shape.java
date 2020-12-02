package Shapes;

import java.awt.Graphics;
import java.awt.geom.Point2D;
import java.io.Serializable;

public class Shape implements Serializable{
	private static final long serialVersionUID = 1L;
	//移动
	public void Offset(double cx,double cy) 
	{
		
	}
	//改变大小
	public void onSize(double newX,double newY,double oldX,double oldY,int state)   //拉伸
	{
		
	}
	//鼠标是否在图形内
	public boolean contains(Point2D p)  
	{
		return true;
	}
	//鼠标是否在图形上
	public int on(Point2D p)
	{
		return 0;		
	}
	//画图
	public void draw(Graphics g)
	{
		
	}
	//设置内部颜色
	public void setColorIn()
	{
		
	}
	//设置边框颜色
	public void setColorOn()
	{
		
	}
	//序列化
	public String writeObject()
	{
		return null;
	}
}