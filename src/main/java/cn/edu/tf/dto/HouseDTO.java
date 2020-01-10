package cn.edu.tf.dto;

import cn.edu.tf.pojo.HouseInclude;
import cn.edu.tf.pojo.Img;
import cn.edu.tf.pojo.RentalInclude;
import cn.edu.tf.pojo.Requires;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

public class HouseDTO {
    /**
     * 主键
     */
    private Long id;

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
     * 租金（单位：元/月）
     */
    private Double rental;

    /**
     * 租金包含
     */
    private String rentalInclude;
    private List<RentalInclude> rentalIncludeList;
    /**
     * 房屋配置
     */
    private String houseInclude;
    private List<HouseInclude> houseIncludeList;
    /**
     * 出租要求
     */
    private String require;
    private List<Requires> requiresList;
    /**
     * 描述
     */
    private String description;

    /**
     * 房屋图片，对应图片盒子id
     */
    private Long imgBoxId;

    @JsonFormat(pattern = "yyyy年MM月dd日")
    @DateTimeFormat(pattern = "yyyy年MM月dd日")
    private Date postTime;

    /**
     * 状态('N':未租,'Y':已租)
     */
    private String status;

    private List<Img> imgList;

    private String payment;

    private String towards;

    private String plotName;

    private String address;

    private Integer userId;

    private String email;

    private String avatar;

    private String contactName;

    private Integer contactGender;

    private String contactPhone;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Double getRental() {
        return rental;
    }

    public void setRental(Double rental) {
        this.rental = rental;
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

    public List<Img> getImgList() {
        return imgList;
    }

    public void setImgList(List<Img> imgList) {
        this.imgList = imgList;
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }

    public String getTowards() {
        return towards;
    }

    public void setTowards(String towards) {
        this.towards = towards;
    }

    public String getPlotName() {
        return plotName;
    }

    public void setPlotName(String plotName) {
        this.plotName = plotName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public Integer getContactGender() {
        return contactGender;
    }

    public void setContactGender(Integer contactGender) {
        this.contactGender = contactGender;
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }

    public List<RentalInclude> getRentalIncludeList() {
        return rentalIncludeList;
    }

    public void setRentalIncludeList(List<RentalInclude> rentalIncludeList) {
        this.rentalIncludeList = rentalIncludeList;
    }

    public List<HouseInclude> getHouseIncludeList() {
        return houseIncludeList;
    }

    public void setHouseIncludeList(List<HouseInclude> houseIncludeList) {
        this.houseIncludeList = houseIncludeList;
    }

    public List<Requires> getRequiresList() {
        return requiresList;
    }

    public void setRequiresList(List<Requires> requiresList) {
        this.requiresList = requiresList;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Date getPostTime() {
        return postTime;
    }

    public void setPostTime(Date postTime) {
        this.postTime = postTime;
    }

    @Override
    public String toString() {
        return "HouseDTO{" +
            "id=" + id +
            ", huxingShi=" + huxingShi +
            ", huxingTing=" + huxingTing +
            ", huxingWei=" + huxingWei +
            ", area=" + area +
            ", currentFloor=" + currentFloor +
            ", totalFloor=" + totalFloor +
            ", rental=" + rental +
            ", rentalInclude='" + rentalInclude + '\'' +
            ", rentalIncludeList=" + rentalIncludeList +
            ", houseInclude='" + houseInclude + '\'' +
            ", houseIncludeList=" + houseIncludeList +
            ", require='" + require + '\'' +
            ", requiresList=" + requiresList +
            ", description='" + description + '\'' +
            ", imgBoxId=" + imgBoxId +
            ", postTime=" + postTime +
            ", status='" + status + '\'' +
            ", imgList=" + imgList +
            ", payment='" + payment + '\'' +
            ", towards='" + towards + '\'' +
            ", plotName='" + plotName + '\'' +
            ", address='" + address + '\'' +
            ", userId=" + userId +
            ", email='" + email + '\'' +
            ", avatar='" + avatar + '\'' +
            ", contactName='" + contactName + '\'' +
            ", contactGender=" + contactGender +
            ", contactPhone='" + contactPhone + '\'' +
            '}';
    }
}
