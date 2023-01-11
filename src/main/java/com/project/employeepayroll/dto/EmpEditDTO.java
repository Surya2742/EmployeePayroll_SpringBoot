package com.project.employeepayroll.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import java.sql.Date;
@Data
public class EmpEditDTO {
    private Long id;
    private String name;
    private String profileImage;
    private String gender;
    private String department;
    private Long salary;
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date startDate;
    private String notes;
}
