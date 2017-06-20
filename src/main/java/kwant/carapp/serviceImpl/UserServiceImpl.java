package kwant.carapp.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;

import kwant.carapp.repository.UserRepository;
import kwant.carapp.service.UserService;

public class UserServiceImpl implements UserService{
	
	@Autowired
	UserRepository userRepository;

}
