package Shapes;

import java.awt.Graphics;
import java.awt.geom.Point2D;
import java.io.Serializable;

public class Shape implements Serializable{
	private static final long serialVersionUID = 1L;
	//�ƶ�
	public void Offset(double cx,double cy) 
	{
		
	}
	//�ı��С
	public void onSize(double newX,double newY,double oldX,double oldY,int state)   //����
	{
		
	}
	//����Ƿ���ͼ����
	public boolean contains(Point2D p)  
	{
		return true;
	}
	//����Ƿ���ͼ����
	public int on(Point2D p)
	{
		return 0;		
	}
	//��ͼ
	public void draw(Graphics g)
	{
		
	}
	//�����ڲ���ɫ
	public void setColorIn()
	{
		
	}
	//���ñ߿���ɫ
	public void setColorOn()
	{
		
	}
	//���л�
	public String writeObject()
	{
		return null;
	}
}