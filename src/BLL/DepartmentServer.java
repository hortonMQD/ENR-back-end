package BLL;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;

import DAO.DepartmentDal;
import Model.DepartmentInfo;
import Model.project;
import UI.software;

public class DepartmentServer {


    private DepartmentDal dal = new DepartmentDal();


    /**
     * 1、Insert(DepartmentInfo info)
     * 2、Update(DepartmentInfo info)
     * 3、SelectDepartmentWithParameter(DepartmentInfo info)
     * 4、SelectDepartmentNoParameter()
     */
    public String switchOperation(project project) {
    	String result = null;
    	switch (project.getType()) {
		case "1":
			software.ta.append("执行插入部门数据操作     时间："+software.dFormat.format(new Date())+ '\n');
			result = toJSONString(Insert(JSONStringToObject(project.getField()).get(0)));
			break;
		case "2":
			software.ta.append("执行修改部门数据操作     时间："+software.dFormat.format(new Date())+ '\n');
			result = toJSONString(Update(JSONStringToObject(project.getField()).get(0)));
			break;
		case "3":
			software.ta.append("执行根据参数查询部门数据操作     时间："+software.dFormat.format(new Date())+ '\n');
			result = toJSONString(SelectDepartmentWithParameter(JSONStringToObject(project.getField()).get(0)));
			break;
		case "4":
			software.ta.append("执行无参查询部门数据操作     时间："+software.dFormat.format(new Date())+ '\n');
			result = toJSONString(SelectDepartmentNoParameter());
			break;
		}
    	return result;
    }
    
    
    public boolean Insert(DepartmentInfo info)
    {
        return dal.Insert(info);
    }

    public boolean Update(DepartmentInfo info)
    {
        return dal.Update(info);
    }


    public List<DepartmentInfo> SelectDepartmentWithParameter(DepartmentInfo info)
    {
        return dal.SelectDepartmentWithParameter(info);
    }

    public List<DepartmentInfo> SelectDepartmentNoParameter()
    {
        return dal.SelectDepartmenNoParameter();
    }


    
    
    /**
     * 将JSON字符串转换成数据集合
     * @param JSONString	JSON字符串
     * @return	数据集合
     */
    public List<DepartmentInfo> JSONStringToObject(String JSONString){
    	List<DepartmentInfo> datas = new ArrayList<DepartmentInfo>();
    	try {
			JSONArray array = JSON.parseArray(JSONString);
			for (int i = 0; i < array.size(); i++) {
				JSONObject objData = array.getJSONObject(i);
				DepartmentInfo data = new DepartmentInfo();
				data.setId(objData.getString("Id"));
				data.setIsAdmin(objData.getString("IsAdmin"));
				data.setIsTrue(objData.getString("IsTrue"));
				data.setLeader(objData.getString("Leader"));
				data.setLeaderName(objData.getString("LeaderName"));
				data.setName(objData.getString("Name"));
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
    public String toJSONString(List<DepartmentInfo> data) {
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
    
    
    
    
    public boolean isTrue(int result)
    {
        if (result > 0)
        {
            return true;
        }
        return false;
    }
	
}
