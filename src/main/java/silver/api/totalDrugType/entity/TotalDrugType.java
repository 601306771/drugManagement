package silver.api.totalDrugType.entity;

public class TotalDrugType {
    private Integer id;

    private String tcode;

    private String tname;

    private String tdiscribe;

    
    
    @Override
	public String toString() {
		return "TotalDrugType [id=" + id + ", tcode=" + tcode + ", tname="
				+ tname + ", tdiscribe=" + tdiscribe + "]";
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTcode() {
        return tcode;
    }

    public void setTcode(String tcode) {
        this.tcode = tcode;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public String getTdiscribe() {
        return tdiscribe;
    }

    public void setTdiscribe(String tdiscribe) {
        this.tdiscribe = tdiscribe;
    }
}