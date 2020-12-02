package Windows;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Graphics;

import Shapes.Shape;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.JComponent;

public class MyComponent extends JComponent
{
	private static final long serialVersionUID = -6193703465037293264L;
	//��������
	private static final int DEFAULT_WIDTH = 700;
	private static final int DEFAULT_HEIGHT = 700;

	//ͼ��
	private Shape current;
	private double x,y;

	//ͼ���ļ�
	private MyDocument myDocument = new MyDocument();

	//��ʼ������
	public MyComponent()  
	{
		current = null;
		addMouseListener(new MouseHandler());
		addMouseMotionListener(new MouseMotionHandler());
	}

	//���û�������
	public Dimension getPreferredSize()
	{
		return new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT);
	}
	//�Ի������л���
	public void paintComponent(Graphics g)  
	{
		g.setColor(Color.WHITE);
		g.fillRect(0,0,this.getWidth(),this.getHeight());  //��䱳��
		g.setColor(Color.BLACK);
		for(Shape s ;(s = myDocument.getNext()) != null;)
			s.draw(g);
	}
	//��������
	public void update(MyDocument d)
	{
		this.myDocument = d;
	}
	//������
	private class MouseHandler extends MouseAdapter
	{
		public void mousePressed(MouseEvent event)
		{
			if((current = myDocument.findIn(event.getPoint())) != null || (current = myDocument.findOn(event.getPoint())) != null)
				myDocument.move(current);
		}

		public void mouseClicked(MouseEvent event)
		{
			if((current = myDocument.findIn(event.getPoint())) != null || myDocument.findOn(event.getPoint()) != null)
				myDocument.move(current);
			if(current !=null && event.getClickCount() >= 2)
			{
				myDocument.remove(current);
				repaint();
			}
		}
	}
	//������
	private class MouseMotionHandler implements MouseMotionListener
	{
		private int state = -1,p;
		public void mouseMoved(MouseEvent event)
		{
			Shape s;
			if(myDocument.findIn(event.getPoint()) != null)
			{
				setCursor(Cursor.getPredefinedCursor(Cursor.MOVE_CURSOR));
				state = 0;
				x = event.getX();
				y = event.getY();
			}
			else if((s = myDocument.findOn(event.getPoint())) != null)
			{
				p = s.on(event.getPoint());
				setCursor(Cursor.getPredefinedCursor(p));
				state = 1;
				x = event.getX();
				y = event.getY();
			}
			else 
			{
				setCursor(Cursor.getDefaultCursor());
				state = -1;
			}
		}

		public void mouseDragged(MouseEvent event) {
			double newX = event.getX();
			double newY = event.getY();
			if(state == 0)
				current.Offset(newX-x,newY-y);
			else if(state == 1)
				current.onSize(newX,newY,x,y,p);
			x = newX;
			y = newY;
			repaint();
		}
	}
}