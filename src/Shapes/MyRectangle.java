package Shapes;

public class MyRectangle extends Shape{
	private static final long serialVersionUID = 1L;
	protected MyPoint p;      //左上定点
	protected double longth;  //长
	protected double width;   //宽
	
	public MyRectangle(MyPoint p,double longth,double width)
	{
		this.p = p;
		this.longth = longth;
		this.width = width;
	}
	
	public MyRectangle(double x,double y,double longth,double width)
	{
		this(new MyPoint(x,y),longth,width);
	}
	
	public MyRectangle()
	{
		this(new MyPoint(),60,80);
	}
	
	public void Offset(double cx,double cy)   //矩形移动
	{
		this.p.Offset(cx, cy);
	}
	
	public void onSize(double cx,double cy)   //矩形拉伸
	{
		this.longth += cx;
		this.width += cy;
	}
	public String writeObject()
	{
		String thisClass = " @MyRectangle";
		String thisData = " @p = "+this.p.writeObject()+" @longth = "+this.longth+" @width = "+this.width+" ";
		return "</"+thisClass+thisData+"/>";
	}
}
