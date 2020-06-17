package BLL;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;

import DAO.AuditDal;
import Model.AuditOpinionInfo;
import Model.project;
import UI.software;

public class AuditServer {

	private AuditDal dal = new AuditDal();


    public boolean Update(AuditOpinionInfo info)
    {
        return dal.Update(info);
    }
    
    
    /**
     * 1、Update(AuditOpinionInfo info)
     */
    public String switchOperation(project project) {
    	String result = null;
    	switch (project.getType()) {
		case "1":
			software.ta.append("执行修改审核意见操作     时间："+software.dFormat.format(new Date())+ '\n');
			result = toJSONString(Update(JSONStringToObject(project.getField()).get(0)));
			break;
		}
    	return result;
    }
    
    
    
    
    
    /**
     * 将JSON字符串转换成数据集合
     * @param JSONString	JSON字符串
     * @return	数据集合
     * objData.getString("")
     */
    public List<AuditOpinionInfo> JSONStringToObject(String JSONString){
    	List<AuditOpinionInfo> datas = new ArrayList<AuditOpinionInfo>();
    	try {
			JSONArray array = JSON.parseArray(JSONString);
			for (int i = 0; i < array.size(); i++) {
				JSONObject objData = array.getJSONObject(i);
				AuditOpinionInfo data = new AuditOpinionInfo();
				data.setAuditor(objData.getString("Auditor"));
				data.setCreateTime(objData.getString("CreateTime"));
				data.setId(objData.getString("Id"));
				data.setIsPass(objData.getString("IsPass"));
				data.setOpinion(objData.getString("Opinion"));
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
    public String toJSONString(List<AuditOpinionInfo> data) {
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
