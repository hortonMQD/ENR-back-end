package Model;

import java.io.Serializable;

public class project implements Serializable{
	

	private String type;			//��ɾ��ġ���½�Ȳ�������
	private String search_type;	//��������
	private String field;		//��ɾ����ַ���
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
