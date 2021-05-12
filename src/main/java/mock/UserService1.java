package mock;

import mock.User1;
import mock.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserService1 {

@Autowired
private UserDao userDao;

public User1 getUserById(Integer id) {
        return userDao.getUserById(id);
        }

public Integer insertUser(User1 user) {
        return userDao.insertUser(user);
        }
        }

