package mum.edu.service;

import mum.edu.domain.User;

import java.util.List;

public interface UserService {
    public List<User> getAll();
    public User findByName(String name);
}
