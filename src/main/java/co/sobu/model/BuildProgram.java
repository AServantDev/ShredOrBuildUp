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
public class BuildProgram {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idBuild;

	@JsonIgnore
	@OneToOne
	private User buildUser;

	private double actualWeight;
	private double buildKcal;
	private double buildProtPerDay;
	private double buildFatsPerDay;
	private double buildCarbsPerDay;

	@OneToMany(mappedBy="foodBuild")
	private List<Food> buildFood;

	public Long getIdBuild() {
		return idBuild;
	}

	public void setIdBuild(Long idBuild) {
		this.idBuild = idBuild;
	}

	public User getBuildUser() {
		return buildUser;
	}

	public void setBuildUser(User buildUser) {
		this.buildUser = buildUser;
	}

	public double getActualWeight() {
		return actualWeight;
	}

	public void setActualWeight(double actualWeight) {
		this.actualWeight = actualWeight;
	}

	public double getBuildKcal() {
		return buildKcal;
	}

	public void setBuildKcal(double buildKcal) {
		this.buildKcal = buildKcal;
	}

	public double getBuildProtPerDay() {
		return buildProtPerDay;
	}

	public void setBuildProtPerDay(double buildProtPerDay) {
		this.buildProtPerDay = buildProtPerDay;
	}

	public double getBuildFatsPerDay() {
		return buildFatsPerDay;
	}

	public void setBuildFatsPerDay(double buildFatsPerDay) {
		this.buildFatsPerDay = buildFatsPerDay;
	}

	public double getBuildCarbsPerDay() {
		return buildCarbsPerDay;
	}

	public void setBuildCarbsPerDay(double buildCarbsPerDay) {
		this.buildCarbsPerDay = buildCarbsPerDay;
	}

	@Override
	public String toString() {
		return "BuildProgram [buildUser=" + buildUser + ", actualWeight=" + actualWeight + ", buildKcal=" + buildKcal
				+ ", buildProtPerDay=" + buildProtPerDay + ", buildFatsPerDay=" + buildFatsPerDay
				+ ", buildCarbsPerDay=" + buildCarbsPerDay + "]";
	}

	public BuildProgram(Long idBuild, User buildUser, double actualWeight, double buildKcal, double buildProtPerDay,
			double buildFatsPerDay, double buildCarbsPerDay, List<Food> buildFood) {
		super();
		this.idBuild = idBuild;
		this.buildUser = buildUser;
		this.actualWeight = actualWeight;
		this.buildKcal = buildKcal;
		this.buildProtPerDay = buildProtPerDay;
		this.buildFatsPerDay = buildFatsPerDay;
		this.buildCarbsPerDay = buildCarbsPerDay;
		this.buildFood = buildFood;
	}

	public BuildProgram() {
		super();
	}

	public List<Food> getBuildFood() {
		return buildFood;
	}

	public void setBuildFood(List<Food> buildFood) {
		this.buildFood = buildFood;
	}

}
