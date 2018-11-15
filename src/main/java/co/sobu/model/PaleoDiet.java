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
public class PaleoDiet {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idPaleo;

	private double paleoKcal;
	private double paleoProtPerDay;
	private double paleoFatsPerDay;
	private double paleoCarbsPerDay;
	
	@OneToMany(mappedBy="foodPaleo")
	private List<Food> paleoFood;
	
	@OneToOne
	private User paleoUser;

	public Long getIdPaleo() {
		return idPaleo;
	}

	public void setIdPaleo(Long idPaleo) {
		this.idPaleo = idPaleo;
	}

	public double getPaleoKcal() {
		return paleoKcal;
	}

	public void setPaleoKcal(double paleoKcal) {
		this.paleoKcal = paleoKcal;
	}

	public double getPaleoProtPerDay() {
		return paleoProtPerDay;
	}

	public void setPaleoProtPerDay(double paleoProtPerDay) {
		this.paleoProtPerDay = paleoProtPerDay;
	}

	public double getPaleoFatsPerDay() {
		return paleoFatsPerDay;
	}

	public void setPaleoFatsPerDay(double paleoFatsPerDay) {
		this.paleoFatsPerDay = paleoFatsPerDay;
	}

	public double getPaleoCarbsPerDay() {
		return paleoCarbsPerDay;
	}

	public void setPaleoCarbsPerDay(double paleoCarbsPerDay) {
		this.paleoCarbsPerDay = paleoCarbsPerDay;
	}

	public List<Food> getPaleoFood() {
		return paleoFood;
	}

	public void setPaleoFood(List<Food> paleoFood) {
		this.paleoFood = paleoFood;
	}

	public User getPaleoUser() {
		return paleoUser;
	}

	public void setPaleoUser(User paleoUser) {
		this.paleoUser = paleoUser;
	}

	public PaleoDiet(Long idPaleo, double paleoKcal, double paleoProtPerDay, double paleoFatsPerDay,
			double paleoCarbsPerDay, List<Food> paleoFood, User paleoUser) {
		super();
		this.idPaleo = idPaleo;
		this.paleoKcal = paleoKcal;
		this.paleoProtPerDay = paleoProtPerDay;
		this.paleoFatsPerDay = paleoFatsPerDay;
		this.paleoCarbsPerDay = paleoCarbsPerDay;
		this.paleoFood = paleoFood;
		this.paleoUser = paleoUser;
	}

	public PaleoDiet() {
		super();
	}

	@Override
	public String toString() {
		return "PaleoDiet [paleoKcal=" + paleoKcal + ", paleoProtPerDay=" + paleoProtPerDay + ", paleoFatsPerDay="
				+ paleoFatsPerDay + ", paleoCarbsPerDay=" + paleoCarbsPerDay + ", paleoFood=" + paleoFood
				+ ", paleoUser=" + paleoUser + "]";
	}

}
