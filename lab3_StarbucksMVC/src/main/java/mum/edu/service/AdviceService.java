package mum.edu.service;

import java.util.List;
import java.util.Map;

public interface AdviceService {
    public List<String> getListByType(String type);
    public Map<Integer, String> getAllRoast();
    public String getRoast(Integer k);
}
