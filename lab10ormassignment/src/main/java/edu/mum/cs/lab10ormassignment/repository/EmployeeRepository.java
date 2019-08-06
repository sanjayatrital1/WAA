package edu.mum.cs.lab10ormassignment.repository;

import edu.mum.cs.lab10ormassignment.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {
    @Query(value = "select e from Employee e where e.phone= :phone")
    List<Employee> locateOneEmployeeByHisNumber(String phone);
}
