package in.ashokit.Model;

public class Product {
	private Integer pid;
	private String name; 
	private Double price;
	public Integer getPid() {
		return pid;
	}
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Product(Integer pid, String name, Double price) {
		super();
		this.pid = pid;
		this.name = name;
		this.price = price;
	}
	
	
}
		
	
