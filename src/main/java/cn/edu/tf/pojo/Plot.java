package cn.edu.tf.pojo;

import java.io.Serializable;

/**
 * plot
 * @author 
 */
public class Plot implements Serializable {
    /**
     * 主键
     */
    private Long id;

    /**
     * 小区名称
     */
    private String plotName;

    /**
     * 小区位置(区域信息)
     */
    private Long locationId;

    /**
     * 小区地址
     */
    private String address;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPlotName() {
        return plotName;
    }

    public void setPlotName(String plotName) {
        this.plotName = plotName;
    }

    public Long getLocationId() {
        return locationId;
    }

    public void setLocationId(Long locationId) {
        this.locationId = locationId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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
        Plot other = (Plot) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getPlotName() == null ? other.getPlotName() == null : this.getPlotName().equals(other.getPlotName()))
            && (this.getLocationId() == null ? other.getLocationId() == null : this.getLocationId().equals(other.getLocationId()))
            && (this.getAddress() == null ? other.getAddress() == null : this.getAddress().equals(other.getAddress()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getPlotName() == null) ? 0 : getPlotName().hashCode());
        result = prime * result + ((getLocationId() == null) ? 0 : getLocationId().hashCode());
        result = prime * result + ((getAddress() == null) ? 0 : getAddress().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", plotName=").append(plotName);
        sb.append(", locationId=").append(locationId);
        sb.append(", address=").append(address);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}