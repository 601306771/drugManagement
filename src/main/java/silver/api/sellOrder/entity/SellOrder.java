package silver.api.sellOrder.entity;

import java.util.Date;

public class SellOrder {
	private String state;
	
    private Integer id;

    private String soCode;

    private Date day;

    private Float price;

    
    
    public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSoCode() {
        return soCode;
    }

    public void setSoCode(String soCode) {
        this.soCode = soCode;
    }

    public Date getDay() {
        return day;
    }

    public void setDay(Date day) {
        this.day = day;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }
}