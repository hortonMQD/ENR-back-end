package Model;

public class PersonalInfo {
	
	private String id;
    private String pId;
    private String name;
    private String pwd;
    private String oldPwd;
    private String department;
    private String departmentName;
    private String limit;
    private String limitName;
    private String telephone;
    private String createTime;
    private String isDimission;
    private String dimissionTime;
    
    public PersonalInfo() {
    	id = IDUtils.getID();
    }
    
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getpId() {
		return pId;
	}
	public void setpId(String pId) {
		this.pId = pId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getOldPwd() {
		return oldPwd;
	}
	public void setOldPwd(String oldPwd) {
		this.oldPwd = oldPwd;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	public String getLimit() {
		return limit;
	}
	public void setLimit(String limit) {
		this.limit = limit;
	}
	public String getLimitName() {
		return limitName;
	}
	public void setLimitName(String limitName) {
		this.limitName = limitName;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public String getIsDimission() {
		return isDimission;
	}
	public void setIsDimission(String isDimission) {
		this.isDimission = isDimission;
	}
	public String getDimissionTime() {
		return dimissionTime;
	}
	public void setDimissionTime(String dimissionTime) {
		this.dimissionTime = dimissionTime;
	}
    
    


}
