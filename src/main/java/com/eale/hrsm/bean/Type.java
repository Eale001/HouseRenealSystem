package com.eale.hrsm.bean;

import javax.persistence.*;
import java.util.Date;

/**
 * @description  房屋类型实体
 * @author: Eale
 * @date:2019/4/28/028-14:27
 */
@Entity
@Table(name = "type")
public class Type {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="type_id")
    private Long typeId;

    @Column(name = "type_name")
    private String typeName;//类型名字

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

    public Type() {
    }

    public Long getTypeId() {
        return typeId;
    }

    public void setTypeId(Long typeId) {
        this.typeId = typeId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
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
