package com.eale.hrsm.bean;

import javax.persistence.*;
import java.util.Date;

/**
 * @description  街道实体
 * @author: Eale
 * @date:2019/4/28/028-14:20
 */
@Entity
@Table(name = "district")
public class District {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="district_id")
    private Long districtId;

    @Column(name = "dis_name")
    private String disName;//街区名

    @ManyToOne()
    @JoinColumn(name = "region_id")
    private Region region;//区

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

    public District() {
    }

    public Long getDistrictId() {
        return districtId;
    }

    public void setDistrictId(Long districtId) {
        this.districtId = districtId;
    }

    public String getDisName() {
        return disName;
    }

    public void setDisName(String disName) {
        this.disName = disName;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
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
