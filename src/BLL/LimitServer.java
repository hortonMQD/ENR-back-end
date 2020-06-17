package BLL;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;

import DAO.LimitDal;
import Model.LimitInfo;
import Model.project;
import UI.software;

public class LimitServer {

	private LimitDal dal = new LimitDal();


    /**
     * 1��SelectWithParameter(LimitInfo info)
     * 2��SelectNoParameter()
     */
    public String switchOperation(project project) {
    	String result = null;
    	switch (project.getType()) {
		case "1":
			software.ta.append("ִ�и��ݲ�����ѯȨ�����ݲ���     ʱ�䣺"+software.dFormat.format(new Date())+ '\n');
			result = toJSONString(SelectWithParameter(JSONStringToObject(project.getField()).get(0)));
			break;
		case "2":
			software.ta.append("ִ���޲β�ѯȨ�����ݲ���     ʱ�䣺"+software.dFormat.format(new Date())+ '\n');
			result = toJSONString(SelectNoParameter());
			break;
		}
    	return result;
    }
    
    
    public List<LimitInfo> SelectWithParameter(LimitInfo info)
    {
        return dal.SelectWithParameter(info);
    }

    public List<LimitInfo> SelectNoParameter()
    {
        return dal.SelectNoParameter();
    }
    
    
    
    

    /**
     * ��JSON�ַ���ת�������ݼ���
     * @param JSONString	JSON�ַ���
     * @return	���ݼ���
     * objData.getString("")
     */
    public List<LimitInfo> JSONStringToObject(String JSONString){
    	List<LimitInfo> datas = new ArrayList<LimitInfo>();
    	try {
			JSONArray array = JSON.parseArray(JSONString);
			for (int i = 0; i < array.size(); i++) {
				JSONObject objData = array.getJSONObject(i);
				LimitInfo data = new LimitInfo();
				data.setId(objData.getString("id"));
				data.setName(objData.getString("name"));
				data.setOperation(objData.getString("operation"));
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
    public String toJSONString(List<LimitInfo> data) {
    	return JSON.toJSONString(data);
    }
    
    
    /**
	 * ����ɾ�ĵĲ������ת����json�ַ���
	 * @param result  ��ɾ�Ľ��
	 * @return	json�ַ���
	 */
    public String toJSONString(Boolean result) {
    	return JSON.toJSONString(result);
    }
	
}
