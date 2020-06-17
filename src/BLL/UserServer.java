package BLL;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;

import DAO.UserDal;
import Model.UserInfo;
import Model.project;
import UI.software;

public class UserServer {


    private UserDal dal = new UserDal();

    
    /**
     * 1、login(UserInfo info)
     * 2、Insert(UserInfo info)
     * 3、SelectWithParamter(UserInfo info)
     * 4、SelectNoParamter()
     * 5、Update(UserInfo info)
     * 6、UpdatePwd(UserInfo info)
     */
    public String switchOperation(project project) {
    	String result = null;
    	switch (project.getType()) {
		case "1":
			software.ta.append("执行普通用户登录操作     时间："+software.dFormat.format(new Date())+ '\n');
			result = toJSONString(login(JSONStringToObject(project.getField()).get(0)));
			break;
		case "2":
			software.ta.append("执行普通用户注册操作     时间："+software.dFormat.format(new Date())+ '\n');
			result = toJSONString(Insert(JSONStringToObject(project.getField()).get(0)));
			break;
		case "3":
			software.ta.append("执行根据参数查询普通用户数据操作     时间："+software.dFormat.format(new Date())+ '\n');
			result = toJSONString(SelectWithParamter(JSONStringToObject(project.getField()).get(0)));
			break;
		case "4":
			software.ta.append("执行无参查询普通用户数据操作     时间："+software.dFormat.format(new Date())+ '\n');
			result = toJSONString(SelectNoParamter());
			break;
		case "5":
			software.ta.append("执行修改普通用户数据操作     时间："+software.dFormat.format(new Date())+ '\n');
			result = toJSONString(Update(JSONStringToObject(project.getField()).get(0)));
			break;
		case "6":
			software.ta.append("执行修改普通用户密码操作     时间："+software.dFormat.format(new Date())+ '\n');
			result = toJSONString(UpdatePwd(JSONStringToObject(project.getField()).get(0)));
			break;
		}
    	return result;
    }
    
    
    
    
    
    
    
    public boolean login(UserInfo info)
    {
    	
        return isTrue(dal.SelectUserWithParameter(info).size());
    }
    
    public boolean Insert(UserInfo info)
    {
        return dal.Insert(info);
    }

    
    public List<UserInfo> SelectWithParamter(UserInfo info)
    {
        return dal.SelectUserWithParameter(info);
    }

    public List<UserInfo> SelectNoParamter()
    {
        return dal.SelectUserNoParameter();
    }

    
    public boolean Update(UserInfo info)
    {
        return dal.Updata(info);
    }


    
    public boolean UpdatePwd(UserInfo info)
    {
        return dal.UpdataPwdWithParameter(info);
    }

    
    

    /**
     * 将JSON字符串转换成数据集合
     * @param JSONString	JSON字符串
     * @return	数据集合
     * objData.getString("")
     */
    public List<UserInfo> JSONStringToObject(String JSONString){
    	List<UserInfo> datas = new ArrayList<UserInfo>();
    	try {
			JSONArray array = JSON.parseArray(JSONString);
			for (int i = 0; i < array.size(); i++) {
				JSONObject objData = array.getJSONObject(i);
				UserInfo data = new UserInfo();
				data.setEmail(objData.getString("Email"));
				data.setId(objData.getString("Id"));
				data.setPwd(objData.getString("Pwd"));
				data.setuName(objData.getString("UName"));
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
    public String toJSONString(List<UserInfo> data) {
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
