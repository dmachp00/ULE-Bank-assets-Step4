package es.unileon.ulebank.assets.domain;

// Generated Jun 15, 2014 6:36:38 PM by Hibernate Tools 3.4.0.CR1

import static javax.persistence.GenerationType.IDENTITY;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import es.unileon.ulebank.client.Client;

/**
 * Fees generated by hbm2java
 */
@Entity
@Table(name = "FEES", catalog = "ULEBANK_FINAL")
public class Fees implements java.io.Serializable {

	private Integer id;
	private Client clients;
	private Double quantity;
	private Integer maximunAge;
	private String description;
	private String discriminator;
	private Byte isPercent;
	private Set<Buyable> buyables = new HashSet<Buyable>(0);

	public Fees() {
	}

	public Fees(Client clients, Double quantity, Integer maximunAge,
			String description, String discriminator, Byte isPercent,
			Set<Buyable> buyables) {
		this.clients = clients;
		this.quantity = quantity;
		this.maximunAge = maximunAge;
		this.description = description;
		this.discriminator = discriminator;
		this.isPercent = isPercent;
		this.buyables = buyables;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "client_id")
	public Client getClient() {
		return this.clients;
	}

	public void setClient(Client clients) {
		this.clients = clients;
	}

	@Column(name = "quantity", precision = 22, scale = 0)
	public Double getQuantity() {
		return this.quantity;
	}

	public void setQuantity(Double quantity) {
		this.quantity = quantity;
	}

	@Column(name = "maximun_age")
	public Integer getMaximunAge() {
		return this.maximunAge;
	}

	public void setMaximunAge(Integer maximunAge) {
		this.maximunAge = maximunAge;
	}

	@Column(name = "description", length = 512)
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "discriminator", length = 20)
	public String getDiscriminator() {
		return this.discriminator;
	}

	public void setDiscriminator(String discriminator) {
		this.discriminator = discriminator;
	}

	@Column(name = "is_percent")
	public Byte getIsPercent() {
		return this.isPercent;
	}

	public void setIsPercent(Byte isPercent) {
		this.isPercent = isPercent;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "fees")
	public Set<Buyable> getBuyables() {
		return this.buyables;
	}

	public void setBuyables(Set<Buyable> buyables) {
		this.buyables = buyables;
	}

}