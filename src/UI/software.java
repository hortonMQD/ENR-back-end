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
	private JFrame jFrame = new JFrame("ͼ�����ϵͳ������");
	public static JTextArea ta = new JTextArea(); // ����JtextArea����
	private static JButton start = new JButton("����"); // ������������ť	
	public static SimpleDateFormat dFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//����ʱ���ʽ
	JPanel btPanel;
	
	
	
	public software() {
		ta.setLineWrap(true);
		JScrollPane scrollPane = new JScrollPane(ta);
		jFrame.getContentPane().add(scrollPane, BorderLayout.CENTER);// ��ʼ���ı������
		jFrame.getContentPane().add(initPanel(), "South"); // ��ʼ����ť���
		jFrame.setJMenuBar(initMenuBar());// ��ʼ������˵���
		jFrame.setVisible(true);		//���ô���ɼ�
		jFrame.setLocationRelativeTo(null);//���ô��������ʾ
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//���ùرշ�ʽ
		jFrame.setSize(400, 500);
	}
	
	
	private boolean expotTxt(StringBuffer log) {
		JFileChooser fcDlg = new JFileChooser();
        fcDlg.setDialogTitle("��ѡ�񵼳��ļ�·��");
        fcDlg.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int returnVal = fcDlg.showOpenDialog(null);
        String filepath = null;
        if (returnVal == JFileChooser.APPROVE_OPTION) {
          filepath = fcDlg.getSelectedFile().getPath();
        }
        SimpleDateFormat timeFormat = new SimpleDateFormat("yyyyMMdd HHmmss");//����ʱ���ʽ
        
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
		JMenuBar menuBar = new JMenuBar();		//�����˵���
		JMenu logManagement = new JMenu("��־����");//��������־�����˵�����
		JMenuItem outLog = new JMenuItem("������־");//������������־���˵������
		menuBar.add(logManagement);//�����û������˵�������ӵ��˵���
		logManagement.add(outLog);//�����޸����롱�˵��������ӵ��û�����˵�����
		outLog.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				StringBuffer log = new StringBuffer(ta.getText());
				if (expotTxt(log)) {
					JOptionPane.showMessageDialog(null, "�����ɹ�","�������",JOptionPane.PLAIN_MESSAGE);
				}else {
					JOptionPane.showMessageDialog(null, "����ʧ��","�������",JOptionPane.PLAIN_MESSAGE);
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
