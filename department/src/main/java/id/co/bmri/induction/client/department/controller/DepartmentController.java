package id.co.bmri.induction.client.department.controller;

import id.co.bmri.induction.client.department.model.entity.Department;
import id.co.bmri.induction.client.department.service.DepartmentService;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("departments")
@EnableDiscoveryClient
public class DepartmentController {

    private DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("/halo")
    public String halo (){
        return "Halo ini dari Client Department";
    }

    @GetMapping
    public List<Department> findAllDepartment() {
        return departmentService.findAllDepartment();
    }
}
