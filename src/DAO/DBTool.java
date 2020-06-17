package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import com.alibaba.fastjson.JSON;
import com.mysql.cj.jdbc.Driver;


public abstract class DBTool {
	
	static Connection con;
	static PreparedStatement sql;
	static ResultSet res;
	
	
	/**
	 * �������ݿ�����
	 */
    @SuppressWarnings("finally")
	public static Connection ConnectSQL() {   //�����������ݿ�ķ���   ����������ļ̳�
		try {
			Driver driver = new Driver();
			String url = "jdbc:mysql://localhost:3306/enr?serverTimezone=GMT%2B8&characterEncoding=UTF-8";
			Properties info = new Properties();
			info.put("user","root");
			info.put("password", "hq441521hq");
			con = driver.connect(url, info);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			return con;
		}
		
	}
    
    /**
    * �ر����ݿ�����
    */
    public static void close() {
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(con != null) {
				con =null;
			}
		}
	}
    
   
    
    public Boolean InsertUpdateDelete(PreparedStatement[] pstm) {
    	Connection connection = ConnectSQL();
		try {
			connection.setAutoCommit(false);		//�ر��Զ��ύ����������
			for(PreparedStatement SQL : pstm) {
				SQL.executeUpdate();
			}
			connection.commit();
			connection.setAutoCommit(true);
			close();
			return true;
		}catch (SQLException e) {
			try {
				connection.rollback();
				close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
			return false;
		}
    };
    
    
    public ResultSet SelectNoParameter(String SQL) {
    	ResultSet res = null;
    	try {
			PreparedStatement pstm = DBTool.ConnectSQL().prepareStatement(SQL);
			res = pstm.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
    }
    
    /**
     * 
     * @param SQL	sql���
     * @param messages	�����б�
     * @return
     */
    public ResultSet SelectWithParameter(String SQL,String[] messages) {
    	ResultSet res = null;
    	try {
			PreparedStatement pstm = DBTool.ConnectSQL().prepareStatement(SQL);
			for(int i = 0;i<messages.length;i++) {
				pstm.setString(i+1, messages[i]);
			}
			res = pstm.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
    }
   
    
    
    /**
     * ����SQL���
     * @param SQL	������SQL����ַ���
     * @param messages	SQL������
     * @return	Ԥ����SQL���
     */
    public static PreparedStatement SetSQLString(String SQL,String[] messages) {
    	PreparedStatement pstm = null;
		try {
			pstm = DBTool.ConnectSQL().prepareStatement(SQL);
			for(int i = 0;i<messages.length;i++) {
				pstm.setString(i+1, messages[i]);
				}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return pstm;
    }
    
    
    
    
    
    /**
	 * ����ɾ�ĵĲ������ת����json�ַ���
	 * @param result  ��ɾ�Ľ��
	 * @return	json�ַ���
	 */
	public String getJsonString(Boolean result) {
		return JSON.toJSONString(result);
	}
    

}
