package org.simulation.operation.domain;

import java.io.Serializable;
import java.util.Date;

//violations_inf:违规记录
public class ViolationeCord implements Serializable{

	private String id;
	private Date violationDate;//违规时间
	private Date pointsDate;//扣分时间
	private String violationCause;//违规原因
	private String violationPoints;//违规扣分
	private String loginStatus;//登录状态
	private User user;
	public ViolationeCord() {
		super();
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Date getViolationDate() {
		return violationDate;
	}
	public void setViolationDate(Date violationDate) {
		this.violationDate = violationDate;
	}
	public Date getPointsDate() {
		return pointsDate;
	}
	public void setPointsDate(Date pointsDate) {
		this.pointsDate = pointsDate;
	}
	public String getViolationCause() {
		return violationCause;
	}
	public void setViolationCause(String violationCause) {
		this.violationCause = violationCause;
	}
	public String getViolationPoints() {
		return violationPoints;
	}
	public void setViolationPoints(String violationPoints) {
		this.violationPoints = violationPoints;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	@Override
	public String toString() {
		return "TotalRanking [id=" + id + ", violationDate=" + violationDate + ", pointsDate=" + pointsDate
				+ ", violationCause=" + violationCause +
				", user=" + user +
				", violationPoints=" + violationPoints +"]";
	}
	public String getLoginStatus() {
		return loginStatus;
	}
	public void setLoginStatus(String loginStatus) {
		this.loginStatus = loginStatus;
	}
}
