package silver.api.ordersDetails.entity;

public class OrdersDetails {
    private Integer id;

    private String ocode;

    private String dname;

    private Integer prices;

    private Integer quantity;

    
    
    @Override
	public String toString() {
		return "OrdersDetails [id=" + id + ", ocode=" + ocode + ", dname="
				+ dname + ", prices=" + prices + ", quantity=" + quantity + "]";
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOcode() {
        return ocode;
    }

    public void setOcode(String ocode) {
        this.ocode = ocode;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public Integer getPrices() {
        return prices;
    }

    public void setPrices(Integer prices) {
        this.prices = prices;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}