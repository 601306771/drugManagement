package silver.api.supplier.entity;

public class Supplier {
    private Integer id;

    private String scode;

    private String sname;

    private String sphone;

    private String saddress;

    private String sdiscribe;
    
    

    public Supplier() {
	}

	@Override
	public String toString() {
		return "Supplier [id=" + id + ", scode=" + scode + ", sname=" + sname
				+ ", sphone=" + sphone + ", saddress=" + saddress
				+ ", sdiscribe=" + sdiscribe + "]";
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getScode() {
        return scode;
    }

    public void setScode(String scode) {
        this.scode = scode;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getSphone() {
        return sphone;
    }

    public void setSphone(String sphone) {
        this.sphone = sphone;
    }

    public String getSaddress() {
        return saddress;
    }

    public void setSaddress(String saddress) {
        this.saddress = saddress;
    }

    public String getSdiscribe() {
        return sdiscribe;
    }

    public void setSdiscribe(String sdiscribe) {
        this.sdiscribe = sdiscribe;
    }
}