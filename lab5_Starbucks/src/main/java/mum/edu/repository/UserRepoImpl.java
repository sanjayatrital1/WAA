package mum.edu.repository;

import mum.edu.data.Database;
import mum.edu.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Repository
public class UserRepoImpl implements UserRepo {
    @Autowired
    private Database database;

    @Override
    public User findByName(String name) {
        User user = database.users.get(name);
        return user;
    }

    @Override
    public List<User> getAll() {
        return (List<User>) database.users.values();
    }
}
