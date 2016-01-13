package silver.api.user.entity;

public class Users {
    private Integer id;

    private String uname;

    private String upassword;

    private Integer utype;

    private String unickname;

    private String discribe;
    
    
    
    
    @Override
	public String toString() {
		return "Users [id=" + id + ", uname=" + uname + ", upassword="
				+ upassword + ", utype=" + utype + ", unickname=" + unickname
				+ ", discribe=" + discribe + "]";
	}

	public Users() {
		
	}
	
	

	public Users(Integer id, String uname, String upassword, Integer utype,
			String unickname, String discribe) {
		super();
		this.id = id;
		this.uname = uname;
		this.upassword = upassword;
		this.utype = utype;
		this.unickname = unickname;
		this.discribe = discribe;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getUpassword() {
        return upassword;
    }

    public void setUpassword(String upassword) {
        this.upassword = upassword;
    }

    public Integer getUtype() {
        return utype;
    }

    public void setUtype(Integer utype) {
        this.utype = utype;
    }

    public String getUnickname() {
        return unickname;
    }

    public void setUnickname(String unickname) {
        this.unickname = unickname;
    }

    public String getDiscribe() {
        return discribe;
    }

    public void setDiscribe(String discribe) {
        this.discribe = discribe;
    }
}