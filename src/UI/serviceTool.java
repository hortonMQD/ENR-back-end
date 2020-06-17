package UI;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import BLL.AuditServer;
import BLL.BookServer;
import BLL.DepartmentServer;
import BLL.LimitServer;
import BLL.PersonalServer;
import BLL.UserServer;
import Model.project;

public class serviceTool {


	public static ServerSocket server;
	public static Socket socket;
	public static  Thread accpet;
	
	
	
	public void getserver() {
			try {
				server = new ServerSocket(8998);
				software.ta.append("������������     ʱ�䣺"+software.dFormat.format(new Date())+ '\n');
				software.ta.append("�ȴ�����     ʱ�䣺"+software.dFormat.format(new Date())+ '\n');
				Thread accpet = new Thread(new Runnable() {
					@Override
					public void run() {
						while(true) {
							try {
								socket = server.accept();
								software.ta.append("���ӳɹ�     ʱ�䣺"+software.dFormat.format(new Date())+ '\n');
								InputStream in=socket.getInputStream();//��ȡsocket��������
					            byte[]by=new byte[1024*1024];
					            int len=in.read(by);
				                String JsonData = new String(by,0,len);			//��ȡjson����
				                String out = getClientMessage(JsonData);	
				                OutputStream os = socket.getOutputStream();	
				                os.write(out.getBytes("UTF-8"));
				                os.flush();
				                socket.close();
								software.ta.append("�����ж�     ʱ�䣺"+software.dFormat.format(new Date())+ '\n');
							} catch (IOException e) {
								e.printStackTrace();
							}
						}
					}
				});
				accpet.start();
			} catch (IOException e) {
				software.ta.append("�������˿ڱ�ռ��     ʱ�䣺"+software.dFormat.format(new Date())+ '\n');
				e.printStackTrace();
			}
	}
	
	private String getClientMessage(String Json) {
		
		JSONObject object = JSON.parseObject(Json);
		project data = new project();
		data.setField(object.getString("Field"));
		data.setSearch_type(object.getString("Search_type"));
		data.setType(object.getString("Type"));
		data = choiceService(data);				//����ִ�в���
		Json = JSON.toJSONString(data);
		return Json;
	}
	
	/*
	 * 1:	�鼮����
	 * 2:	����Ա����
	 * 3:	�û�����
	 * 4:	ͼ�����
	 * 5��	���Ź���
	 * 6��	Ȩ�޹���
	 */
	public project choiceService(project project) {
		String result = null;	
		switch (project.getSearch_type()) {
		case "1":
			result = new BookServer().switchOperation(project);
			break;
		case "2":
			result = new PersonalServer().switchOperation(project);
			break;
		case "3":
			result = new UserServer().switchOperation(project);
			break;
		case "4":
			result = new AuditServer().switchOperation(project);
			break;
		case "5":
			result = new DepartmentServer().switchOperation(project);
			break;
		case "6":
			result = new LimitServer().switchOperation(project);
			break;
		}
		project.setField(result);
		project.setSearch_type("0");
		project.setType(null);
		return project;
	}
	
}
