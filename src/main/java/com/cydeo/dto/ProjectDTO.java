package com.cydeo.dto;

import com.cydeo.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProjectDTO {
    private String projectName;
    private String projectCode;
    private UserDTO userDTO;
    private LocalDate startDate;
    private LocalDate endDate;
    private String projectDetail;
    private Status status;
}