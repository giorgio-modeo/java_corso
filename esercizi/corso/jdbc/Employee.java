package jdbc;

import java.time.LocalDate;

import lombok.*;
@Getter @Setter @ToString @EqualsAndHashCode
public class Employee {
    private int id;
    private String firstname;
    private String lastname;
    private LocalDate dob;
    private LocalDate hireDate;
    private String description;


    public Employee(int id, String firstname, String lastname, LocalDate dob, LocalDate hire_date, String description) {
    }
}
