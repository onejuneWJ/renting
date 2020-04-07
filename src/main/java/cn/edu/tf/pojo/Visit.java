package cn.edu.tf.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * visit
 * @author 
 */
public class Visit implements Serializable {
    /**
     * 主键
     */
    private Long id;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 房源id
     */
    private Long houseId;

    /**
     * 发起时间
     */
    @JsonFormat(pattern = "YYYY/MM/DD")
    private Date requestTime;

    private String requestName;

    private String houseInfo;

    private Long leaserId;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getHouseId() {
        return houseId;
    }

    public void setHouseId(Long houseId) {
        this.houseId = houseId;
    }

    public Date getRequestTime() {
        return requestTime;
    }

    public void setRequestTime(Date requestTime) {
        this.requestTime = requestTime;
    }

    public String getRequestName() {
        return requestName;
    }

    public void setRequestName(String requestName) {
        this.requestName = requestName;
    }

    public String getHouseInfo() {
        return houseInfo;
    }

    public void setHouseInfo(String houseInfo) {
        this.houseInfo = houseInfo;
    }

    public Long getLeaserId() {
        return leaserId;
    }

    public void setLeaserId(Long leaserId) {
        this.leaserId = leaserId;
    }
}