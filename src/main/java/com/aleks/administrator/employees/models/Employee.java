package com.aleks.administrator.employees.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@AllArgsConstructor
@Data
@NoArgsConstructor
@Table(name ="employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty
    private String name;
    @NotEmpty
    private String position;
    @NotEmpty
    private String department;
    @NotEmpty
    private String updateOn;
    @NotEmpty
    private String email;
    private String db = "postgreSQL";
}
