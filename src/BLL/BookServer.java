package BLL;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;

import DAO.BookDal;
import Model.BookInfo;
import Model.project;
import UI.software;

public class BookServer {

	private BookDal dal = new BookDal();


    
    
    
    /**
     * 1��Insert(BookInfo info)
     * 2��Updata(BookInfo info)
     * 3��Delete(BookInfo info)
     * 4��UpdataDownload(BookInfo info)
     * 5��SelectBookWithParameter(BookInfo info)
     * 6��SelectNewBookWithParameter(BookInfo info)
     * 7��SelectFireBookWithParameter(BookInfo info)
     */
    public String switchOperation(project project) {
    	String result = null;
    	switch (project.getType()) {
		case "1":
			software.ta.append("ִ�в����鼮����     ʱ�䣺"+software.dFormat.format(new Date())+ '\n');
			result = toJSONString(Insert(JSONStringToObject(project.getField()).get(0)));
			break;
		case "2":
			software.ta.append("ִ���޸��鼮����     ʱ�䣺"+software.dFormat.format(new Date())+ '\n');
			result = toJSONString(Updata(JSONStringToObject(project.getField()).get(0)));
			break;
		case "3":
			software.ta.append("ִ��ɾ���鼮����     ʱ�䣺"+software.dFormat.format(new Date())+ '\n');
			result = toJSONString(Delete(JSONStringToObject(project.getField()).get(0)));
			break;
		case "4":
			software.ta.append("ִ���޸��鼮���ش�������     ʱ�䣺"+software.dFormat.format(new Date())+ '\n');
			result = toJSONString(UpdataDownload(JSONStringToObject(project.getField()).get(0)));
			break;
		case "5":
			software.ta.append("ִ�и��ݲ�����ѯ�鼮����     ʱ�䣺"+software.dFormat.format(new Date())+ '\n');
			result = toJSONString(SelectBookWithParameter(JSONStringToObject(project.getField()).get(0)));
			break;
		case "6":
			software.ta.append("ִ�и��ݲ������ϴ�ʱ�併���ѯ�鼮����     ʱ�䣺"+software.dFormat.format(new Date())+ '\n');
			result = toJSONString(SelectNewBookWithParameter(JSONStringToObject(project.getField()).get(0)));
			break;
		case "7":
			software.ta.append("ִ�и��ݲ��������ش��������ѯ�鼮����     ʱ�䣺"+software.dFormat.format(new Date())+ '\n');
			result = toJSONString(SelectFireBookWithParameter(JSONStringToObject(project.getField()).get(0)));
			break;
		}
    	
    	return result;
    }
    
    
    
    
    public boolean Insert(BookInfo info)
    {
    	return dal.Insert(info);
    }


    public boolean Updata(BookInfo info)
    {
    	return dal.Update(info);
    }

    public boolean Delete(BookInfo info)
    {
        return dal.Delete(info.getId());
    }


    public boolean UpdataDownload(BookInfo info)
    {
        return dal.UpdataDownloadBookWithParameter(info);
    }


    public List<BookInfo> SelectBookWithParameter(BookInfo info)
    {
        return dal.SelectBookWithParameter(info);
    }
    

    public List<BookInfo> SelectNewBookWithParameter(BookInfo info)
    {
        return dal.SelectBookWithParameter(info);
    }

    public List<BookInfo> SelectFireBookWithParameter(BookInfo info)
    {
        return dal.SelectFireBookWithParameter(info);
    }

    
    
    /**
     * ��JSON�ַ���ת�������ݼ���
     * @param JSONString	JSON�ַ���
     * @return	���ݼ���
     */
    public List<BookInfo> JSONStringToObject(String JSONString){
    	
    	List<BookInfo> datas = new ArrayList<BookInfo>();
    	try {
			JSONArray array = JSON.parseArray(JSONString);
			for (int i = 0; i < array.size(); i++) {
				JSONObject objData = array.getJSONObject(i);
				BookInfo data = new BookInfo();
				data.setAuditOpinion(objData.getString("AuditOpinion"));
				data.setAuthor(objData.getString("Author"));
				data.setBookTypeID(objData.getString("BookTypeID"));
				data.setBookTypeIsTrue(objData.getString("BookTypeIsTrue"));
				data.setBookTypeName(objData.getString("BookTypeName"));
				data.setDownloadCount(objData.getString("DownloadCount"));
				data.setFileName(objData.getString("FileName"));
				data.setFileSize(objData.getString("FileSize"));
				data.setFileUrl(objData.getString("FileUrl"));
				data.setId(objData.getString("Id"));
				data.setImageName(objData.getString("ImageName"));
				data.setImageUrl(objData.getString("ImageUrl"));
				data.setIsDelete(objData.getString("IsDelete"));
				data.setIsPass(objData.getString("IsPass"));
				data.setIsTrue(objData.getString("IsTrue"));
				data.setName(objData.getString("Name"));
				data.setOldID(objData.getString("OldID"));
				data.setOpinion(objData.getString("Opinion"));
				data.setPersonalEmail(objData.getString("PersonalEmail"));
				data.setPersonalID(objData.getString("PersonalID"));
				data.setPersonalName(objData.getString("PersonalName"));
				data.setSerialState(objData.getString("SerialState"));
				data.setText(objData.getString("Text"));
				data.setUploadTime(objData.getString("UploadTime"));
				data.setUploadUserID(objData.getString("UploadUserID"));
				data.setUploadUserText(objData.getString("UploadUserText"));
				datas.add(data);
			}
		} catch (JSONException e) {
			e.printStackTrace();
		}
    	return datas;
    }
    
    
    
    /**
	 * �����ݼ��ϵ�����ת����json�ַ���
	 * @param users	�û�����
	 * @return	json�ַ���
	 */
    public String toJSONString(List<BookInfo> data) {
    	String result = JSON.toJSONString(data);
    	return result;
    }
    
    
    /**
	 * ����ɾ�ĵĲ������ת����json�ַ���
	 * @param result  ��ɾ�Ľ��
	 * @return	json�ַ���
	 */
    public String toJSONString(Boolean result) {
    	return JSON.toJSONString(result);
    }
    
    
    public boolean isTrue(int result){
        if (result > 0)
        {
            return true;
        }
        return false;
    }
}
