package edu.mum.cs545.lab11authentication.repository;

import edu.mum.cs545.lab11authentication.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {
    @Query(value = "select e from Employee e where e.phone= :phone")
    List<Employee> locateOneEmployeeByHisNumber(String phone);
}
