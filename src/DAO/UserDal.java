package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Model.UserInfo;

public class UserDal extends DBTool{

	
	
	/**
	 * ����û�����
	 * @param info  �û�����
	 * @return ���ɹ�����true
	 */
	public boolean Insert(UserInfo info) {
		boolean result = false;
		String[] messages = {info.getId(),info.getuName(),info.getEmail(),info.getPwd()};
        String sql = "insert User (ID,UName,Email,pwd) values(?,?,?,?);";
        PreparedStatement[] SQL = {SetSQLString(sql, messages)};
        result = InsertUpdateDelete(SQL);
        return result;
	}
	
	/**
	 * �޸��û���Ϣ
	 * @param info	�û�����
	 * @return ���ɹ�����true
	 */
	public boolean Updata(UserInfo info) {
		boolean result = false;
		String[] messages = {info.getuName(),info.getEmail(),info.getId()};
         String sql = "update User set UName = ?,Email = ? where ID = ?";
         PreparedStatement[] SQL = {SetSQLString(sql, messages)};
         result = InsertUpdateDelete(SQL);
         return result;
	}
	
	/**
	 * �޸��û�����
	 * @param info	�û�����
	 * @return ���ɹ�����true
	 */
	public boolean UpdataPwdWithParameter(UserInfo info){
		boolean result = false;
		String[] messages = {info.getPwd(),info.getId()};
        String sql = "update User set pwd = ? where ID = ?";
        PreparedStatement[] SQL = {SetSQLString(sql, messages)};
        result = InsertUpdateDelete(SQL);
        return result;
    }

	
	/**
	 * ���ݴ��������ѯ�û�
	 * @param info 	�û�����
	 * @return	�������ݼ���
	 */
	public List<UserInfo> SelectUserWithParameter(UserInfo info){
		List<String> SelectMessage = new ArrayList<String>();
        String sql = "Select ID,UName,Email,pwd from User where 1=1";
        if (info.getId() != null) { sql = sql + " and ID = ? "; SelectMessage.add(info.getId()); }
        if (info.getuName() != null) { sql = sql + " and UName = ? "; SelectMessage.add(info.getuName()); }
        if (info.getEmail() != null) { sql = sql + " and Email = ? "; SelectMessage.add(info.getEmail()); }
        if (info.getPwd() != null) { sql = sql + " and pwd = ?;"; SelectMessage.add(info.getPwd()); }
        String[] array = new String[SelectMessage.size()]; 
        return setUserData(SelectWithParameter(sql, SelectMessage.toArray(array)));
    }
	
	
	/**
	 * ��ѯ�����û�
	 * @return	�������ݼ���
	 */
	public List<UserInfo> SelectUserNoParameter(){
        String sql = "Select ID,UName,Email,pwd from User";
        return setUserData(SelectNoParameter(sql));
    }

	
	/**
	 * �����ݼ����е���Ϣ��ӵ����󼯺���
	 * @param ResultSet		���ݼ���
	 * @return	���󼯺�
	 */
	public List<UserInfo> setUserData(ResultSet ResultSet){
		List<UserInfo> infos = new ArrayList<>();
		try {
			while(ResultSet.next()){
				UserInfo info = new UserInfo();
				info.setId(ResultSet.getString("ID"));
				info.setPwd(ResultSet.getString("pwd"));
				info.setuName(ResultSet.getString("UName"));
				info.setEmail(ResultSet.getString("Email"));
				infos.add(info);
			}
			close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return infos;
    }
	
	
	
}
