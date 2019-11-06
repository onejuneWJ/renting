package cn.edu.tf.pojo;

import java.io.Serializable;

/**
 * test_data
 * @author 
 */
public class TestData implements Serializable {
    private Long id;

    /**
     * 批次
     */
    private String batch;

    /**
     * 模板编码
     */
    private String templateCode;

    /**
     * 数据状态[NEW(Excel导入),VALID_SUCCESS(验证成功),VALID_FAILED(验证失败),IMPORT_SUCCESS(导入成功),IMPORT_FAILED(导入失败)]
     */
    private String dataStatus;

    /**
     * 页码
     */
    private Integer sheetIndex;

    /**
     * 错误信息
     */
    private String errorMsg;

    /**
     * 数据
     */
    private String data;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBatch() {
        return batch;
    }

    public void setBatch(String batch) {
        this.batch = batch;
    }

    public String getTemplateCode() {
        return templateCode;
    }

    public void setTemplateCode(String templateCode) {
        this.templateCode = templateCode;
    }

    public String getDataStatus() {
        return dataStatus;
    }

    public void setDataStatus(String dataStatus) {
        this.dataStatus = dataStatus;
    }

    public Integer getSheetIndex() {
        return sheetIndex;
    }

    public void setSheetIndex(Integer sheetIndex) {
        this.sheetIndex = sheetIndex;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
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
        TestData other = (TestData) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getBatch() == null ? other.getBatch() == null : this.getBatch().equals(other.getBatch()))
            && (this.getTemplateCode() == null ? other.getTemplateCode() == null : this.getTemplateCode().equals(other.getTemplateCode()))
            && (this.getDataStatus() == null ? other.getDataStatus() == null : this.getDataStatus().equals(other.getDataStatus()))
            && (this.getSheetIndex() == null ? other.getSheetIndex() == null : this.getSheetIndex().equals(other.getSheetIndex()))
            && (this.getErrorMsg() == null ? other.getErrorMsg() == null : this.getErrorMsg().equals(other.getErrorMsg()))
            && (this.getData() == null ? other.getData() == null : this.getData().equals(other.getData()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getBatch() == null) ? 0 : getBatch().hashCode());
        result = prime * result + ((getTemplateCode() == null) ? 0 : getTemplateCode().hashCode());
        result = prime * result + ((getDataStatus() == null) ? 0 : getDataStatus().hashCode());
        result = prime * result + ((getSheetIndex() == null) ? 0 : getSheetIndex().hashCode());
        result = prime * result + ((getErrorMsg() == null) ? 0 : getErrorMsg().hashCode());
        result = prime * result + ((getData() == null) ? 0 : getData().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", batch=").append(batch);
        sb.append(", templateCode=").append(templateCode);
        sb.append(", dataStatus=").append(dataStatus);
        sb.append(", sheetIndex=").append(sheetIndex);
        sb.append(", errorMsg=").append(errorMsg);
        sb.append(", data=").append(data);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}