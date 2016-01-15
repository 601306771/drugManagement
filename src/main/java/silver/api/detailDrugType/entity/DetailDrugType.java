package silver.api.detailDrugType.entity;

public class DetailDrugType {
    private Integer id;

    private String dcode;

    private String dname;

    private String ddiscribe;

    
    @Override
	public String toString() {
		return "DetailDrugType [id=" + id + ", dcode=" + dcode + ", dname="
				+ dname + ", ddiscribe=" + ddiscribe + "]";
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDcode() {
        return dcode;
    }

    public void setDcode(String dcode) {
        this.dcode = dcode;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public String getDdiscribe() {
        return ddiscribe;
    }

    public void setDdiscribe(String ddiscribe) {
        this.ddiscribe = ddiscribe;
    }
}