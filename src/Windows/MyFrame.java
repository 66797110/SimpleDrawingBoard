package Windows;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Shapes.Shape;

class MyFrame extends JFrame
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 5034493155619668570L;
	//ͼ���ļ�
	private MyDocument myDocument;
	//�������
	private FileInOut fileInOut;
	//����
	private MyComponent myComponent;
	//��ť���
	private JPanel buttons;
	//��ť
	private JButton rect;
	private JButton tri;
	private JButton cir;
	//�˵�
	private JMenuBar bar;
	private JMenu file;
	private JMenuItem create;
	private JMenuItem open;
	private JMenuItem save;
	private JMenuItem saveAs;
	public MyFrame()
	{
		//��ʼ���ļ�
		myDocument = new MyDocument();
		//��ʼ���������
		fileInOut = new FileInOut();
		//��ʼ����ť
		buttons = new JPanel();
		buttons.setBackground(Color.WHITE);
		buttons.setPreferredSize(new Dimension(700, 300));
		rect = new JButton("�½�����");
		tri = new JButton("�½�������");
		cir = new JButton("�½�Բ��");
		//��ʼ���˵���
		bar = new JMenuBar();
		file = new JMenu("�ļ�");
		create = new JMenuItem("�½�");
		open = new JMenuItem("��");
		save = new JMenuItem("����");
		saveAs = new JMenuItem("����Ϊ");
		//����ť���ӽ���ť��
		ButtonGroup bg = new ButtonGroup();
		bg.add(rect);
		bg.add(tri);
		bg.add(cir);
		//��ѡ�����ӽ��˵���
		file.add(create);
		file.add(open);
		file.add(save);
		file.add(saveAs);
		bar.add(file);
		//����ť����������밴ť���
		buttons.setLayout(new FlowLayout());
		buttons.add(rect);  
		buttons.add(tri);  
		buttons.add(cir);  
		//����ť���ͻ��������
		setLayout(new BorderLayout());  
		setJMenuBar(bar);
		//add(myComponent, BorderLayout.SOUTH);  
		//add(buttons, BorderLayout.NORTH);
		//�˵�������
		create.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent event)
			{
				myComponent = new MyComponent();
				add(myComponent, BorderLayout.SOUTH);  
				add(buttons, BorderLayout.NORTH);
				setVisible(true);
				myDocument.clean();
				fileInOut.clean();
				//repaint();
			}
		});

		open.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent event) 
			{
				try {
					myComponent = new MyComponent();
					add(myComponent, BorderLayout.SOUTH);  
					add(buttons, BorderLayout.NORTH);
					myDocument.newList(fileInOut.open());
					myComponent.update(myDocument);
					setVisible(true);
				} catch (ClassNotFoundException | IOException e) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, "alert", "alert", JOptionPane.ERROR_MESSAGE);
					e.printStackTrace();
				}
				//repaint(); 
			}
		});

		save.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent event) 
			{
				try {
					fileInOut.save(myDocument.getList());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, "alert", "alert", JOptionPane.ERROR_MESSAGE);
					e.printStackTrace();
				}
			}
		});

		saveAs.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent event)
			{
				try {
					fileInOut.saveAs(myDocument.getList());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					//JOptionPane.showMessageDialog(null, "����", "���ļ����ʹ���", JOptionPane.ERROR_MESSAGE);
					e.printStackTrace();
				}
			}
		});



		//Ϊ��ť���ü���
		rect.addActionListener(new ActionListener() 
		{  
			public void actionPerformed(ActionEvent event) 
			{
				myDocument.update((Shape)new MyRectangle2D());
				myComponent.update(myDocument);
				repaint();  
			}  
		}); 
		tri.addActionListener(new ActionListener()
		{  
			public void actionPerformed(ActionEvent event)
			{
				myDocument.update((Shape)new MyTriangle2D());
				myComponent.update(myDocument);
				repaint();  
			}  
		});  
		cir.addActionListener(new ActionListener() 
		{  
			public void actionPerformed(ActionEvent event) 
			{
				myDocument.update((Shape)new MyCircle2D());
				myComponent.update(myDocument);
				repaint();  
			}  
		});
	}
}