package com.eale.hrsm.bean;


import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.util.Date;


/**
 * 用户表
 */
@Entity
@Table(name="car_rental_user")
public class User {
	
	@Id
	@Column(name="user_id")
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long userId;		//用户id
	
	@Column(name="user_name")
	private String userName;	//登录用户名
	
	@Column(name="user_tel")
	private String userTel;		//用户电话
	
	@Column(name="real_name")
	private String realName;    //真实姓名
	

	@Pattern(regexp="^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+((\\.[a-zA-Z0-9_-]{2,3}){1,2})$",message="请填写正确邮箱号")
	private String eamil;		//邮件
	
	private String address;		//地址

	
	private Boolean superman=false;

	
	@Column(name="user_idcard")
//	@Pattern(regexp="^(\\d{6})(19|20)(\\d{2})(1[0-2]|0[1-9])(0[1-9]|[1-2][0-9]|3[0-1])(\\d{3})(\\d|X|x)?$",message="请填写正确身份证号")
	private String idCard;		//用户身份证
	
//	@Length(min=16, max=19,message="银行卡号长度必须在16到19之间!")
	private String bank;		//银行
	
	private String sex;			//性别
	
	@Column(name="theme_skin")
	private String themeSkin;	//主题皮肤
	
	private Date birth;			//生日

	
	private String password;	//用户密码
	
	private String salary;		//用户薪水
	
	@Column(name="img_path")
	private String imgPath;		//用户头像路径
	
	@Column(name="hire_time")
	private Date hireTime;		//入职时间
	
	@Column(name="is_lock")
	private Integer isLock=0;		//该用户是否被禁用

	
	@Column(name="modify_time")
	private Date modifyTime;		//最后修改时间
	
	@Column(name="modify_user_id")
	private Long modifyUserId;	//最后修改此用户的用户id
	
	@Column(name="father_id")
	private Long fatherId;		//上司id

	
	@ManyToOne()
	@JoinColumn(name = "role_id")
	private Role role;			//外键关联 角色表


	public User() {}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserTel() {
		return userTel;
	}

	public void setUserTel(String userTel) {
		this.userTel = userTel;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getEamil() {
		return eamil;
	}

	public void setEamil(String eamil) {
		this.eamil = eamil;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Boolean getSuperman() {
		return superman;
	}

	public void setSuperman(Boolean superman) {
		this.superman = superman;
	}

	public String getIdCard() {
		return idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	public String getBank() {
		return bank;
	}

	public void setBank(String bank) {
		this.bank = bank;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getThemeSkin() {
		return themeSkin;
	}

	public void setThemeSkin(String themeSkin) {
		this.themeSkin = themeSkin;
	}

	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSalary() {
		return salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}

	public String getImgPath() {
		return imgPath;
	}

	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}

	public Date getHireTime() {
		return hireTime;
	}

	public void setHireTime(Date hireTime) {
		this.hireTime = hireTime;
	}

	public Integer getIsLock() {
		return isLock;
	}

	public void setIsLock(Integer isLock) {
		this.isLock = isLock;
	}

	public Date getModifyTime() {
		return modifyTime;
	}

	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}

	public Long getModifyUserId() {
		return modifyUserId;
	}

	public void setModifyUserId(Long modifyUserId) {
		this.modifyUserId = modifyUserId;
	}

	public Long getFatherId() {
		return fatherId;
	}

	public void setFatherId(Long fatherId) {
		this.fatherId = fatherId;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "User{" +
				"userId=" + userId +
				", userName='" + userName + '\'' +
				", userTel='" + userTel + '\'' +
				", realName='" + realName + '\'' +
				", eamil='" + eamil + '\'' +
				", address='" + address + '\'' +
				", superman=" + superman +
				", idCard='" + idCard + '\'' +
				", bank='" + bank + '\'' +
				", sex='" + sex + '\'' +
				", themeSkin='" + themeSkin + '\'' +
				", birth=" + birth +
				", password='" + password + '\'' +
				", salary='" + salary + '\'' +
				", imgPath='" + imgPath + '\'' +
				", hireTime=" + hireTime +
				", isLock=" + isLock +
				", modifyTime=" + modifyTime +
				", modifyUserId=" + modifyUserId +
				", fatherId=" + fatherId +
				", role=" + role +
				'}';
	}
}
