package cn.edu.tf.pojo;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 * house
 *
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
     * 发布时间
     */
    private Date postTime;

    /**
     * 状态('N':未租,'Y':已租)
     */
    private String status;

    private Integer provinceId;
    private Integer cityId;
    private Integer locationId;
    private String plotName;


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

    public Integer getLocationId() {
        return locationId;
    }

    public void setLocationId(Integer locationId) {
        this.locationId = locationId;
    }

    public String getPlotName() {
        return plotName;
    }

    public void setPlotName(String plotName) {
        this.plotName = plotName;
    }

    public Integer getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(Integer provinceId) {
        this.provinceId = provinceId;
    }

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        House house = (House) o;
        return Objects.equals(id, house.id) &&
                Objects.equals(userId, house.userId) &&
                Objects.equals(plotId, house.plotId) &&
                Objects.equals(huxingShi, house.huxingShi) &&
                Objects.equals(huxingTing, house.huxingTing) &&
                Objects.equals(huxingWei, house.huxingWei) &&
                Objects.equals(area, house.area) &&
                Objects.equals(currentFloor, house.currentFloor) &&
                Objects.equals(totalFloor, house.totalFloor) &&
                Objects.equals(towardsId, house.towardsId) &&
                Objects.equals(rental, house.rental) &&
                Objects.equals(paymentId, house.paymentId) &&
                Objects.equals(rentalInclude, house.rentalInclude) &&
                Objects.equals(houseInclude, house.houseInclude) &&
                Objects.equals(require, house.require) &&
                Objects.equals(description, house.description) &&
                Objects.equals(imgBoxId, house.imgBoxId) &&
                Objects.equals(postTime, house.postTime) &&
                Objects.equals(status, house.status) &&
                Objects.equals(provinceId, house.provinceId) &&
                Objects.equals(cityId, house.cityId) &&
                Objects.equals(locationId, house.locationId) &&
                Objects.equals(plotName, house.plotName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userId, plotId, huxingShi, huxingTing, huxingWei, area, currentFloor, totalFloor, towardsId, rental, paymentId, rentalInclude, houseInclude, require, description, imgBoxId, postTime, status, provinceId, cityId, locationId, plotName);
    }
}