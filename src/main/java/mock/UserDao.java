package mock;

import mock.User1;
import org.springframework.stereotype.Component;

@Component
public class UserDao {

    public User1 getUserById(Integer id) {
        return new User1(9,"pangian");
    }

    public Integer insertUser(User1 user) {
        return 1;
    }
}
