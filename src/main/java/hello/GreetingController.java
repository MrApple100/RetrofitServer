package hello;

import model.Employee;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class GreetingController {
    Long ids= new Long(1);
    public ArrayList<Employee> employees=new ArrayList(Arrays.asList(new  Employee(ids++,"n","r"),new  Employee(ids++,"n2","r2")));
    @PutMapping("/employees/{id}")
    public void updateEmployee(@PathVariable Long id,@RequestBody Employee employee) {
        for (Employee e : employees) {
            if(e.getId()==id){
                e.setName(employee.getName());
                e.setRole(employee.getRole());
            }
        }
    }
    @DeleteMapping("/employees/{id}")
    public void deleteEmployee(@PathVariable Long id) {
        for (Employee e : employees) {
            if(e.getId()==id){
                employees.remove(e);
            }
        }
    }
    @PostMapping("/employees")
    public void postEmployee(@RequestBody() Employee employee) {
        employees.add(employee);
    }
    @GetMapping("/employees")
    public List<Employee> getEmployee() {
        return employees;
    }
}