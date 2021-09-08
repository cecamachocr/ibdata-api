package mx.com.unam.ib.ibdata.api.model.entity;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(schema = "ibdata_api", name = "ibd001_user")
public class IbdUserEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -766544016683917126L;
    
	@Id
	@GeneratedValue(generator = "UUID")
    @GenericGenerator(
        name = "UUID",
        strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "id", updatable = false, nullable = false)
	private UUID id;
	
	@Column(name = "name", length = 50)
	private String name;
	
	@Column(name = "last_name", length = 50)
	private String lastName;
	
	@Column(name = "mothers_name", length = 50)
	private String mothersName;
	
	@Column(name = "phone_number", length = 15)
	private Long phoneNumber;

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMothersName() {
		return mothersName;
	}

	public void setMothersName(String mothersName) {
		this.mothersName = mothersName;
	}

	public Long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(Long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	
	
}
