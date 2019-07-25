package mum.edu.repository;

import mum.edu.data.Database;
import mum.edu.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Repository
public class AdviceRepoImpl implements AdviceRepo {
    @Autowired
    Database database;

    @Override
    public List<String> getListByType(String type) {
        return database.advice.get(type);
    }

    @Override
    public Map<Integer, String> getAllRoast() {
        return database.roasts;
    }

    @Override
    public String getRoast(Integer k) {
        return database.roasts.get(k);
    }
}
