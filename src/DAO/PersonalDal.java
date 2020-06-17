package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Model.PersonalInfo;

public class PersonalDal extends DBTool{

	
	/**
	 * �޸Ĺ���Ա����
	 * @param info  ����Ա����
	 * @return  ���ɹ�����true
	 */
	public Boolean Update(PersonalInfo info)
    {
        boolean result = false;
        List<String> SelectMessage = new ArrayList<String>();
        String sql = "update Personal set ID = ?";
        SelectMessage.add(info.getId());
        if (info.getName() != null) { sql += " ,personal.`name` = ? "; SelectMessage.add(info.getName()); }
        if (info.getPwd() != null) { sql = sql + " ,pwd = ? "; SelectMessage.add(info.getPwd()); }
        if (info.getDepartment() != null) { sql = sql + " ,department = ? "; SelectMessage.add(info.getDepartment()); }
        if (info.getLimit() != null) { sql = sql + " ,personal.`limit` = ? "; SelectMessage.add(info.getLimit()); }
        if (info.getTelephone() != null) { sql = sql + " ,telephone = ? "; SelectMessage.add(info.getTelephone()); }
        if (info.getCreateTime() != null) { sql = sql + " ,createTime = ? "; SelectMessage.add(info.getCreateTime()); }
        if (info.getIsDimission() != null) { sql = sql + " ,isDimission = ? "; SelectMessage.add(info.getIsDimission()); }
        if (info.getDimissionTime() != null) { sql = sql + " ,dimissionTime = ? ";SelectMessage.add(info.getDimissionTime()); }
        sql+= " where ID = ?";
        SelectMessage.add(info.getId());
        String[] array = new String[SelectMessage.size()]; 
        PreparedStatement[] SQL = {SetSQLString(sql, SelectMessage.toArray(array))};
        result = InsertUpdateDelete(SQL);
        
        return result;
    }
	
	
	/**
	 * ��ӹ���Ա����
	 * @param info  ����Ա����
	 * @return ���ɹ�����true
	 */
	public boolean Insert(PersonalInfo info)
    {
        boolean result = false;
        String[] messages = {info.getId(),info.getpId(),info.getName(),info.getDepartment(),info.getLimit(),info.getTelephone()};
        String sql = "insert personal(ID,PID,personal.`name`,pwd,department,personal.`limit`,telephone,createTime,isDimission) values(?,?,?,'123456',?,?,?,now(),0);";
        PreparedStatement[] SQL = {SetSQLString(sql, messages)};
        result = InsertUpdateDelete(SQL);
        return result;
    }
	
	/**
	 * ���ݴ���Ĳ�����ѯ����
	 * @param info  ��������
	 * @return	�������ݼ���
	 */
	public List<PersonalInfo> SelectPersonalWithParameter(PersonalInfo info)
    {
		List<String> SelectMessage = new ArrayList<String>();
        String sql = "select ID,PID,name,pwd,department,(select department.`name` from department where department.ID=personal.department) as 'departmentName'," + 
        		"personal.`limit`,telephone,createTime,isDimission,dimissionTime,(select `limit`.`name` from `limit` where `limit`.ID = personal.`limit`) as 'limitName' from personal where 1=1 ";
        if (info.getId() != null) { sql = sql + " and ID = ? "; SelectMessage.add(info.getId()); }
        if (info.getpId() != null) { sql = sql + " and PID = ? "; SelectMessage.add(info.getpId()); }
        if (info.getName() != null) { sql += " and name like ? "; SelectMessage.add("%"+info.getName()+"%"); }
        if (info.getPwd() != null) { sql = sql + " and pwd = ? "; SelectMessage.add(info.getPwd()); }
        if (info.getDepartment() != null) { sql = sql + " and department = ? "; SelectMessage.add(info.getDepartment()); }
        if (info.getLimit() != null) { sql = sql + " and limit = ? "; SelectMessage.add(info.getLimit()); }
        if (info.getTelephone() != null) { sql = sql + " and telephone = ? "; SelectMessage.add(info.getTelephone()); }
        if (info.getCreateTime() != null) { sql = sql + " and createTime = ? "; SelectMessage.add(info.getCreateTime()); }
        if (info.getIsDimission() != null) { sql = sql + " and isDimission = ? "; SelectMessage.add(info.getIsDimission()); }
        if (info.getDimissionTime() != null) { sql = sql + " and dimissionTime = ? "; SelectMessage.add(info.getDimissionTime());  }
        sql += " order by personal.createTime";
        String[] array = new String[SelectMessage.size()]; 
        return setPersonalData(SelectWithParameter(sql, SelectMessage.toArray(array)));
    }

	
	/**
	 * ��ѯ����
	 * @return  ���ݼ���
	 */
	public List<PersonalInfo> SelectPersonalNoParameter()
    {
        String sql = "select ID,PID,name,pwd,department,(select name from department where department.ID=personal.department) as 'departmentName',"
        		+ "personal.`limit`,(select `limit`.`name` from `limit` where `limit`.ID = personal.`limit`) as 'limitName',telephone,createTime,isDimission,dimissionTime from personal "
        		+ "order by personal.createTime";
        return setPersonalData(SelectNoParameter(sql));
    }
	
	/**
	 * �����ݼ����е���Ϣ��ӵ����󼯺���
	 * @param ResultSet		���ݼ���
	 * @return	���󼯺�
	 */
	public List<PersonalInfo> setPersonalData(ResultSet ResultSet)
    {
		List<PersonalInfo> infos = new ArrayList<>();
		try {
			while(ResultSet.next()){
				PersonalInfo info = new PersonalInfo();
				info.setId(ResultSet.getString("ID"));
				info.setpId(ResultSet.getString("PID"));
				info.setName(ResultSet.getString("name"));
				info.setPwd(ResultSet.getString("pwd"));
				info.setDepartment(ResultSet.getString("department"));
				info.setDepartmentName(ResultSet.getString("departmentName"));
				info.setLimit(ResultSet.getString("limit"));
				info.setTelephone(ResultSet.getString("telephone"));
				info.setCreateTime(ResultSet.getString("createTime"));
				info.setIsDimission(ResultSet.getString("isDimission"));
				info.setDimissionTime(ResultSet.getString("dimissionTime"));
				info.setLimitName(ResultSet.getString("limitName"));
				infos.add(info);
			}
			close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return infos;
    }
	
}
