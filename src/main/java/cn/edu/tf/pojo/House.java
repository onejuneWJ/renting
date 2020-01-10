package cn.edu.tf.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * house
 * @author 
 */
public class House implements Serializable {
    /**
     * 主键
     */
    private Long id;

    /**
     * 发布者id
     */
    private Long userId;

    /**
     * 小区
     */
    private Long plotId;

    /**
     * 户型室
     */
    private Integer huxingShi;

    /**
     * 户型厅
     */
    private Integer huxingTing;

    /**
     * 户型卫
     */
    private Integer huxingWei;

    /**
     * 面积
     */
    private Integer area;

    /**
     * 当前楼层
     */
    private Integer currentFloor;

    /**
     * 总楼层
     */
    private Integer totalFloor;

    /**
     * 房屋朝向
     */
    private Integer towardsId;

    /**
     * 租金（单位：元/月）
     */
    private Double rental;

    /**
     * 付款方式
     */
    private Integer paymentId;

    /**
     * 租金包含
     */
    private String rentalInclude;

    /**
     * 房屋配置
     */
    private String houseInclude;

    /**
     * 出租要求
     */
    private String require;

    /**
     * 描述
     */
    private String description;

    /**
     * 房屋图片，对应图片盒子id
     */
    private Long imgBoxId;

    /**
     * 联系人信息
     */
    private Long contactInformationId;

    /**
     * 发布时间
     */
    private Date postTime;

    /**
     * 状态('N':未租,'Y':已租)
     */
    private String status;

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

    public Long getPlotId() {
        return plotId;
    }

    public void setPlotId(Long plotId) {
        this.plotId = plotId;
    }

    public Integer getHuxingShi() {
        return huxingShi;
    }

    public void setHuxingShi(Integer huxingShi) {
        this.huxingShi = huxingShi;
    }

    public Integer getHuxingTing() {
        return huxingTing;
    }

    public void setHuxingTing(Integer huxingTing) {
        this.huxingTing = huxingTing;
    }

    public Integer getHuxingWei() {
        return huxingWei;
    }

    public void setHuxingWei(Integer huxingWei) {
        this.huxingWei = huxingWei;
    }

    public Integer getArea() {
        return area;
    }

    public void setArea(Integer area) {
        this.area = area;
    }

    public Integer getCurrentFloor() {
        return currentFloor;
    }

    public void setCurrentFloor(Integer currentFloor) {
        this.currentFloor = currentFloor;
    }

    public Integer getTotalFloor() {
        return totalFloor;
    }

    public void setTotalFloor(Integer totalFloor) {
        this.totalFloor = totalFloor;
    }

    public Integer getTowardsId() {
        return towardsId;
    }

    public void setTowardsId(Integer towardsId) {
        this.towardsId = towardsId;
    }

    public Double getRental() {
        return rental;
    }

    public void setRental(Double rental) {
        this.rental = rental;
    }

    public Integer getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(Integer paymentId) {
        this.paymentId = paymentId;
    }

    public String getRentalInclude() {
        return rentalInclude;
    }

    public void setRentalInclude(String rentalInclude) {
        this.rentalInclude = rentalInclude;
    }

    public String getHouseInclude() {
        return houseInclude;
    }

    public void setHouseInclude(String houseInclude) {
        this.houseInclude = houseInclude;
    }

    public String getRequire() {
        return require;
    }

    public void setRequire(String require) {
        this.require = require;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getImgBoxId() {
        return imgBoxId;
    }

    public void setImgBoxId(Long imgBoxId) {
        this.imgBoxId = imgBoxId;
    }

    public Long getContactInformationId() {
        return contactInformationId;
    }

    public void setContactInformationId(Long contactInformationId) {
        this.contactInformationId = contactInformationId;
    }

    public Date getPostTime() {
        return postTime;
    }

    public void setPostTime(Date postTime) {
        this.postTime = postTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        House other = (House) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getPlotId() == null ? other.getPlotId() == null : this.getPlotId().equals(other.getPlotId()))
            && (this.getHuxingShi() == null ? other.getHuxingShi() == null : this.getHuxingShi().equals(other.getHuxingShi()))
            && (this.getHuxingTing() == null ? other.getHuxingTing() == null : this.getHuxingTing().equals(other.getHuxingTing()))
            && (this.getHuxingWei() == null ? other.getHuxingWei() == null : this.getHuxingWei().equals(other.getHuxingWei()))
            && (this.getArea() == null ? other.getArea() == null : this.getArea().equals(other.getArea()))
            && (this.getCurrentFloor() == null ? other.getCurrentFloor() == null : this.getCurrentFloor().equals(other.getCurrentFloor()))
            && (this.getTotalFloor() == null ? other.getTotalFloor() == null : this.getTotalFloor().equals(other.getTotalFloor()))
            && (this.getTowardsId() == null ? other.getTowardsId() == null : this.getTowardsId().equals(other.getTowardsId()))
            && (this.getRental() == null ? other.getRental() == null : this.getRental().equals(other.getRental()))
            && (this.getPaymentId() == null ? other.getPaymentId() == null : this.getPaymentId().equals(other.getPaymentId()))
            && (this.getRentalInclude() == null ? other.getRentalInclude() == null : this.getRentalInclude().equals(other.getRentalInclude()))
            && (this.getHouseInclude() == null ? other.getHouseInclude() == null : this.getHouseInclude().equals(other.getHouseInclude()))
            && (this.getRequire() == null ? other.getRequire() == null : this.getRequire().equals(other.getRequire()))
            && (this.getDescription() == null ? other.getDescription() == null : this.getDescription().equals(other.getDescription()))
            && (this.getImgBoxId() == null ? other.getImgBoxId() == null : this.getImgBoxId().equals(other.getImgBoxId()))
            && (this.getContactInformationId() == null ? other.getContactInformationId() == null : this.getContactInformationId().equals(other.getContactInformationId()))
            && (this.getPostTime() == null ? other.getPostTime() == null : this.getPostTime().equals(other.getPostTime()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getPlotId() == null) ? 0 : getPlotId().hashCode());
        result = prime * result + ((getHuxingShi() == null) ? 0 : getHuxingShi().hashCode());
        result = prime * result + ((getHuxingTing() == null) ? 0 : getHuxingTing().hashCode());
        result = prime * result + ((getHuxingWei() == null) ? 0 : getHuxingWei().hashCode());
        result = prime * result + ((getArea() == null) ? 0 : getArea().hashCode());
        result = prime * result + ((getCurrentFloor() == null) ? 0 : getCurrentFloor().hashCode());
        result = prime * result + ((getTotalFloor() == null) ? 0 : getTotalFloor().hashCode());
        result = prime * result + ((getTowardsId() == null) ? 0 : getTowardsId().hashCode());
        result = prime * result + ((getRental() == null) ? 0 : getRental().hashCode());
        result = prime * result + ((getPaymentId() == null) ? 0 : getPaymentId().hashCode());
        result = prime * result + ((getRentalInclude() == null) ? 0 : getRentalInclude().hashCode());
        result = prime * result + ((getHouseInclude() == null) ? 0 : getHouseInclude().hashCode());
        result = prime * result + ((getRequire() == null) ? 0 : getRequire().hashCode());
        result = prime * result + ((getDescription() == null) ? 0 : getDescription().hashCode());
        result = prime * result + ((getImgBoxId() == null) ? 0 : getImgBoxId().hashCode());
        result = prime * result + ((getContactInformationId() == null) ? 0 : getContactInformationId().hashCode());
        result = prime * result + ((getPostTime() == null) ? 0 : getPostTime().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", userId=").append(userId);
        sb.append(", plotId=").append(plotId);
        sb.append(", huxingShi=").append(huxingShi);
        sb.append(", huxingTing=").append(huxingTing);
        sb.append(", huxingWei=").append(huxingWei);
        sb.append(", area=").append(area);
        sb.append(", currentFloor=").append(currentFloor);
        sb.append(", totalFloor=").append(totalFloor);
        sb.append(", towardsId=").append(towardsId);
        sb.append(", rental=").append(rental);
        sb.append(", paymentId=").append(paymentId);
        sb.append(", rentalInclude=").append(rentalInclude);
        sb.append(", houseInclude=").append(houseInclude);
        sb.append(", require=").append(require);
        sb.append(", description=").append(description);
        sb.append(", imgBoxId=").append(imgBoxId);
        sb.append(", contactInformationId=").append(contactInformationId);
        sb.append(", postTime=").append(postTime);
        sb.append(", status=").append(status);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}