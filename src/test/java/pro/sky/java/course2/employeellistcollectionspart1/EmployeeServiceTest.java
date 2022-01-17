package pro.sky.java.course2.employeellistcollectionspart1;

import org.apache.commons.collections4.CollectionUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pro.sky.java.course2.employeellistcollectionspart1.data.Employee;
import pro.sky.java.course2.employeellistcollectionspart1.service.EmployeeService;
import pro.sky.java.course2.employeellistcollectionspart1.service.EmployeeServiceImpl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class EmployeeServiceTest {

    private Employee employee1;
    private Employee employee2;
    private Employee employee3;
    private EmployeeService out;

    @BeforeEach
    public void setUp() {
        employee1 = new Employee("Ivan", "Ivanov", 1, 50000);
        employee2 = new Employee("Zoya", "Zoykina", 2, 60000);
        employee3 = new Employee("Petya", "Petrovich", 1, 70000);

        out = new EmployeeServiceImpl();

        out.addEmployee(employee1);
        out.addEmployee(employee2);
        out.addEmployee(employee3);
    }

    @Test
    public void addEmployeeTest() {

        Collection<Employee> expected = out.getAllEmployees();
        Collection<Employee> actual = new ArrayList<>();

        actual.add(employee1);
        actual.add(employee2);
        actual.add(employee3);

        assertTrue(CollectionUtils.isEqualCollection(expected, actual));
    }

    @Test
    public void addEmployeeTestIfEmployeeAlreadyExist() {
        assertThrows(IllegalArgumentException.class, () -> out.getAllEmployees());
    }


    @Test
    public void removeEmployeeTest() {
        Collection<Employee> expected = out.getAllEmployees();

        expected.remove(employee3);
        assertFalse (expected.contains(employee3));

    }
}
