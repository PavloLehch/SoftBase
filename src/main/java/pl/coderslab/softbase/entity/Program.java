package pl.coderslab.softbase.entity;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;


@Entity
@Table(name = "programs")
public class Program {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotEmpty (message="Name must be submitted")
	@NotBlank
	@Size(min = 3, message = "Name must have more than 2 characters")
	@Column(name = "Name")
	private String name;
	
	@NotBlank
	@NotEmpty(message="Version must be submitted")
	@Column(name = "Version")
	private String version;
	
	@NotNull
	@ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
	private Category category;
	
	@Column(name = "Created"/*, updatable=false*/)
	@CreatedDate
//	@CreationTimestamp
	private Date dataCreate;
	
	@Column(name = "Updated")
//	@UpdateTimestamp
	@LastModifiedDate
	private Date dataUpdate;
	
	@NotEmpty(message="Short description must be submitted")
	@NotBlank
	@Size(min = 10, max = 254, message = "Short description must be greater than 9 characters and less than 255 characters")
	@Column(name = "ShortDescription")
	private String shortDescription;
	
	@NotEmpty(message="All description must be submitted")
	@NotBlank
	@Size(min = 10, message = "All description must be greater than 9 characters")
	@Column(name = "AllDescription", columnDefinition = "TEXT")
	private String allDescription;
	
	
	@NotNull
	@ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
	private List<OpSystem> opSystems  = new ArrayList<OpSystem>();
		
	@NotNull
	@ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
	private Developer developer;
	
	@NotBlank
	@NotEmpty(message="Web site must be submitted")
	@Column(name = "Site")
	private String site;
	

	@Column(name = "WhatsNew", columnDefinition = "TEXT")
	private String newInform;
	
	@NotBlank
	@NotEmpty(message="Link must be submitted")
	@Column(name = "Link")
	private String link;
	
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public Date getDataCreate() {
		return dataCreate;
	}
	public void setDataCreate(Date dataCreate) {
		this.dataCreate = dataCreate;
	}
	public Date getDataUpdate() {
		return dataUpdate;
	}
	public void setDataUpdate(Date dataUpdate) {
		this.dataUpdate = dataUpdate;
	}
	public String getShortDescription() {
		return shortDescription;
	}
	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}
	public String getAllDescription() {
		return allDescription;
	}
	public void setAllDescription(String allDescription) {
		this.allDescription = allDescription;
	}
	public List<OpSystem> getOpSystems() {
		return opSystems;
	}
	public void setOpSystems(List<OpSystem> opSystems) {
		this.opSystems = opSystems;
	}
	public Developer getDeveloper() {
		return developer;
	}
	public void setDeveloper(Developer developer) {
		this.developer = developer;
	}
	public String getSite() {
		return site;
	}
	public void setSite(String site) {
		this.site = site;
	}
	public String getNewInform() {
		return newInform;
	}
	public void setNewInform(String newInform) {
		this.newInform = newInform;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	

}