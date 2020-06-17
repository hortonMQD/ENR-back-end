package DAO;

import java.sql.PreparedStatement;

import Model.AuditOpinionInfo;

public class AuditDal extends DBTool{
	

	
	/**
	 * 修改审核信息表
	 * @param info 审核信息对象
	 * @return  若成功返回true
	 */
	public Boolean Update(AuditOpinionInfo info) {
		Boolean result = false;
		String sql01 = "update Book set isTrue = '1' where ID = ?";
		String[] messages01 = {info.getId()};
		String sql02 = "update AuditOpinion set isPass=?,opinion=?,auditor=? where ID = (select auditOpinion from Book where ID = ?)";
		String[] messages02 = {info.getIsPass(),info.getOpinion(),info.getAuditor(),info.getId()};
		PreparedStatement[] SQL = {SetSQLString(sql01, messages01),SetSQLString(sql02, messages02)};
		result = InsertUpdateDelete(SQL);
		return result;
	}

}
