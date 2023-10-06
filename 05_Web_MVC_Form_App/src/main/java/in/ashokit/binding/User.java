package in.ashokit.binding;


public class User {
	private Integer id;
	private String name;
	private String email;
	private Long phno;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Long getPhno() {
		return phno;
	}
	public void setPhno(Long phno) {
		this.phno = phno;
	}
	public User() {
		super();
	}
	public User(String name, String email, Long phno) {
		super();
		
		this.name = name;
		this.email = email;
		this.phno = phno;
	}
	


}
