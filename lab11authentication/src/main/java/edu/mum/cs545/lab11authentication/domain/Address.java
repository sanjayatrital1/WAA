package edu.mum.cs545.lab11authentication.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Entity
@Data
@NoArgsConstructor
public class Address {

    @Id
    @GeneratedValue
    private Long id;
    private String street;
    private String city;
    @Column(name = "zipCode")
    private String zip;

    @OneToOne(mappedBy = "address", cascade = CascadeType.ALL)
    private Employee employee;

}
