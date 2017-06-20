package kwant.carapp.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kwant.carapp.model.User;
import kwant.carapp.repository.UserRepository;
import kwant.carapp.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserRepository userRepository;
 
	@Override
	public void delete(Long userId) {
		userRepository.delete(userId);
	}

	@Override
	public List<User> findAll() {
		return userRepository.findAll();
	}

	@Override
	public User save(User user) {
		return userRepository.save(user);
	}

	@Override
	public User findUser(Long userId) {
		return userRepository.findOne(userId);
	}

	@Override
	public User update(User user) {
		return userRepository.saveAndFlush(user); 
	}
}
