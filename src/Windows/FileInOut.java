package Windows;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import Shapes.Shape;

public class FileInOut {
	//链表
	//private ArrayList list;
	//打开的文件名
	private String FileName;
	//序列化对象
	private ObjectIOStream oios;
	
	public FileInOut()
	{
		FileName = null;
		oios = new ObjectIOStream();
	}
	
	//打开文件
	public ArrayList<?> open() throws ClassNotFoundException, IOException
	{
		ArrayList<?> list;
		var fc = new JFileChooser();
		fc.setCurrentDirectory(new File("../"));//默认打开位置
		fc.setDialogTitle("打开文件");//标题
		//fc.setSelectedFile(new File("test.txt"));//默认文件名
		fc.showOpenDialog(null);
		FileName = fc.getSelectedFile().getAbsolutePath();
		if(FileName.endsWith(".txt")) {
			list = oios.objectInput(FileName);
			return list;
		}
		JOptionPane.showMessageDialog(null, "打开文件类型错误", "错误", JOptionPane.ERROR_MESSAGE);
		return null;
	}

	//存储文件
	public void save(ArrayList<Shape> list) throws IOException
	{
		if(FileName != null)
		{
			oios.objectOutput(list,FileName);
			return;
		}
		else
		{
			var fc = new JFileChooser();
			fc.setCurrentDirectory(new File("../"));//默认打开位置
			fc.setDialogTitle("保存文件");//标题
			fc.setSelectedFile(new File("test.txt"));//默认文件名
			fc.showSaveDialog(null);
			FileName = fc.getSelectedFile().getAbsolutePath();//获得稳健绝对路径
			if(FileName.endsWith(".txt"))
			{
				oios.objectOutput(list,FileName);
				return;
			}
			JOptionPane.showMessageDialog(null, "请使用txt类型进行保存", "错误", JOptionPane.ERROR_MESSAGE);
		}
	}


	//另存文件
	public void saveAs(ArrayList<Shape> list) throws IOException
	{
		var fc = new JFileChooser();
		fc.setCurrentDirectory(new File("../"));//默认打开位置
		fc.setDialogTitle("保存文件");//标题
		fc.setSelectedFile(new File("test.txt"));//默认文件名
		fc.showSaveDialog(null);
		FileName = fc.getSelectedFile().getAbsolutePath();//获得稳健绝对路径
		if(FileName.endsWith(".txt"))
		{
			oios.objectOutput(list,FileName);
			return;
		}
		JOptionPane.showMessageDialog(null, "请使用txt类型进行保存", "错误", JOptionPane.ERROR_MESSAGE);
	}
	
	public void clean()
	{
		FileName = null;
	}
}
