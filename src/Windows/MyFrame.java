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
	//图形文件
	private MyDocument myDocument;
	//输入输出
	private FileInOut fileInOut;
	//画板
	private MyComponent myComponent;
	//按钮面板
	private JPanel buttons;
	//按钮
	private JButton rect;
	private JButton tri;
	private JButton cir;
	//菜单
	private JMenuBar bar;
	private JMenu file;
	private JMenuItem create;
	private JMenuItem open;
	private JMenuItem save;
	private JMenuItem saveAs;
	public MyFrame()
	{
		//初始化文件
		myDocument = new MyDocument();
		//初始化输入输出
		fileInOut = new FileInOut();
		//初始化按钮
		buttons = new JPanel();
		buttons.setBackground(Color.WHITE);
		buttons.setPreferredSize(new Dimension(700, 300));
		rect = new JButton("新建矩形");
		tri = new JButton("新建三角形");
		cir = new JButton("新建圆形");
		//初始化菜单栏
		bar = new JMenuBar();
		file = new JMenu("文件");
		create = new JMenuItem("新建");
		open = new JMenuItem("打开");
		save = new JMenuItem("保存");
		saveAs = new JMenuItem("另存为");
		//将按钮添加进按钮组
		ButtonGroup bg = new ButtonGroup();
		bg.add(rect);
		bg.add(tri);
		bg.add(cir);
		//将选项添加进菜单栏
		file.add(create);
		file.add(open);
		file.add(save);
		file.add(saveAs);
		bar.add(file);
		//将按钮、下拉框加入按钮面板
		buttons.setLayout(new FlowLayout());
		buttons.add(rect);  
		buttons.add(tri);  
		buttons.add(cir);  
		//将按钮面板和画板加入框架
		setLayout(new BorderLayout());  
		setJMenuBar(bar);
		//add(myComponent, BorderLayout.SOUTH);  
		//add(buttons, BorderLayout.NORTH);
		//菜单栏监听
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
					//JOptionPane.showMessageDialog(null, "错误", "打开文件类型错误", JOptionPane.ERROR_MESSAGE);
					e.printStackTrace();
				}
			}
		});



		//为按钮设置监听
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
