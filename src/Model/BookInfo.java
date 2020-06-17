package Model;

public class BookInfo {
	
	private String id;
	private String oldID;
    private String imageUrl;
    private String imageName;
    private String name;
    private String author;
    private String text;
    private String serialState;
    private String bookTypeID;
    private String bookTypeName;
    private String bookTypeIsTrue;
    private String fileUrl;
    private String fileSize;
    private String fileName;
    private String uploadUserID;
    private String uploadUserText;
    private String uploadTime;
    private String downloadCount;
    private String isTrue;
    private String isDelete;
    private String auditOpinion;
    private String isPass;
    private String Opinion;
    private String PersonalID;
    private String PersonalName;
    private String PersonalEmail;
    
    
    public BookInfo() {
    	id = IDUtils.getID();
    }
    
    public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getOldID() {
		return oldID;
	}
	public void setOldID(String oldID) {
		this.oldID = oldID;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public String getImageName() {
		return imageName;
	}
	public void setImageName(String imageName) {
		this.imageName = imageName;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getSerialState() {
		return serialState;
	}
	public void setSerialState(String serialState) {
		this.serialState = serialState;
	}
	public String getBookTypeID() {
		return bookTypeID;
	}
	public void setBookTypeID(String bookTypeID) {
		this.bookTypeID = bookTypeID;
	}
	public String getBookTypeName() {
		return bookTypeName;
	}
	public void setBookTypeName(String bookTypeName) {
		this.bookTypeName = bookTypeName;
	}
	public String getBookTypeIsTrue() {
		return bookTypeIsTrue;
	}
	public void setBookTypeIsTrue(String bookTypeIsTrue) {
		this.bookTypeIsTrue = bookTypeIsTrue;
	}
	public String getFileUrl() {
		return fileUrl;
	}
	public void setFileUrl(String fileUrl) {
		this.fileUrl = fileUrl;
	}
	public String getFileSize() {
		return fileSize;
	}
	public void setFileSize(String fileSize) {
		this.fileSize = fileSize;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getUploadUserID() {
		return uploadUserID;
	}
	public void setUploadUserID(String uploadUserID) {
		this.uploadUserID = uploadUserID;
	}
	public String getUploadUserText() {
		return uploadUserText;
	}
	public void setUploadUserText(String uploadUserText) {
		this.uploadUserText = uploadUserText;
	}
	public String getUploadTime() {
		return uploadTime;
	}
	public void setUploadTime(String uploadTime) {
		this.uploadTime = uploadTime;
	}
	public String getDownloadCount() {
		return downloadCount;
	}
	public void setDownloadCount(String downloadCount) {
		this.downloadCount = downloadCount;
	}
	public String getIsTrue() {
		return isTrue;
	}
	public void setIsTrue(String isTrue) {
		this.isTrue = isTrue;
	}
	public String getIsDelete() {
		return isDelete;
	}
	public void setIsDelete(String isDelete) {
		this.isDelete = isDelete;
	}
	public String getAuditOpinion() {
		return auditOpinion;
	}
	public void setAuditOpinion(String auditOpinion) {
		this.auditOpinion = auditOpinion;
	}
	public String getIsPass() {
		return isPass;
	}
	public void setIsPass(String isPass) {
		this.isPass = isPass;
	}
	public String getOpinion() {
		return Opinion;
	}
	public void setOpinion(String opinion) {
		Opinion = opinion;
	}
	public String getPersonalID() {
		return PersonalID;
	}
	public void setPersonalID(String personalID) {
		PersonalID = personalID;
	}
	public String getPersonalName() {
		return PersonalName;
	}
	public void setPersonalName(String personalName) {
		PersonalName = personalName;
	}
	public String getPersonalEmail() {
		return PersonalEmail;
	}
	public void setPersonalEmail(String personalEmail) {
		PersonalEmail = personalEmail;
	}

}
