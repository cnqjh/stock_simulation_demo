package org.simulation.operation.domain;

import java.util.Date;

public class User {

	private String loginName;//登录名
	private String loginPassword;//登录密码
	private String userName;//用户名
	
	private String userGrade;//年级
	private String userClass;//班级
	private String userMajor;//专业
	
	private String userCall;//联系电话
	private String userCode;//学号
	private String batch;//批次
	private Date createDate;//创建时间
	private Integer login_status;//登录状态
	private String id;//时间+批次+学号
	
	public User() {
		super();
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getLoginPassword() {
		return loginPassword;
	}

	public void setLoginPassword(String loginPassword) {
		this.loginPassword = loginPassword;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserGrade() {
		return userGrade;
	}

	public void setUserGrade(String userGrade) {
		this.userGrade = userGrade;
	}

	public String getUserClass() {
		return userClass;
	}

	public void setUserClass(String userClass) {
		this.userClass = userClass;
	}

	public String getUserMajor() {
		return userMajor;
	}

	public void setUserMajor(String userMajor) {
		this.userMajor = userMajor;
	}

	public String getUserCall() {
		return userCall;
	}

	public void setUserCall(String userCall) {
		this.userCall = userCall;
	}

	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	public String getBatch() {
		return batch;
	}

	public void setBatch(String batch) {
		this.batch = batch;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Integer getLogin_status() {
		return login_status;
	}

	public void setLogin_status(Integer login_status) {
		this.login_status = login_status;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
}
