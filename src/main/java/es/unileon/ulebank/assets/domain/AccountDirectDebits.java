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
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * AccountDirectDebits generated by hbm2java
 */
@Entity
@Table(name = "ACCOUNT_DIRECT_DEBITS", catalog = "ULEBANK_FINAL")
public class AccountDirectDebits implements java.io.Serializable {

	private Integer id;
	private Set<DirectDebit> directDebits = new HashSet<DirectDebit>(0);

	public AccountDirectDebits() {
	}

	public AccountDirectDebits(Set<DirectDebit> directDebits) {
		this.directDebits = directDebits;
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

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "accountDirectDebits")
	public Set<DirectDebit> getDirectDebits() {
		return this.directDebits;
	}

	public void setDirectDebits(Set<DirectDebit> directDebits) {
		this.directDebits = directDebits;
	}

}
