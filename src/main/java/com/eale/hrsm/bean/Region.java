package com.eale.hrsm.bean;

import javax.persistence.*;
import java.util.Date;

/**
 * @description  地区实体
 * @author: Eale
 * @date:2019/4/28/028-14:25
 */
@Entity
@Table(name = "region")
public class Region {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="region_id")
    private Long regionId;

    @Column(name = "region_name")
    private String regionName;//地区名

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

    public Region() {
    }

    public Long getRegionId() {
        return regionId;
    }

    public void setRegionId(Long regionId) {
        this.regionId = regionId;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
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
