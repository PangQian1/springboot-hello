package mock;

import mock.User1;
import org.springframework.stereotype.Component;

@Component
public abstract class UserDao {

    public abstract User1 getUserById(Integer id);

    public abstract Integer insertUser(User1 user);
}
