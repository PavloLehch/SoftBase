package pl.coderslab.softbase.entity;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.annotation.CreatedDate;

@Entity
@Table(name = "news")
public class News {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@NotEmpty(message = "Title must be submitted")
	@NotBlank
	@Size(min = 3, message = "Name must have more than 2 characters")
	@Column(name = "NewsTitle")
	private String newsTitle;

	@Column(name = "NewsCreated")
	@CreatedDate
	private Date newsDataCreate;

	@NotEmpty(message = "Short description must be submitted")
	@NotBlank
	@Size(min = 10, max = 254, message = "Short description must be greater than 9 characters and less than 255 characters")
	@Column(name = "NewsShortDescription")
	private String newsShortDescription;

	@NotEmpty(message = "All description must be submitted")
	@NotBlank
	@Size(min = 10, message = "All description must be greater than 9 characters")
	@Column(name = "NewsAllDescription", columnDefinition = "TEXT")
	private String newsAllDescription;

	@NotNull
	@ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
	private Category category;

	@NotEmpty(message = "Source must be submitted")
	@NotBlank
	@Column(name = "NewsSource")
	private String newsSource;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNewsTitle() {
		return newsTitle;
	}

	public void setNewsTitle(String newsTitle) {
		this.newsTitle = newsTitle;
	}

	public Date getNewsDataCreate() {
		return newsDataCreate;
	}

	public void setNewsDataCreate(Date newsDataCreate) {
		this.newsDataCreate = newsDataCreate;
	}

	public String getNewsShortDescription() {
		return newsShortDescription;
	}

	public void setNewsShortDescription(String newsShortDescription) {
		this.newsShortDescription = newsShortDescription;
	}

	public String getNewsAllDescription() {
		return newsAllDescription;
	}

	public void setNewsAllDescription(String newsAllDescription) {
		this.newsAllDescription = newsAllDescription;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public String getNewsSource() {
		return newsSource;
	}

	public void setNewsSource(String newsSource) {
		this.newsSource = newsSource;
	}

}
