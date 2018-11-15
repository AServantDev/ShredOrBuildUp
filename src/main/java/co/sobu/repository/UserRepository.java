package co.sobu.repository;

import java.util.Optional;

import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import co.sobu.model.User;


public interface UserRepository extends JpaRepository<User, Long>{

	
	 User findUserById(Long id);
	
}
