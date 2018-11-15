package co.sobu.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table
public class ShredProgram {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idShred;

	@JsonIgnore
	@OneToOne
	private User shredUser;

	private double actualWeight;
	private double shredKcal;
	private double shredProtPerDay;
	private double shredFatsPerDay;
	private double shredCarbsPerDay;

	@JsonIgnore
	@OneToMany(mappedBy = "shredF")
	private List<Food> shredFood;

	public Long getIdShred() {
		return idShred;
	}

	public void setIdShred(Long idShred) {
		this.idShred = idShred;
	}

	public User getShredUser() {
		return shredUser;
	}

	public void setShredUser(User shredUser) {
		this.shredUser = shredUser;
	}

	public double getActualWeight() {
		return actualWeight;
	}

	public void setActualWeight(double actualWeight) {
		this.actualWeight = actualWeight;
	}

	public double getShredKcal() {
		return shredKcal;
	}

	public void setShredKcal(double shredKcal) {
		this.shredKcal = shredKcal;
	}

	public double getShredProtPerDay() {
		return shredProtPerDay;
	}

	public void setShredProtPerDay(double shredProtPerDay) {
		this.shredProtPerDay = shredProtPerDay;
	}

	public double getShredFatsPerDay() {
		return shredFatsPerDay;
	}

	public void setShredFatsPerDay(double shredFatsPerDay) {
		this.shredFatsPerDay = shredFatsPerDay;
	}

	public double getShredCarbsPerDay() {
		return shredCarbsPerDay;
	}

	public void setShredCarbsPerDay(double shredCarbsPerDay) {
		this.shredCarbsPerDay = shredCarbsPerDay;
	}

	public List<Food> getShredFood() {
		return shredFood;
	}

	public void setShredFood(List<Food> shredFood) {
		this.shredFood = shredFood;
	}

	public ShredProgram(Long idShred, User shredUser, double actualWeight, double shredKcal, double shredProtPerDay,
			double shredFatsPerDay, double shredCarbsPerDay, List<Food> shredFood) {
		super();
		this.idShred = idShred;
		this.shredUser = shredUser;
		this.actualWeight = actualWeight;
		this.shredKcal = shredKcal;
		this.shredProtPerDay = shredProtPerDay;
		this.shredFatsPerDay = shredFatsPerDay;
		this.shredCarbsPerDay = shredCarbsPerDay;
		this.shredFood = shredFood;
	}

	public ShredProgram() {
		super();
	}

	@Override
	public String toString() {
		return "ShredProgram [shredUser=" + shredUser + ", actualWeight=" + actualWeight + ", shredKcal=" + shredKcal
				+ ", shredProtPerDay=" + shredProtPerDay + ", shredFatsPerDay=" + shredFatsPerDay
				+ ", shredCarbsPerDay=" + shredCarbsPerDay + "]";
	}

}
