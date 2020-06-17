package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Model.DepartmentInfo;

public class DepartmentDal extends DBTool{

	
	
	/**
	 * 添加部门信息
	 * @param info	部门信息
	 * @return	若成功返回true
	 */
	public Boolean Insert(DepartmentInfo info) {
		Boolean result = false;
		String sql01 = "insert Department(ID,name,leader,createTime,isTrue,isAdministrative) values(?,?,?,now(),'1',?);";
		String[] messages01 = {info.getId(),info.getName(),info.getLeader(),info.getIsAdmin()};
		PreparedStatement[] SQL = {SetSQLString(sql01, messages01)};
		result = InsertUpdateDelete(SQL);
		return  result;
	}
	
	/**
	 * 修改部门信息
	 * @param info	部门信息
	 * @return	若成功返回true
	 */
	public Boolean Update(DepartmentInfo info) {
		Boolean result = false;
		List<String> SelectMessage = new ArrayList<String>();
		String sql01 = "update Department set ID = ?"; 
		SelectMessage.add(info.getId());
		 if (info.getName() != null) { sql01 = sql01 + " ,name = ? "; SelectMessage.add(info.getName()); }
         if (info.getLeader() != null) { sql01 = sql01 + " ,leader = ? ";SelectMessage.add(info.getLeader()); }
         if (info.getIsTrue() != null) { sql01 = sql01 + " ,isTrue = ? ";SelectMessage.add(info.getIsTrue()); }
         if (info.getIsAdmin() != null) { sql01 = sql01 + " ,isAdministrative = ? ";SelectMessage.add(info.getIsAdmin()); }
         sql01 += " where ID = ?";
         SelectMessage.add(info.getId());
         String[] array = new String[SelectMessage.size()]; 
		PreparedStatement[] SQL = {SetSQLString(sql01, SelectMessage.toArray(array))};
		result = InsertUpdateDelete(SQL);
		return result;
	}
	
	/**
	 * 根据传入的参数查询部门数据
	 * @param info	部门对象
	 * @return	部门对象集合
	 */
	public List<DepartmentInfo> SelectDepartmentWithParameter(DepartmentInfo info)
    {
		List<String> SelectMessage = new ArrayList<String>();
        String sql = "Select ID,name,leader,(select name from Personal where ID = leader) as 'leaderName',createTime,isTrue,isAdministrative from Department where 1=1";
        if (info.getId() != null) { sql = sql + " and ID = ? "; SelectMessage.add(info.getId()); }
        if (info.getName() != null) { sql = sql + " and name = ? "; SelectMessage.add(info.getName()); }
        if (info.getLeader() != null) { sql = sql + " and leader = ? "; SelectMessage.add(info.getLeader()); }
        if (info.getCreateTime() != null) { sql = sql + " and createTime = ?"; SelectMessage.add(info.getCreateTime()); }
        if (info.getIsTrue() != null) { sql = sql + " and isTrue = ?"; SelectMessage.add(info.getIsTrue()); }
        if (info.getIsAdmin() != null) { sql = sql + " and isAdministrative = ?"; SelectMessage.add(info.getIsAdmin()); }
        sql += " order by createTime desc";
        String[] array = new String[SelectMessage.size()]; 
        return setDepartmentData(SelectWithParameter(sql, SelectMessage.toArray(array)));
    }
	
	/**
	 * 查询部门数据
	 * @return	部门对象集合
	 */
	public List<DepartmentInfo> SelectDepartmenNoParameter()
    {
        String sql = "Select ID,name,leader,(select name from Personal where ID = leader) as 'leaderName',createTime,isTrue,isAdministrative from Department order by createTime desc";
        return setDepartmentData(SelectNoParameter(sql));
    }
	
	
	/**
	 * 将数据集合中的信息添加到部门对象集合中
	 * @param ResultSet		部门数据集合
	 * @return	部门对象集合
	 */
	public List<DepartmentInfo> setDepartmentData(ResultSet ResultSet) {
		List<DepartmentInfo> infos = new ArrayList<>();
		try {
			while(ResultSet.next()){
				DepartmentInfo Info = new DepartmentInfo();
				Info.setId(ResultSet.getString("ID"));
				Info.setName(ResultSet.getString("name"));
				Info.setLeader(ResultSet.getString("leader"));
				Info.setLeaderName(ResultSet.getString("leaderName"));
				Info.setCreateTime(ResultSet.getString("createTime"));
				Info.setIsTrue(ResultSet.getString("isTrue"));
				Info.setIsAdmin(ResultSet.getString("isAdministrative"));
				infos.add(Info);
			}
			close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return infos;
	}
	
}
