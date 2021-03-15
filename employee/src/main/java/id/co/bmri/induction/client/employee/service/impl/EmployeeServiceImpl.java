package id.co.bmri.induction.client.employee.service.impl;

import id.co.bmri.induction.client.employee.model.entity.Employee;
import id.co.bmri.induction.client.employee.repository.EmployeeRepository;
import id.co.bmri.induction.client.employee.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> findAllEmployee() {
        return employeeRepository.findAll();
    }
}
