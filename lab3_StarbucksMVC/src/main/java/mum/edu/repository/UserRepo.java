package mum.edu.repository;

import mum.edu.domain.User;

import java.util.List;

public interface UserRepo {
    public User findByName(String name);
    public List<User> getAll();

}
