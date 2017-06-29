package kwant.carapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import kwant.carapp.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	

}
  