package silver.api.newDrugRequest.entity;

public class NewDrugRequestEntity {
    private Long id;

    private String tdtType;

    private String ddtType;

    private String dName;

    private String dIntroduce;

    private String ndrReason;

    private String ndrStatus;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTdtType() {
        return tdtType;
    }

    public void setTdtType(String tdtType) {
        this.tdtType = tdtType;
    }

    public String getDdtType() {
        return ddtType;
    }

    public void setDdtType(String ddtType) {
        this.ddtType = ddtType;
    }

    public String getdName() {
        return dName;
    }

    public void setdName(String dName) {
        this.dName = dName;
    }

    public String getdIntroduce() {
        return dIntroduce;
    }

    public void setdIntroduce(String dIntroduce) {
        this.dIntroduce = dIntroduce;
    }

    public String getNdrReason() {
        return ndrReason;
    }

    public void setNdrReason(String ndrReason) {
        this.ndrReason = ndrReason;
    }

    public String getNdrStatus() {
        return ndrStatus;
    }

    public void setNdrStatus(String ndrStatus) {
        this.ndrStatus = ndrStatus;
    }

	@Override
	public String toString() {
		return "newDrugRequest [id=" + id + ", tdtType=" + tdtType
				+ ", ddtType=" + ddtType + ", dName=" + dName + ", dIntroduce="
				+ dIntroduce + ", ndrReason=" + ndrReason + ", ndrStatus="
				+ ndrStatus + "]";
	}
    
}