package Shapes;

public class MyTriangle extends Shape{
	private static final long serialVersionUID = 1L;
	protected MyPoint a,b,c;
	
	public MyTriangle(MyPoint a,MyPoint b,MyPoint c)
	{
		this.a = a;
		this.b = b;
		this.c = c;
	}
	public MyTriangle(double x1,double y1,double x2,double y2,double x3,double y3)
	{
		this(new MyPoint(x1,y1),new MyPoint(x2,y2),new MyPoint(x3,y3));
	}
	public MyTriangle()
	{
		this(new MyPoint(200,200),new MyPoint(150,250),new MyPoint(250,250));
	}
	
	public void Offset(double cx,double cy)
	{
		this.a.Offset(cx, cy);
		this.b.Offset(cx, cy);
		this.c.Offset(cx, cy);
	}
	
	public double getArea(MyPoint a,MyPoint b,MyPoint c)
	{
		double A = Math.sqrt(Math.pow(a.getX()-b.getX(),2) + Math.pow(a.getY()-b.getY(),2));
		double B = Math.sqrt(Math.pow(a.getX()-c.getX(),2) + Math.pow(a.getY()-c.getY(),2));
		double C = Math.sqrt(Math.pow(c.getX()-b.getX(),2) + Math.pow(c.getY()-b.getY(),2));
		double p = (A + B + C) / 2;
		return Math.sqrt(p*(p-A)*(p-B)*(p-C));
	}
	public String writeObject()
	{
		String thisClass = " @MyTriangle";
		String thisData = " @a = "+this.a.writeObject()+" @b = "+this.b.writeObject()+" @c = "+this.c.writeObject()+" ";
		return "</"+thisClass+thisData+"/>";
	}
}
