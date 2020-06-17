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
     * 1、SelectWithParameter(LimitInfo info)
     * 2、SelectNoParameter()
     */
    public String switchOperation(project project) {
    	String result = null;
    	switch (project.getType()) {
		case "1":
			software.ta.append("执行根据参数查询权限数据操作     时间："+software.dFormat.format(new Date())+ '\n');
			result = toJSONString(SelectWithParameter(JSONStringToObject(project.getField()).get(0)));
			break;
		case "2":
			software.ta.append("执行无参查询权限数据操作     时间："+software.dFormat.format(new Date())+ '\n');
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
     * 将JSON字符串转换成数据集合
     * @param JSONString	JSON字符串
     * @return	数据集合
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
	 * 将数据集合的数据转换成json字符串
	 * @param users	用户集合
	 * @return	json字符串
	 */
    public String toJSONString(List<LimitInfo> data) {
    	return JSON.toJSONString(data);
    }
    
    
    /**
	 * 将增删改的操作结果转换成json字符串
	 * @param result  增删改结果
	 * @return	json字符串
	 */
    public String toJSONString(Boolean result) {
    	return JSON.toJSONString(result);
    }
	
}
