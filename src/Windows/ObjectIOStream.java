package Windows;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import Shapes.MyPoint;
import Shapes.Shape;

public class ObjectIOStream {
	private MyPoint p;
	private MyPoint a,b,c;
	private ArrayList<Shape> List = new ArrayList<Shape>();
	//序列化
	public void objectOutput(ArrayList<Shape> list,String File)
	{
		File writeFile = new File(File);
		BufferedWriter out = null;
		try {
			out = new BufferedWriter(new FileWriter(writeFile));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "新建文件失败", "错误", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
		for(Shape s : list)
		{
			try {
				out.write(s.writeObject()+"\n");
				//out.write()
			} catch (IOException e) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(null, "写入文件失败", "错误", JOptionPane.ERROR_MESSAGE);
				e.printStackTrace();
			}
		}
		try {
			out.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "关闭文件失败", "错误", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
	}
	//反序列化
	public ArrayList<Shape> objectInput(String File) throws IOException
	{
		List.clear();
		String str;
		BufferedReader br = new BufferedReader(new FileReader(File));	
		while((str = br.readLine())!=null)
		{
			String [] arr = str.split("\\s+");
			if(arr[0].equals("</"))
				handleClass(1,arr);
		}
		br.close();
		return List;
	}
	//处理类对象
	private int handleClass(int i,String [] arr)
	{
		if(arr[i].equals("@MyPoint"))
		{
			double x = 0;
			double y = 0;
			if(arr[++i].equals("@x"))
			{
				i=i+2;
				x = Double.parseDouble(arr[i]);
			}
			if(arr[++i].equals("@y"))
			{
				i=i+2;
				y = Double.parseDouble(arr[i]);
			}
			if(arr[++i].equals("/>"))
			{
				p = new MyPoint(x,y);
				return i;
			}
		}
		if(arr[i].equals("@MyCircle"))
		{
			double r = 0;
			if(arr[++i].equals("@o"))
			{
				i=i+2;
				if(arr[i].equals("</"))
					i = handleClass(++i,arr);
			}
			if(arr[++i].equals("@r"))
			{
				i=i+2;
				r = Double.parseDouble(arr[i]);
			}
			if(arr[++i].equals("/>"))
			{
				var circle = new MyCircle2D(p,r);
				List.add(circle);
				return i;
			}
		}
		if(arr[i].equals("@MyRectangle"))
		{
			double longth = 0;
			double width = 0;
			if(arr[++i].equals("@p"))
			{
				i=i+2;
				if(arr[i].equals("</"))
					i = handleClass(++i,arr);
			}
			if(arr[++i].equals("@longth"))
			{
				i=i+2;
				longth = Double.parseDouble(arr[i]);
			}
			if(arr[++i].equals("@width"))
			{
				i=i+2;
				width = Double.parseDouble(arr[i]);
			}
			if(arr[++i].equals("/>"))
			{
				var rect = new MyRectangle2D(p,longth,width);
				List.add(rect);
				return i;
			}
		}
		if(arr[i].equals("@MyTriangle"))
		{
			if(arr[++i].equals("@a")) 
			{
				i=i+2;
				if(arr[i].equals("</"))
					i = handleClass(++i,arr);
				a = p;
			}
			if(arr[++i].equals("@b")) 
			{
				i=i+2;
				if(arr[i].equals("</"))
					i = handleClass(++i,arr);
				b = p;
			}
			if(arr[++i].equals("@c")) 
			{
				i=i+2;
				if(arr[i].equals("</"))
					i = handleClass(++i,arr);
				c = p;
			}
			if(arr[++i].equals("/>"))
			{
				var tri = new MyTriangle2D(a,b,c);
				List.add(tri);
				return i;
			}
		}
		return i;
	}
}
