package co.sobu.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.sobu.model.User;
import co.sobu.repository.UserRepository;

@Service
public class UserServices {
	
	@Autowired
	private UserRepository userRepo;
	
	public User userMB(User user) {
		
		userRepo.save(user);
		System.out.println(user.getEmail());
		
		double protPerDay = (1.8 * user.getWeight());
		double protInKcal = protPerDay * 4;
		
		user.setProtPerDay(protPerDay);
		
		double fatPerDay= (user.getWeight());
		double fatInKcal = fatPerDay * 9;
		
		user.setFatsPerDay(fatPerDay);

		
		
		
		if(user.getGender().equals("feminin")) {
			
			//MB (Femme) = 9,740∗Poids (kg) + 172,9∗Taille (m) − 4,737∗Age (an) + 667,051
			
			double kcalPerDay = (9.740*user.getWeight()) + (172.9 * user.getHeigth()) - (4.737 * user.getAge()) + 667.051;
			user.setKcalPerDay(kcalPerDay * user.getCoefSportif());

			
		} else if(user.getGender().equals("masculin")) {
			
//			Formule améliorée de Harris et Benedict par Roza et Shizgal (1984) :
//			MB (Homme) = 13,707∗Poids (kg) + 492,3∗Taille (m)−6,673∗Age (an) + 77,607
			double kcalPerDay = (13.707*user.getWeight()) + (492.3 * user.getHeigth()) - (6.673 * user.getAge()) + 77.607;
			user.setKcalPerDay(kcalPerDay * user.getCoefSportif());
			
			
	
			
		}
		
		double carbInKcal = (user.getKcalPerDay() - (protInKcal + fatInKcal));
		double carbPerDay = carbInKcal/ 4;
		user.setCarbsPerDays(carbPerDay);
		
		return userRepo.save(user);
		
		
		
	}

}
