package edu.mum.cs.lab10ormassignment.domain;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;


@Entity
@Data
@NoArgsConstructor
public class Employee {
    @Id
    @GeneratedValue
    private Long id;
    @NotEmpty
    @Column(name = "F_Name")
    private String firstName;
    @NotEmpty
    @Column(name = "L_Name")
    private String lastName;
    @NotEmpty
    private String phone;

    @Valid
    @OneToOne(cascade = CascadeType.ALL)
    private Address address;

    public Employee(String firstName, String lastName,String phone,Address address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.address = address;
    }
}
