package org.ticketbooking.core.domain.user;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.ticketbooking.core.domain.other.Locale;
import org.ticketbooking.core.domain.other.LocaleImpl;

@Entity
@Table(name="TBS_COUNTRY")
@NamedQueries(value={
		@NamedQuery(name="CountryImpl.fetchByCountryName",query="from CountryImpl where name = :name")
})
public class CountryImpl implements Country{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="TBS_COUNTRY_ID")
	private Long id;
	
	@Column(name="TBS_COUNTRY_NAME",unique=true)
	private String name;
	
	@OneToOne(mappedBy="country",cascade=CascadeType.ALL,targetEntity=LocaleImpl.class)
	private Locale locale;
	
	@OneToOne(mappedBy="country",cascade=CascadeType.ALL,targetEntity=StateImpl.class)
	private State state;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Locale getLocale() {
		return locale;
	}

	public void setLocale(Locale locale) {
		this.locale = locale;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	@Override
	public String toString() {
		return "CountryImpl [id=" + id + ", name=" + name + ", locale="
				+ locale + ", state=" + state + "]";
	}	
	
	
}
