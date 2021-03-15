package id.co.bmri.induction.client.department.service.impl;

import id.co.bmri.induction.client.department.model.entity.Department;
import id.co.bmri.induction.client.department.repository.DepartmentRepository;
import id.co.bmri.induction.client.department.service.DepartmentService;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    private DepartmentRepository departmentRepository;

    public DepartmentServiceImpl(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @Override
    public List<Department> findAllDepartment() {
        return departmentRepository.findAll();
    }
}
