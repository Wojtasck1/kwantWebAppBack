package kwant.carapp.service;

import java.util.List;

import kwant.carapp.model.Note;
import kwant.carapp.model.User;

public interface UserService {
	
	public void delete(Long userId);

	public List<User> findAll();

	public User save(User user);

	public User findUser(Long userId);

	public User update(User user);

}
