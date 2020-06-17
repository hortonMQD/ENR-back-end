package Model;

import java.io.Serializable;

public class project implements Serializable{
	

	private String type;			//增删查改、登陆等操作类型
	private String search_type;	//搜索类型
	private String field;		//增删查改字符串
	private static final long serialVersionUID = 4713717217654285562L;

	

	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getSearch_type() {
		return search_type;
	}
	public void setSearch_type(String search_type) {
		this.search_type = search_type;
	}
	public String getField() {
		return field;
	}
	public void setField(String field) {
		this.field = field;
	}

}
