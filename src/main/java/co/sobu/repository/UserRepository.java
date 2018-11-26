package co.sobu.repository;

import java.util.Optional;

import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import co.sobu.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

	
	 User findUserByIdUser(Long idUser);
	
}
