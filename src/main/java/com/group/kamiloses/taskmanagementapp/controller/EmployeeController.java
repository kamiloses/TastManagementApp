package com.group.kamiloses.taskmanagementapp.controller;

import com.group.kamiloses.taskmanagementapp.dto.TaskDto;
import com.group.kamiloses.taskmanagementapp.repository.EmployeeRepository;
import com.group.kamiloses.taskmanagementapp.repository.TaskRepository;
import com.group.kamiloses.taskmanagementapp.service.EmployeeService;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class EmployeeController {

     private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    @QueryMapping("findAllTasks")
    //@Cacheable(value = "userTasks",key = "'allTasks'")
    public List<TaskDto> findAllTasks() {
        return employeeService.findAllTasks();
    }


    @MutationMapping("modifyTaskStatus")
   // @CachePut(value ="userTasks",key = "#id")
    public String modifyTaskStatus(@Argument Long id) {
    return employeeService.modifyTaskStatus(id);

    }



}
