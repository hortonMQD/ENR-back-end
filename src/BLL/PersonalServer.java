package BLL;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;

import DAO.PersonalDal;
import Model.PersonalInfo;
import Model.project;
import UI.software;

public class PersonalServer {

	private PersonalDal dal = new PersonalDal();
	
	/**
	 * 1、login(PersonalInfo info)
	 * 2、Insert(PersonalInfo info)
	 * 3、SelectWithParameter(PersonalInfo info)
	 * 4、SelectPersonalNoParameter()
	 * 5、Update(PersonalInfo info)
	 */
	public String switchOperation(project project) {
		String result = null;
    	switch (project.getType()) {
		case "1":
			software.ta.append("执行管理员登录操作     时间："+software.dFormat.format(new Date())+ '\n');
			result = toJSONString(login(JSONStringToObject(project.getField()).get(0)));
			break;
		case "2":
			software.ta.append("执行添加管理员操作     时间："+software.dFormat.format(new Date())+ '\n');
			result = toJSONString(Insert(JSONStringToObject(project.getField()).get(0)));
			break;
		case "3":
			software.ta.append("执行根据参数查询管理员数据操作     时间："+software.dFormat.format(new Date())+ '\n');
			result = toJSONString(SelectWithParameter(JSONStringToObject(project.getField()).get(0)));
			break;
		case "4":
			software.ta.append("执行无参查询管理员数据操作     时间："+software.dFormat.format(new Date())+ '\n');
			result = toJSONString(SelectPersonalNoParameter());
			break;
		case "5":
			software.ta.append("执行修改管理员数据操作     时间："+software.dFormat.format(new Date())+ '\n');
			result = toJSONString(Update(JSONStringToObject(project.getField()).get(0)));
			break;
		}
    	return result;
    }
	
	
	public boolean login(PersonalInfo info){
        return isTrue(dal.SelectPersonalWithParameter(info).size());
    }

    public boolean Insert(PersonalInfo info){
        return dal.Insert(info);
    }

    public List<PersonalInfo> SelectWithParameter(PersonalInfo info){
        return dal.SelectPersonalWithParameter(info);
    }

    public List<PersonalInfo> SelectPersonalNoParameter(){
        return dal.SelectPersonalNoParameter();
    }

    public boolean Update(PersonalInfo info){
        return dal.Update(info);
    }
    
    
    
    
    
    /**
     * 将JSON字符串转换成数据集合
     * @param JSONString	JSON字符串
     * @return	数据集合
     */
    public List<PersonalInfo> JSONStringToObject(String JSONString){
    	List<PersonalInfo> datas = new ArrayList<PersonalInfo>();
    	try {
			JSONArray array = JSON.parseArray(JSONString);
			for (int i = 0; i < array.size(); i++) {
				JSONObject objData = array.getJSONObject(i);
				PersonalInfo data = new PersonalInfo();
				data.setCreateTime(objData.getString("CreateTime"));
				data.setDepartment(objData.getString("Department"));
				data.setDepartmentName(objData.getString("DepartmentName"));
				data.setDimissionTime(objData.getString("DimissionTime"));
				data.setId(objData.getString("Id"));
				data.setIsDimission(objData.getString("IsDimission"));
				data.setLimit(objData.getString("Limit"));
				data.setLimitName(objData.getString("LimitName"));
				data.setName(objData.getString("Name"));
				data.setOldPwd(objData.getString("OldPwd"));
				data.setpId(objData.getString("PId"));
				data.setPwd(objData.getString("Pwd"));
				data.setTelephone(objData.getString("Telephone"));
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
    public String toJSONString(List<PersonalInfo> data) {
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
    
    
    
    
    public boolean isTrue(int result){
        if (result > 0)
        {
            return true;
        }
        return false;
    }
}
