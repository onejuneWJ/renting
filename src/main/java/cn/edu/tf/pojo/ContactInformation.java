package cn.edu.tf.pojo;

import java.io.Serializable;

/**
 * contact_information
 * @author 
 */
public class ContactInformation implements Serializable {
    /**
     * 主键
     */
    private Long id;

    /**
     * 联系人姓名
     */
    private String name;

    /**
     * 性别（1：男，0女）
     */
    private Boolean gender;

    /**
     * 电话
     */
    private String phone;

    /**
     * 接听时间开始
     */
    private String receiveTimeStart;

    /**
     * 接听时间结束
     */
    private String receiveTimeEnd;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getGender() {
        return gender;
    }

    public void setGender(Boolean gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getReceiveTimeStart() {
        return receiveTimeStart;
    }

    public void setReceiveTimeStart(String receiveTimeStart) {
        this.receiveTimeStart = receiveTimeStart;
    }

    public String getReceiveTimeEnd() {
        return receiveTimeEnd;
    }

    public void setReceiveTimeEnd(String receiveTimeEnd) {
        this.receiveTimeEnd = receiveTimeEnd;
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
        ContactInformation other = (ContactInformation) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getGender() == null ? other.getGender() == null : this.getGender().equals(other.getGender()))
            && (this.getPhone() == null ? other.getPhone() == null : this.getPhone().equals(other.getPhone()))
            && (this.getReceiveTimeStart() == null ? other.getReceiveTimeStart() == null : this.getReceiveTimeStart().equals(other.getReceiveTimeStart()))
            && (this.getReceiveTimeEnd() == null ? other.getReceiveTimeEnd() == null : this.getReceiveTimeEnd().equals(other.getReceiveTimeEnd()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getGender() == null) ? 0 : getGender().hashCode());
        result = prime * result + ((getPhone() == null) ? 0 : getPhone().hashCode());
        result = prime * result + ((getReceiveTimeStart() == null) ? 0 : getReceiveTimeStart().hashCode());
        result = prime * result + ((getReceiveTimeEnd() == null) ? 0 : getReceiveTimeEnd().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", gender=").append(gender);
        sb.append(", phone=").append(phone);
        sb.append(", receiveTimeStart=").append(receiveTimeStart);
        sb.append(", receiveTimeEnd=").append(receiveTimeEnd);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}