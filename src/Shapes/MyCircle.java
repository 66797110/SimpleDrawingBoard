package Shapes;

public class MyCircle extends Shape{
	private static final long serialVersionUID = 1L;
	protected MyPoint o;      //Բ��
	protected double r;       //�뾶
	
	public MyCircle(MyPoint o,double r)
	{
		this.o = o;
		this.r = r;
	}
	
	public MyCircle(double x,double y,double r)
	{
		this(new MyPoint(x,y),r);
	}
	
	public MyCircle()
	{
		this(new MyPoint(),50);
	}
	
	public void Offset(double cx,double cy)   //Բ���ƶ�
	{
		this.o.Offset(cx, cy);
	}
	
	public void onSize(double cr)            //Բ������
	{
		this.r = cr;
	}
	public double getArea(MyPoint p)
	{
		return Math.PI*(Math.pow(p.getX()-o.getX(),2) + Math.pow(p.getY()-o.getY(),2));
	}
	public double getArea()
	{
		return Math.PI*Math.pow(r, 2);
	}
	public String writeObject()
	{
		String thisClass = " @MyCircle";
		String thisData = " @o = "+this.o.writeObject()+" @r = "+this.r+" ";
		return "</"+thisClass+thisData+"/>";
	}
}
