package silver.api.drugInformation.entity;

public class DrugInformation {
    private Integer id;

    private String dname;

    private String dtype;

    private String dusage;

    private String dexpirationdate;

    private String dindications;

    private String dsuitable;

    private String ddiscribe;

    private Integer price;

    
    
    @Override
	public String toString() {
		return "DrugInformation [id=" + id + ", dname=" + dname 
				+ ", dtype=" + dtype + ", dusage=" + dusage
				+ ", dexpirationdate=" + dexpirationdate + ", dindications="
				+ dindications + ", dsuitable=" + dsuitable + ", ddiscribe="
				+ ddiscribe + ", price=" + price + "]";
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    
    public String getDtype() {
        return dtype;
    }

    public void setDtype(String dtype) {
        this.dtype = dtype;
    }

    public String getDusage() {
        return dusage;
    }

    public void setDusage(String dusage) {
        this.dusage = dusage;
    }

    public String getDexpirationdate() {
        return dexpirationdate;
    }

    public void setDexpirationdate(String dexpirationdate) {
        this.dexpirationdate = dexpirationdate;
    }

    public String getDindications() {
        return dindications;
    }

    public void setDindications(String dindications) {
        this.dindications = dindications;
    }

    public String getDsuitable() {
        return dsuitable;
    }

    public void setDsuitable(String dsuitable) {
        this.dsuitable = dsuitable;
    }

    public String getDdiscribe() {
        return ddiscribe;
    }

    public void setDdiscribe(String ddiscribe) {
        this.ddiscribe = ddiscribe;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}