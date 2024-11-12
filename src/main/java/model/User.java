package model;

public class User {
	
	private int id;
	private String name;
	private String email;
	private String country;
	private String password;
	
	
	public User() {
	
	}
public User( String name, String email, String country) {
		
		
		this.name = name;
		this.email = email;
		this.country = country;
		
	}

	public User( String name, String email, String country, String password) {
		
		
		this.name = name;
		this.email = email;
		this.country = country;
		this.password = password;
	}

    
	public User(int id, String name, String email, String country, String password) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.country = country;
		this.password = password;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
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


	public String getCountry() {
		return country;
	}


	public void setCountry(String country) {
		this.country = country;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email + ", country=" + country + ", password="
				+ password + "]";
	}
	
	

}

