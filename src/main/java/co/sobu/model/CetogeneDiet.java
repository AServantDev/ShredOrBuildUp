package co.sobu.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table
public class CetogeneDiet {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idCetogen;
	
	private double cetoKcal;
	private double cetoProtPerDay;
	private double cetoFatsPerDay;
	private double cetoCarbsPerDay;
	
	@OneToMany(mappedBy="foodCeto")
	private List<Food> cetoFood;
	@OneToOne
	private User cetoUser;
	
	public Long getIdCetogen() {
		return idCetogen;
	}
	public void setIdCetogen(Long idCetogen) {
		this.idCetogen = idCetogen;
	}
	public double getCetoKcal() {
		return cetoKcal;
	}
	public void setCetoKcal(double cetoKcal) {
		this.cetoKcal = cetoKcal;
	}
	public double getCetoProtPerDay() {
		return cetoProtPerDay;
	}
	public void setCetoProtPerDay(double cetoProtPerDay) {
		this.cetoProtPerDay = cetoProtPerDay;
	}
	public double getCetoFatsPerDay() {
		return cetoFatsPerDay;
	}
	public void setCetoFatsPerDay(double cetoFatsPerDay) {
		this.cetoFatsPerDay = cetoFatsPerDay;
	}
	public double getCetoCarbsPerDay() {
		return cetoCarbsPerDay;
	}
	public void setCetoCarbsPerDay(double cetoCarbsPerDay) {
		this.cetoCarbsPerDay = cetoCarbsPerDay;
	}
	public List<Food> getCetoFood() {
		return cetoFood;
	}
	public void setCetoFood(List<Food> cetoFood) {
		this.cetoFood = cetoFood;
	}
	public CetogeneDiet(Long idCetogen, double cetoKcal, double cetoProtPerDay, double cetoFatsPerDay,
			double cetoCarbsPerDay, List<Food> cetoFood) {
		super();
		this.idCetogen = idCetogen;
		this.cetoKcal = cetoKcal;
		this.cetoProtPerDay = cetoProtPerDay;
		this.cetoFatsPerDay = cetoFatsPerDay;
		this.cetoCarbsPerDay = cetoCarbsPerDay;
		this.cetoFood = cetoFood;
	}
	public CetogeneDiet() {
		super();
	}
	@Override
	public String toString() {
		return "CetogeneDiet [ cetoKcal=" + cetoKcal + ", cetoProtPerDay=" + cetoProtPerDay
				+ ", cetoFatsPerDay=" + cetoFatsPerDay + ", cetoCarbsPerDay=" + cetoCarbsPerDay + ", cetoFood="
				+ cetoFood + "]";
	}
	public User getCetoUser() {
		return cetoUser;
	}
	public void setCetoUser(User cetoUser) {
		this.cetoUser = cetoUser;
	}
	
	

}
