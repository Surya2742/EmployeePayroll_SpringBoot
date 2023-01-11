package com.project.employeepayroll.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.sql.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String name;
    @Column(name = "profile_image")
    private String profileImage;
    @Column
    private String gender;
    @Column
    private String department;
    @Column
    private Long salary;
    @Column(name = "start_date")
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date startDate;
    @Column
    private String notes;


}
