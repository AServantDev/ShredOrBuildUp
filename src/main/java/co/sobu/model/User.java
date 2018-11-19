package co.sobu.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "User")
public class User{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idUser;

	@JsonIgnore
	@OneToOne(mappedBy = "shredUser", cascade=CascadeType.REMOVE)
	private ShredProgram shred;

	@JsonIgnore
	@OneToOne(mappedBy = "buildUser", cascade=CascadeType.REMOVE)
	private BuildProgram build;

	@JsonIgnore
	@OneToOne(mappedBy = "cetoUser", cascade=CascadeType.REMOVE)
	private CetogeneDiet ceto;

	@JsonIgnore
	@OneToOne(mappedBy = "paleoUser", cascade=CascadeType.REMOVE)
	private PaleoDiet paleo;

	private String name;
	private String lastname;
	private int age;
	private double heigth;
	private double weight;

	@Column(unique = true)
	private String email;

	private String password;
	private double KcalPerDay;
	private double ProtPerDay;
	private double FatsPerDay;
	private double CarbsPerDays;
	private String gender;
	private double coefSportif;

	public double getCoefSportif() {
		return coefSportif;
	}

	public void setCoefSportif(double coefSportif) {
		this.coefSportif = coefSportif;
	}

	public Long getIdUser() {
		return idUser;
	}

	public void setIdUser(Long idUser) {
		this.idUser = idUser;
	}

	public ShredProgram getShred() {
		return shred;
	}

	public void setShred(ShredProgram shred) {
		this.shred = shred;
	}

	public BuildProgram getBuild() {
		return build;
	}

	public void setBuild(BuildProgram build) {
		this.build = build;
	}

	public CetogeneDiet getCeto() {
		return ceto;
	}

	public void setCeto(CetogeneDiet ceto) {
		this.ceto = ceto;
	}

	public PaleoDiet getPaleo() {
		return paleo;
	}

	public void setPaleo(PaleoDiet paleo) {
		this.paleo = paleo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getHeigth() {
		return heigth;
	}

	public void setHeigth(double heigth) {
		this.heigth = heigth;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public double getKcalPerDay() {
		return KcalPerDay;
	}

	public void setKcalPerDay(double kcalPerDay) {
		KcalPerDay = kcalPerDay;
	}

	public double getProtPerDay() {
		return ProtPerDay;
	}

	public void setProtPerDay(double protPerDay) {
		ProtPerDay = protPerDay;
	}

	public double getFatsPerDay() {
		return FatsPerDay;
	}

	public void setFatsPerDay(double fatsPerDay) {
		FatsPerDay = fatsPerDay;
	}

	public double getCarbsPerDays() {
		return CarbsPerDays;
	}

	public void setCarbsPerDays(double carbsPerDays) {
		CarbsPerDays = carbsPerDays;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public User(Long idUser, ShredProgram shred, BuildProgram build, CetogeneDiet ceto, PaleoDiet paleo, String name,
			String lastname, int age, double heigth, double weight, String email, String password, double kcalPerDay,
			double protPerDay, double fatsPerDay, double carbsPerDays, String gender, double coefSport) {
		super();
		this.idUser = idUser;
		this.shred = shred;
		this.build = build;
		this.ceto = ceto;
		this.paleo = paleo;
		this.name = name;
		this.lastname = lastname;
		this.age = age;
		this.heigth = heigth;
		this.weight = weight;
		this.email = email;
		this.password = password;
		KcalPerDay = kcalPerDay;
		ProtPerDay = protPerDay;
		FatsPerDay = fatsPerDay;
		CarbsPerDays = carbsPerDays;
		this.gender = gender;
		
	}

	public User() {
		super();
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", lastname=" + lastname + ", age=" + age + ", heigth=" + heigth + ", weight="
				+ weight + ", KcalPerDay=" + KcalPerDay + ", ProtPerDay=" + ProtPerDay + ", FatsPerDay=" + FatsPerDay
				+ ", CarbsPerDays=" + CarbsPerDays + ", gender=" + gender + "]";
	}

}
