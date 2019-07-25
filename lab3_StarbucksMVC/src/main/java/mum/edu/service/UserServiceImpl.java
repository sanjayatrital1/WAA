package mum.edu.service;

import mum.edu.domain.User;
import mum.edu.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepo userRepo;

    @Override
    public List<User> getAll() {
        return userRepo.getAll();
    }

    @Override
    public User findByName(String name) {
        return userRepo.findByName(name);
    }
}
