package Shapes;

public class MyCircle extends Shape{
	private static final long serialVersionUID = 1L;
	protected MyPoint o;      //圆心
	protected double r;       //半径
	
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
	
	public void Offset(double cx,double cy)   //圆形移动
	{
		this.o.Offset(cx, cy);
	}
	
	public void onSize(double cr)            //圆形拉伸
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
