package Windows;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import Shapes.Shape;

public class FileInOut {
	//����
	//private ArrayList list;
	//�򿪵��ļ���
	private String FileName;
	//���л�����
	private ObjectIOStream oios;
	
	public FileInOut()
	{
		FileName = null;
		oios = new ObjectIOStream();
	}
	
	//���ļ�
	public ArrayList<?> open() throws ClassNotFoundException, IOException
	{
		ArrayList<?> list;
		var fc = new JFileChooser();
		fc.setCurrentDirectory(new File("../"));//Ĭ�ϴ�λ��
		fc.setDialogTitle("���ļ�");//����
		//fc.setSelectedFile(new File("test.txt"));//Ĭ���ļ���
		fc.showOpenDialog(null);
		FileName = fc.getSelectedFile().getAbsolutePath();
		if(FileName.endsWith(".txt")) {
			list = oios.objectInput(FileName);
			return list;
		}
		JOptionPane.showMessageDialog(null, "���ļ����ʹ���", "����", JOptionPane.ERROR_MESSAGE);
		return null;
	}

	//�洢�ļ�
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
			fc.setCurrentDirectory(new File("../"));//Ĭ�ϴ�λ��
			fc.setDialogTitle("�����ļ�");//����
			fc.setSelectedFile(new File("test.txt"));//Ĭ���ļ���
			fc.showSaveDialog(null);
			FileName = fc.getSelectedFile().getAbsolutePath();//����Ƚ�����·��
			if(FileName.endsWith(".txt"))
			{
				oios.objectOutput(list,FileName);
				return;
			}
			JOptionPane.showMessageDialog(null, "��ʹ��txt���ͽ��б���", "����", JOptionPane.ERROR_MESSAGE);
		}
	}


	//����ļ�
	public void saveAs(ArrayList<Shape> list) throws IOException
	{
		var fc = new JFileChooser();
		fc.setCurrentDirectory(new File("../"));//Ĭ�ϴ�λ��
		fc.setDialogTitle("�����ļ�");//����
		fc.setSelectedFile(new File("test.txt"));//Ĭ���ļ���
		fc.showSaveDialog(null);
		FileName = fc.getSelectedFile().getAbsolutePath();//����Ƚ�����·��
		if(FileName.endsWith(".txt"))
		{
			oios.objectOutput(list,FileName);
			return;
		}
		JOptionPane.showMessageDialog(null, "��ʹ��txt���ͽ��б���", "����", JOptionPane.ERROR_MESSAGE);
	}
	
	public void clean()
	{
		FileName = null;
	}
}
