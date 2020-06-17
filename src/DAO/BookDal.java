package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import Model.BookInfo;

public class BookDal extends DBTool{
	
    
    private String SQL = "";
    private static List<String> SelectMessage = new ArrayList<String>();
    
    
    /**
	 * �޸��鼮��Ϣ
	 * @param book	�鼮��Ϣ
	 * @return	���ɹ�����true
	 */
	public Boolean Update(BookInfo book) {
		Boolean result = false;
		String sql01 = "UPDATE Book set isDelete = 1 where ID = ?";
		String[] messages01 = {book.getOldID()};
		String sql02 = "insert AuditOpinion(ID,isPass,opinion,createTime) values (?,'δ���','δ���',now())";
		String[] messages02 = {book.getId()};
		String sql03 = "insert Book(ID,imageName,imageUrl,name,author,text,serialState,bookType,fileName,fileUrl,fileSize,uploadUser,uploadTime,clickCount,isTrue,isDelete,auditOpinion) " +
	            "values(?,?,?,?,?,?,?,?,?,?,?,?,now(),'0','0','0',?)";
		String[] messages03 = {book.getId(),book.getImageName(),book.getImageUrl(),book.getName(),book.getAuthor(),book.getText(),book.getSerialState(),book.getBookTypeID(),book.getFileName(),
				book.getFileUrl(),book.getFileSize(),book.getUploadUserID(),book.getAuditOpinion()};
		PreparedStatement[] SQL = {SetSQLString(sql01, messages01),SetSQLString(sql02, messages02),SetSQLString(sql03, messages03)};
		result = InsertUpdateDelete(SQL);
		return result;
	}
	
	
	/**
	 * ɾ���鼮��Ϣ
	 * @param ID	�鼮ID
	 * @return	���ɹ�����0��ɾ���ɹ�
	 */
	public Boolean Delete(String ID) {
		Boolean result = false;
		String sql = "update Book set isDelete = 1 where ID = ?;";
		String[] messages = {ID};
		PreparedStatement[] SQL = {SetSQLString(sql, messages)};
		result = InsertUpdateDelete(SQL);
		return result;
	}
	
	
	/**
	 * ����鼮��Ϣ
	 * @param book	�鼮��Ϣ
	 * @return	���ɹ�����true
	 */
	public Boolean Insert(BookInfo book) {
		Boolean result = false;
		String sql01 = "insert AuditOpinion(ID,isPass,opinion,createTime) values (?,'δ���','δ���',now())";
		String[] messages01 = {book.getId()};
		String sql02 = "insert Book(ID,imageName,imageUrl,name,author,text,serialState,bookType,fileName,fileUrl,fileSize,uploadUser,uploadTime,clickCount,isTrue,isDelete,auditOpinion) " +
	            "values(?,?,?,?,?,?,?,?,?,?,?,?,now(),'0','0','0',?)";
		String[] messages02 = {book.getId(),book.getImageName(),book.getImageUrl(),book.getName(),book.getAuthor(),book.getText(),book.getSerialState(),book.getBookTypeID(),book.getFileName(),
				book.getFileUrl(),book.getFileSize(),book.getUploadUserID(),book.getAuditOpinion()};
		PreparedStatement[] SQL = {SetSQLString(sql01, messages01),SetSQLString(sql02, messages02)};
		result = InsertUpdateDelete(SQL);
		return  result;
	}
	
	
	/**
	 * �޸ĵ��������ش���
	 * @param book
	 * @return	���ɹ�����true
	 */
	public Boolean UpdataDownloadBookWithParameter(BookInfo book) {
		Boolean result = false;
		String sql = "update Book set clickCount = clickCount+1 where ID = ?";
		String[] messages = {book.getId()};
		PreparedStatement[] SQL = {SetSQLString(sql, messages)};
		result = InsertUpdateDelete(SQL);
		return result;
	}
	
	
	/**
	 *��ѯ�����鼮����
	 * @param info	�鼮����
	 * @return	�鼮���󼯺�
	 */
	public List<BookInfo> SelectBookNoParameter()
    {
        SQL = "SELECT BookID,imgUrl,BookName,author,BookText,BookSerialState,FileUrl,FileSize,UploadTime,ClickCount,IsTrue,IsDelete,auditOpinion,isPass,opinion,createTime," + 
        		"BookType,DeparName,auditor,(SELECT NAME FROM personal WHERE ID = auditor) AS 'PersonalName',UploadUser,UName,UEmail,imgName,FileName FROM bookinformation WHERE 1 = 1";
        SQL += " order by uploadTime desc";
        ResultSet res = SelectNoParameter(SQL);
        return setBookData(res);
    }
	
	
	/**
	 * ���ݴ���Ĳ�����ѯ�鼮����
	 * @param info	�鼮����
	 * @return	�鼮���󼯺�
	 */
	public List<BookInfo> SelectBookWithParameter(BookInfo info)
    {
        SQL = "SELECT BookID,imgUrl,BookName,author,BookText,BookSerialState,FileUrl,FileSize,UploadTime,ClickCount,IsTrue,IsDelete,auditOpinion,isPass,opinion,createTime," + 
        		"BookType,DeparName,auditor,(SELECT NAME FROM personal WHERE ID = auditor) AS 'PersonalName',UploadUser,UName,UEmail,imgName,FileName FROM bookinformation WHERE 1 = 1";
        SQL = setSelectSQL(info, SQL);
        SQL += " order by uploadTime desc";
        String[] array = new String[SelectMessage.size()]; 
        ResultSet res = SelectWithParameter(SQL,SelectMessage.toArray(array));
        SelectMessage.clear();
        return setBookData(res);
    }
	
	
	/**
	 * �����ش����������в��ҵ�����
	 * @return 	�鼮���󼯺�
	 */
	public List<BookInfo> SelectFireBookNoParameter()
    {
        String sql = "SELECT BookID,imgUrl,BookName,author,BookText,BookSerialState,FileUrl,FileSize,UploadTime,ClickCount,IsTrue,IsDelete,auditOpinion,isPass,opinion,createTime," + 
        		"BookType,DeparName,auditor,(SELECT NAME FROM personal WHERE ID = auditor) AS 'PersonalName',UploadUser,UName,UEmail,imgName,FileName FROM bookinformation where IsDelete = '0' order by ClickCount desc";
        ResultSet res = SelectNoParameter(sql);
        return setBookData(res);
    }
	
	/**
	 * ���ݴ���Ĳ��������ش����������в�ѯ�鼮����
	 * @param info	�鼮����
	 * @return	�鼮���󼯺�
	 */
	public List<BookInfo> SelectFireBookWithParameter(BookInfo info)
    {
		SQL = "SELECT BookID,imgUrl,BookName,author,BookText,BookSerialState,FileUrl,FileSize,UploadTime,ClickCount,IsTrue,IsDelete,auditOpinion,isPass,opinion,createTime," + 
        		"BookType,DeparName,auditor,(SELECT NAME FROM personal WHERE ID = auditor) AS 'PersonalName',UploadUser,UName,UEmail,imgName,FileName FROM bookinformation where 1=1 ";
        SQL = setSelectSQL(info, SQL);
        SQL +=  "  order by ClickCount desc";
        String[] array = new String[SelectMessage.size()]; 
        ResultSet res = SelectWithParameter(SQL,SelectMessage.toArray(array));
        SelectMessage.clear();
        return setBookData(res);
    }
	
	
	/**
	 * �����ݼ����е���Ϣ��ӵ��鼮���󼯺���
	 * @param ResultSet		�鼮���ݼ���
	 * @return	�鼮���󼯺�
	 */
	public List<BookInfo> setBookData(ResultSet ResultSet) {
		List<BookInfo> books = new ArrayList<>();
		try {
			while(ResultSet.next()){
				BookInfo bookInfo = new BookInfo();
				bookInfo.setId(ResultSet.getString("BookID"));
				bookInfo.setImageUrl(ResultSet.getString("imgUrl"));
				bookInfo.setName(ResultSet.getString("BookName"));
				bookInfo.setAuthor(ResultSet.getString("author"));
				bookInfo.setText(ResultSet.getString("BookText"));
				bookInfo.setSerialState(ResultSet.getString("BookSerialState"));
				bookInfo.setFileUrl(ResultSet.getString("FileUrl"));
				bookInfo.setFileSize(ResultSet.getString("FileSize"));
				bookInfo.setUploadTime(ResultSet.getString("UploadTime"));
				bookInfo.setDownloadCount(ResultSet.getString("ClickCount"));
				bookInfo.setIsTrue(ResultSet.getString("IsTrue"));
				bookInfo.setIsDelete(ResultSet.getString("IsDelete"));
				bookInfo.setAuditOpinion(ResultSet.getString("auditOpinion"));
				bookInfo.setIsPass(ResultSet.getString("isPass"));
				bookInfo.setOpinion(ResultSet.getString("opinion"));
				bookInfo.setUploadTime(ResultSet.getString("createTime"));
				bookInfo.setBookTypeID(ResultSet.getString("BookType"));
				bookInfo.setBookTypeName(ResultSet.getString("DeparName"));
				bookInfo.setPersonalID(ResultSet.getString("auditor"));
				bookInfo.setPersonalName(ResultSet.getString("PersonalName"));
				bookInfo.setUploadUserID(ResultSet.getString("UploadUser"));
				bookInfo.setUploadUserText(ResultSet.getString("UName"));
				bookInfo.setImageName(ResultSet.getString("imgName"));
				bookInfo.setFileName(ResultSet.getString("FileName"));
				if (!ResultSet.getString("isPass").equals("δ���"))
	            {
	                bookInfo.setPersonalID(ResultSet.getString("auditor"));
	                bookInfo.setPersonalName(ResultSet.getString("PersonalName"));
	            }
				books.add(bookInfo);
			}
			close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return books;
	}
	
	
	
	/**
	 * ���ò�ѯ���
	 * @param info  �鼮����
	 * @param sql	��ѯ���
	 */
	public static String setSelectSQL(BookInfo info,String sql)
    {
        if (info.getName() != null) { sql += " and BookName like ? "; SelectMessage.add("%"+info.getName()+"%"); }
        if (info.getAuthor() != null) { sql += " and author = ? "; SelectMessage.add(info.getAuthor());}
        if (info.getSerialState() != null) { sql += " and BookSerialState = ?";  SelectMessage.add(info.getSerialState());}
        if (info.getBookTypeID() != null) { sql += " and BookType = ?"; SelectMessage.add(info.getBookTypeID());  }
        if (info.getBookTypeName() != null) { sql += " and DeparName = ?"; SelectMessage.add(info.getBookTypeName());  }
        if (info.getPersonalID() != null) { sql += " and auditor = ?"; SelectMessage.add(info.getPersonalID()); }
        if (info.getUploadUserID() != null) { sql += " and UploadUser = ?"; SelectMessage.add(info.getUploadUserID()); }
        if (info.getUploadUserText() != null) { sql += " and UName = ?"; SelectMessage.add(info.getUploadUserText()); }
        if (info.getIsPass() != null) { sql += " and isPass = ?"; SelectMessage.add(info.getIsPass()); }
        if (info.getIsTrue() != null) { sql += " and IsTrue = ?"; SelectMessage.add(info.getIsTrue()); }
        if (info.getIsDelete() != null) { sql += " and IsDelete = ?"; SelectMessage.add(info.getIsDelete());}
        if (info.getId() != null) { sql += " and BookID = ?";  SelectMessage.add(info.getId());  }
        return sql;
    }
	
	
	
	
}
