package id.co.bmri.induction.client.employee.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import id.co.bmri.induction.client.employee.model.entity.Employee;
import id.co.bmri.induction.client.employee.service.EmployeeService;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("employees")
@EnableDiscoveryClient
public class EmployeeController {

    private RestTemplate restTemplate;

    private EmployeeService employeeService;

    public EmployeeController(RestTemplate restTemplate, EmployeeService employeeService) {
        this.restTemplate = restTemplate;
        this.employeeService = employeeService;
    }

    @GetMapping("/halo")
    @HystrixCommand(fallbackMethod = "fallBack")
    public String halo(){
        return restTemplate.getForObject("http://department-service/departments/halo",String.class) + " salman";
    }

    @GetMapping("/get-all-department")
    @HystrixCommand(fallbackMethod = "fallBack")
    public List<Object> getAllDepartment() {
        return (List<Object>) restTemplate.getForObject("http://department-service/departments", Object.class);
    }

    @GetMapping
    public List<Employee> findAllEmployee() {
        return employeeService.findAllEmployee();
    }

    public String fallBack(Throwable hystrixCommand){
        return "Fallback Error Request";
    }
}
