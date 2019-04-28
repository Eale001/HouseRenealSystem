package com.eale.hrsm.bean;


import javax.persistence.*;
import java.util.Date;

/**
 * @description  合同实体
 * @author: Eale
 * @date:2019/4/28/028-11:55
 */
@Entity
@Table(name = "contract")
public class Contract {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="contract_id")
    private Long contractId;

    @Column(name = "first_party")
    private String firstParty;//甲方 房源拥有者

    @Column(name = "party_b")
    private String partyB;//乙方

    @Column(name = "address")
    private String address;//租赁房屋地址

    @Column(name = "begin_date")
    private Date beginDate;//起租时间

    @Column(name = "end_time")
    private Date endTime;//退组时间

    @Column(name = "deposit")
    private Double deposit;//押金

    @Column(name = "rent")
    private Double rent;//租金

    @Column(name = "money")
    private Double money;//已经交了多少钱

    @Column(name = "remark")
    private String remark;//备注

    @OneToOne
    @JoinColumn(name = "order_id")
    private Order order;//订单

    @OneToOne
    @JoinColumn(name = "house")
    private House house;//出租房源

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

    public Contract() {
    }

    public Long getContractId() {
        return contractId;
    }

    public void setContractId(Long contractId) {
        this.contractId = contractId;
    }

    public String getFirstParty() {
        return firstParty;
    }

    public void setFirstParty(String firstParty) {
        this.firstParty = firstParty;
    }

    public String getPartyB() {
        return partyB;
    }

    public void setPartyB(String partyB) {
        this.partyB = partyB;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Double getDeposit() {
        return deposit;
    }

    public void setDeposit(Double deposit) {
        this.deposit = deposit;
    }

    public Double getRent() {
        return rent;
    }

    public void setRent(Double rent) {
        this.rent = rent;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public House getHouse() {
        return house;
    }

    public void setHouse(House house) {
        this.house = house;
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
