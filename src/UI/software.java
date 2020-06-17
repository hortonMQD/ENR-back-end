package UI;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class software extends JFrame{

	
	private static final long serialVersionUID = 6736177792801417510L;
	private JFrame jFrame = new JFrame("图书管理系统服务器");
	public static JTextArea ta = new JTextArea(); // 创建JtextArea对象
	private static JButton start = new JButton("启动"); // 启动服务器按钮	
	public static SimpleDateFormat dFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//创建时间格式
	JPanel btPanel;
	
	
	
	public software() {
		ta.setLineWrap(true);
		JScrollPane scrollPane = new JScrollPane(ta);
		jFrame.getContentPane().add(scrollPane, BorderLayout.CENTER);// 初始化文本域面板
		jFrame.getContentPane().add(initPanel(), "South"); // 初始化按钮面板
		jFrame.setJMenuBar(initMenuBar());// 初始化窗体菜单栏
		jFrame.setVisible(true);		//设置窗体可见
		jFrame.setLocationRelativeTo(null);//设置窗体居中显示
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//设置关闭方式
		jFrame.setSize(400, 500);
	}
	
	
	private boolean expotTxt(StringBuffer log) {
		JFileChooser fcDlg = new JFileChooser();
        fcDlg.setDialogTitle("请选择导出文件路径");
        fcDlg.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int returnVal = fcDlg.showOpenDialog(null);
        String filepath = null;
        if (returnVal == JFileChooser.APPROVE_OPTION) {
          filepath = fcDlg.getSelectedFile().getPath();
        }
        SimpleDateFormat timeFormat = new SimpleDateFormat("yyyyMMdd HHmmss");//创建时间格式
        
		File file = new File(filepath+"\\log_"+timeFormat.format(new Date())+".horton");
		FileOutputStream out = null;
		OutputStreamWriter osw = null;
		BufferedWriter bw = null;
		try {
			out = new FileOutputStream(file);
			osw = new OutputStreamWriter(out);
			bw = new BufferedWriter(osw);
			bw.append(log);
			return true;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				if (bw != null) {
					bw.close();
					bw = null;
				}
				if (osw != null) {
					osw.close();
					osw = null;
				}
				if (out != null) {
					out.close();
					out = null;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return false;
	}
	
	
	public JMenuBar initMenuBar() {
		JMenuBar menuBar = new JMenuBar();		//创建菜单栏
		JMenu logManagement = new JMenu("日志管理");//创建“日志管理”菜单对象
		JMenuItem outLog = new JMenuItem("导出日志");//创建“导出日志”菜单项对象
		menuBar.add(logManagement);//将”用户管理“菜单对象添加到菜单栏
		logManagement.add(outLog);//将“修改密码”菜单项对象添加到用户管理菜单对象
		outLog.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				StringBuffer log = new StringBuffer(ta.getText());
				if (expotTxt(log)) {
					JOptionPane.showMessageDialog(null, "导出成功","导出结果",JOptionPane.PLAIN_MESSAGE);
				}else {
					JOptionPane.showMessageDialog(null, "导出失败","导出结果",JOptionPane.PLAIN_MESSAGE);
				}
			}
		});
		return menuBar;
	}
	
	
	public static JPanel initPanel() {
		JPanel panel = new JPanel();
		panel.add(start);
		start.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new serviceTool().getserver();
			}
		});
		return panel;
		
	}
	
	
	
}
