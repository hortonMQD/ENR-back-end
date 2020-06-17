package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Model.LimitInfo;

public class LimitDal extends DBTool{

	
	/**
	 * ��ѯ����Ȩ��
	 * @return  ����Ȩ�޼���
	 */
	public List<LimitInfo> SelectNoParameter(){
        String sql = "select ID,name,operation from `limit`";
        return setLimitData(SelectNoParameter(sql));
    }
	
	
	/**
	 * ���ݴ��������ѯȨ��
	 * @param info   Ȩ�޶���
	 * @return ����Ȩ�޼���
	 */
	public List<LimitInfo> SelectWithParameter(LimitInfo info)
    {
        List<String> SelectMessage = new ArrayList<String>();
        String sql = "select ID,name,operation from `limit` where 1=1";
        if (info.getId() != null) { sql = sql + " and ID = ? "; SelectMessage.add(info.getId()); }
        if (info.getName() != null) { sql = sql + " and name = ? "; SelectMessage.add(info.getName()); }
        if (info.getOperation() != null) { sql = sql + " and operation = ? "; SelectMessage.add(info.getOperation()); }
        sql += " order by ID";
        String[] array = new String[SelectMessage.size()]; 
        return setLimitData(SelectWithParameter(sql, SelectMessage.toArray(array)));
    }
	
	
	/**
	 * �����ݼ����е���Ϣ��ӵ�Ȩ�޶��󼯺���
	 * @param ResultSet		Ȩ�����ݼ���
	 * @return	Ȩ�޶��󼯺�
	 */
	public List<LimitInfo> setLimitData(ResultSet ResultSet) {
		List<LimitInfo> infos = new ArrayList<>();
		try {
			while(ResultSet.next()){
				LimitInfo info = new LimitInfo();
				info.setId(ResultSet.getString("ID"));
				info.setName(ResultSet.getString("name"));
				info.setOperation(ResultSet.getString("operation"));
				infos.add(info);
			}
			close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return infos;
	}
}
