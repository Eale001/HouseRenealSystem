package com.eale.hrsm.bean;

import javax.persistence.*;
import java.util.Date;

/**
 * @description 房屋实体类
 * @author: Eale
 * @date:2019/4/28/028-11:55
 */
@Entity
@Table(name = "house")
public class House {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="pk_id")
    private Long houseId;

    @Column(name = "title")
    private String title;//标题

    @Column(name = "picture")
    private String picture;//图片

    @Column(name = "area")
    private String area;//面积

    @Column(name = "price")
    private Double price;//租金

    @ManyToOne()
    @JoinColumn(name = "district_id")
    private District district;//地区

    @ManyToOne()
    @JoinColumn(name = "type_id")
    private Type type;//房屋类型

    @Column(name = "phone")
    private String phone;//联系电话

    @Column(name = "contacts")
    private String contacts;//联系人

    @Column(name = "discripton")
    private String discription;//描述

    @ManyToOne()
    @JoinColumn(name = "create_user")
    private User createUser;//创建人

    @Column(name = "create_date")
    private Date createDate;

    @ManyToOne()
    @JoinColumn(name = "update_user")
    private User updateUser;

    @Column(name = "update_date")
    private Date updateDate;

    @Column(name = "state")
    private int state;//状态（1.闲置状态 2.出租状态 )

    public House() {
    }

    public Long getHouseId() {
        return houseId;
    }

    public void setHouseId(Long houseId) {
        this.houseId = houseId;
    }

    public String getDiscription() {
        return discription;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public District getDistrict() {
        return district;
    }

    public void setDistrict(District district) {
        this.district = district;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getContacts() {
        return contacts;
    }

    public void setContacts(String contacts) {
        this.contacts = contacts;
    }

    public User getCreateUser() {
        return createUser;
    }

    public void setCreateUser(User createUser) {
        this.createUser = createUser;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public User getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(User updateUser) {
        this.updateUser = updateUser;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }
}
