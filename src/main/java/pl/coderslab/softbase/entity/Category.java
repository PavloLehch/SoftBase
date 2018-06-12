package pl.coderslab.softbase.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.transaction.Transactional;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "categories")
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotEmpty (message="Name must be submitted")
	@NotBlank
	@Size(min = 4, message = "Name must have more than 3 characters")
	@Column(name = "CategoryName")
	private String categoryName;
	
	public long getId() {
		return id;
	}
	
	
	
	public void setId(long id) {
		this.id = id;
	}

	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	
	@Override
	public String toString() {
		return this.categoryName;
	}

}
