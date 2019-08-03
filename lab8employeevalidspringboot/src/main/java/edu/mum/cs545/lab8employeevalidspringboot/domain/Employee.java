package edu.mum.cs545.lab8employeevalidspringboot.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement
public class Employee {

    private static final long serialVersionUID = -908L;

    private Long id;

    @NotEmpty // any characters including "space"
//	 @NotNull
//	 @NotBlank // must have characters BESIDES "space"
    @Size(min = 4, max = 50, message = "{employee.firstname}")
    private String firstName;

    @NotEmpty(message = "aaa")
    private String lastName;

    @JsonIgnore
    private MultipartFile image;

    @DateTimeFormat(pattern = "MM-dd-yyyy")
    // @DateTimeFormat(iso = ISO.DATE) // yyyy-MM-dd
    // @DateTimeFormat(style = "L-") // July 12, 2001
    // @DateTimeFormat(pattern="hh:mm:ss")
    private LocalDate birthDate;

    // @NotEmpty //Gives NO Integer validation exception
    @NotNull
    private Integer salaryLevel;

    @Valid
    private Address address;

    @Override
    public String toString() {
        return "Employee [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", birthDate=" + birthDate
                + ", salaryLevel=" + salaryLevel + ", address=" + address + "]";
    }



}
