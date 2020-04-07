package cn.edu.tf.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * deal
 * @author 
 */
public class Deal implements Serializable {
    /**
     * 主键
     */
    private Integer id;

    /**
     * 承租人，租户
     */
    private Long renterId;

    /**
     * 出租人，房东
     */
    private Long leaserId;

    /**
     * 状态('ONGOING':进行中,'SUCCESS':交易成功，'FAILED':交易失败)
     */
    private String status;

    /**
     * 创建时间
     */
    @JsonFormat(pattern = "YYYY/MM/DD")
    private Date createTime;

    /**
     * 完成时间
     */
    @JsonFormat(pattern = "YYYY/MM/DD")
    private Date completeTime;

    /**
     * 房源ID
     */
    private Long houseId;


    private String renterName;

    private String leaserName;

    private String houseInfo;
    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getRenterId() {
        return renterId;
    }

    public void setRenterId(Long renterId) {
        this.renterId = renterId;
    }

    public Long getLeaserId() {
        return leaserId;
    }

    public void setLeaserId(Long leaserId) {
        this.leaserId = leaserId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getCompleteTime() {
        return completeTime;
    }

    public void setCompleteTime(Date completeTime) {
        this.completeTime = completeTime;
    }

    public Long getHouseId() {
        return houseId;
    }

    public void setHouseId(Long houseId) {
        this.houseId = houseId;
    }

    public String getRenterName() {
        return renterName;
    }

    public void setRenterName(String renterName) {
        this.renterName = renterName;
    }

    public String getLeaserName() {
        return leaserName;
    }

    public void setLeaserName(String leaserName) {
        this.leaserName = leaserName;
    }

    public String getHouseInfo() {
        return houseInfo;
    }

    public void setHouseInfo(String houseInfo) {
        this.houseInfo = houseInfo;
    }

}