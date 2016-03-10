package silver.api.orders.entity;

import java.util.Date;

public class Orders {
    private Integer id;

    private String ocode;

    private Date date;

    private Integer prices;

    private String state;

    
    
    @Override
	public String toString() {
		return "Orders [id=" + id + ", ocode=" + ocode + ", date=" + date
				+ ", prices=" + prices + ", state=" + state + "]";
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getPrices() {
        return prices;
    }

    public void setPrices(Integer prices) {
        this.prices = prices;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}