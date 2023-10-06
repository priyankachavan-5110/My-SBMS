package in.ashokit.binding;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="USER_DETAILS")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID")
	private Integer id;
	
	@NotEmpty(message ="Name is mandatory")
	@Size(min=3,max=10,message ="min 3 max 10 characters mandatory")
	@Column(name="NAME")
	private String name;
	
	@NotNull(message ="Phone no is mandatory")
	@Column(name="PHONE_NO")
	private String pno;
	
	@NotEmpty(message ="Email is mandatory")
	@Email(message ="Enter valid email")
	@Column(name="EMAIL" ,unique=true)
	private String email;
	
	@NotEmpty(message ="Password is mandatory")
	@Column(name="PASSWORD")
	private String password;
	
	@NotEmpty(message ="Select Gender")
	@Column(name="GENDER")
	private String gender;
	

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

	public String getPno() {
		return pno;
	}

	public void setPno(String pno) {
		this.pno = pno;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", pno=" + pno + ", email=" + email + ", password=" + password + ", gender="
				+ gender + "]";
	}

	public User() {
		super();
	}

	public User(
			@NotEmpty(message = "Name is mandatory") @Size(min = 3, max = 10, message = "min 3 max 10 characters mandatory") String name,
			@NotNull(message = "Phone no is mandatory") String pno,
			@NotEmpty(message = "Email is mandatory") @Email(message = "Enter valid email") String email,
			String password, String gender) {
		super();
		this.name = name;
		this.pno = pno;
		this.email = email;
		this.password = password;
		this.gender = gender;
	}

	

	
	
	
		
	

}
