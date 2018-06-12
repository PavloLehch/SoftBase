package pl.coderslab.softbase.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "developers")
public class Developer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotEmpty (message="Name must be submitted")
	@NotBlank
	@Size(min = 3, message = "Name must have more than 2 characters")
	@Column(name = "DevName")
	private String devName;
	
	@NotEmpty (message="Web site must be submitted")
	@NotBlank
	@Size(min = 5, message = "Web site must have more than 4 characters")
	@Column(name = "DevSite")
	private String devSite;
	
	@Email
	@Column(name = "Email")
	private String email;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}



	public String getDevName() {
		return devName;
	}

	public void setDevName(String devName) {
		this.devName = devName;
	}

	public String getDevSite() {
		return devSite;
	}

	public void setDevSite(String devSite) {
		this.devSite = devSite;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return this.devName;
	}
}
