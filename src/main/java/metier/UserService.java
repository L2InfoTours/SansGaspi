package metier;

import data.User;

public interface UserService {

	void save(User user);

	User findByUsername(String username);

}
