package mum.edu.service;

import mum.edu.repository.AdviceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class AdviceServiceImpl implements AdviceService {

    @Autowired
    private AdviceRepo adviceRepo;

    @Override
    public List<String> getListByType(String type) {
        return adviceRepo.getListByType(type);
    }

    @Override
    public Map<Integer, String> getAllRoast() {
        return adviceRepo.getAllRoast();
    }

    @Override
    public String getRoast(Integer k) {
        return adviceRepo.getRoast(k);
    }
}
