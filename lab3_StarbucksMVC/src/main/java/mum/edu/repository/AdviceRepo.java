package mum.edu.repository;

import java.util.List;
import java.util.Map;

public interface AdviceRepo {
    public List<String> getListByType(String type);
    public Map<Integer,String>getAllRoast();
    public String getRoast(Integer k);
}
