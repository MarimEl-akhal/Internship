package org.example.controller;

import jakarta.validation.Valid;
import org.example.dto.TaskDto;
import org.example.entity.Task;
import org.example.enumClass.Status;
import org.example.mapper.TaskMapper;
import org.example.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService taskService;
    private final TaskMapper  taskMapper;

    @Autowired
    public TaskController(TaskService taskService , TaskMapper  taskMapper) {
        this.taskService = taskService;
        this.taskMapper = taskMapper;

    }

    private String getAuthenticatedUsername() {
        return SecurityContextHolder.getContext().getAuthentication().getName();
    }

//    @PostMapping("/create")
//    public ResponseEntity<TaskDto> createTask(@Valid @RequestBody TaskDto taskDTO) {
//        String username = getAuthenticatedUsername();
//        Task task = taskService.createTask(taskDTO, username);
//        return ResponseEntity.status(HttpStatus.CREATED).body(taskMapper.toDto(task));
//    }


//
//    @PostMapping("/create")
//    public ResponseEntity<?> createTask(@Valid @RequestBody TaskDto taskDTO, BindingResult result) {
//        if (result.hasErrors()) {
//            return ResponseEntity.badRequest().body(result.getAllErrors());
//        }
//        String username = getAuthenticatedUsername();
//        TaskDto createdTask = taskService.createTask(taskDTO, username);
//        return ResponseEntity.status(HttpStatus.CREATED).body(createdTask);
//    }
@PostMapping("/create")
public ResponseEntity<?> createTask(@Valid @RequestBody TaskDto taskDTO, BindingResult result) {
    if (result.hasErrors()) {
        return ResponseEntity.badRequest().body(result.getAllErrors());
    }
    try {
        String username = getAuthenticatedUsername();
        TaskDto createdTask = taskService.createTask(taskDTO, username);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdTask);
    } catch (Exception e) {
        e.printStackTrace(); // or log.error(...)
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
    }
}




    @GetMapping
    public ResponseEntity<List<TaskDto>> getAllTasks() {
        String username = getAuthenticatedUsername();
        return ResponseEntity.ok(taskService.getAllTasks(username));
    }


    @GetMapping("/filter")
    public ResponseEntity<List<TaskDto>> getTasks(@RequestParam(required = false) Status status,
                                                  @RequestParam(required = false) String title) {
        String username = getAuthenticatedUsername();
        List<TaskDto> tasks = (status != null) ? taskService.getTasksByStatus(username, status) :
                (title != null) ? taskService.getTasksByTitle(username, title) :
                        taskService.getAllTasks(username);
        return ResponseEntity.ok(tasks);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<TaskDto> updateTask(@PathVariable Long id, @Valid @RequestBody TaskDto updatedTask) {
        String username = getAuthenticatedUsername();
        TaskDto taskDto = taskService.updateTask(id, updatedTask, username);
        return ResponseEntity.ok(taskDto);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id) {
        String username = getAuthenticatedUsername();
        taskService.deleteTask(id, username);
        return ResponseEntity.ok().build();
    }
}





























//package org.example.controller;
//
//import io.swagger.v3.oas.annotations.Operation;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.validation.Valid;
//import org.example.dto.TaskDto;
//import org.example.entity.Task;
//import org.example.entity.User;
//import org.example.enumClass.Status;
//import org.example.repository.TaskRepositry;
//import org.example.service.TaskService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/tasks")
//public class TaskController {
//
//    private final TaskService taskService;
//    private final TaskRepositry taskRepositry;
//
//    @Autowired
//    public TaskController(TaskService taskService, TaskRepositry taskRepositry) {
//        this.taskService = taskService;
//        this.taskRepositry = taskRepositry;
//    }
//
//    // Helper method to get current authenticated username
//    private String getAuthenticatedUsername() {
//        return SecurityContextHolder.getContext().getAuthentication().getName();
//    }
//
//    /**
//     * Create a new task for the authenticated user
//     */
//    @Operation(summary = "Create a new task")
//    @PostMapping("/create")
//    public ResponseEntity<Task> createTask(@RequestBody TaskDto taskDTO) {
//        String username = getAuthenticatedUsername();
//        Task task = taskService.createTask(taskDTO, username);
//        return ResponseEntity.status(HttpStatus.CREATED).body(task);
//    }
//
//    /**
//     * Filter tasks by status or title for the authenticated user
//     */
//    @GetMapping("/filter")
//    public List<TaskDto> getTasks(@RequestParam(required = false) Status status,
//                                  @RequestParam(required = false) String title) {
//        String username = getAuthenticatedUsername();
//        if (status != null) {
//            return taskService.getTasksByStatus(username, status);
//        } else if (title != null) {
//            return taskService.getTasksByTitle(username, title);
//        } else {
//            return taskService.getAllTasks(username);
//        }
//    }
//
//    /**
//     * Update a task by ID for the authenticated user
//     */
//    @PutMapping("/update/{id}")
//    public ResponseEntity<TaskDto> updateTask(@PathVariable Long id, @RequestBody TaskDto updatedTask) {
//        String username = getAuthenticatedUsername();
//        try {
//            TaskDto taskDto = taskService.updateTask(id, updatedTask, username);
//            return ResponseEntity.ok(taskDto);
//        } catch (RuntimeException e) {
//            return ResponseEntity.notFound().build();
//        }
//    }
//
//    /**
//     * Delete a task by ID for the authenticated user
//     */
//    @DeleteMapping("/delete/{id}")
//    public ResponseEntity<Void> deleteTask(@PathVariable Long id) {
//        String username = getAuthenticatedUsername();
//        try {
//            taskService.deleteTask(id, username);
//            return ResponseEntity.ok().build();
//        } catch (RuntimeException e) {
//            return ResponseEntity.notFound().build();
//        }
//    }
//}
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
////package org.example.controller;
////
////
////import io.swagger.v3.oas.annotations.Operation;
////import jakarta.servlet.http.HttpServletRequest;
////import jakarta.validation.Valid;
////import org.example.dto.TaskDto;
////import org.example.entity.Task;
////import org.example.entity.User;
////import org.example.enumClass.Status;
////import org.example.repository.TaskRepositry;
////import org.example.service.TaskService;
////import org.example.service.UserService;
////import org.springframework.beans.factory.annotation.Autowired;
////import org.springframework.http.HttpStatus;
////import org.springframework.http.ResponseEntity;
////import org.springframework.security.core.context.SecurityContextHolder;
////import org.springframework.validation.BindingResult;
////import org.springframework.web.bind.annotation.*;
////
////import java.util.ArrayList;
////import java.util.List;
////
////@RestController
////@RequestMapping("/tasks")
////public class TaskController {
////
////    private TaskService taskService;
////    private TaskRepositry taskRepositry;
////    private List<TaskDto> taskList = new ArrayList<>();
////
////    private String currentUsername() {
////        return SecurityContextHolder.getContext().getAuthentication().getName();
////    }
////
////
////    @Autowired
////    public TaskController( TaskService taskService ,  TaskRepositry taskRepositry ) {
////        this.taskService = taskService;
////        this.taskRepositry = taskRepositry;
////    }
////
////
////
////    private User getAuthenticatedUser(HttpServletRequest request) {
////        return (User) request.getAttribute("authenticatedUser");
////    }
////
////    /**
////     * Create a new task
////     */
////    @Operation(summary = "Create a new task")
////    @PostMapping("/create")
////    public ResponseEntity<Task> createTask(@RequestBody TaskDto taskDTO, HttpServletRequest request) {
////        User user = getAuthenticatedUser(request);
////        Task task = new Task();
////        task.setTitle(taskDTO.getTitle());
////        task.setDescription(taskDTO.getDescription());
////        task.setStatus(taskDTO.getStatus());
////        task.setDueDate(taskDTO.getDueDate());
////        task.setUser(user);
////        taskRepositry.save(task);
////        return ResponseEntity.status(HttpStatus.CREATED).body(task);
////    }
////
////
////
//////
//////    @PostMapping("/create")
//////    public ResponseEntity<TaskDto> createTask(@RequestBody TaskDto taskDto) {
//////        TaskDto createdTask = taskService.createTask(taskDto);
//////        return ResponseEntity.ok(createdTask);
//////    }
//////@PostMapping("/create")
//////public ResponseEntity<TaskDto> createTask(@Valid @RequestBody TaskDto taskDto) {
//////    TaskDto createdTask = taskService.createTask(taskDto);
//////    return ResponseEntity.status(HttpStatus.CREATED).body(createdTask);
//////
//////}
////    @GetMapping("/filter")
////    public List<TaskDto> getTasks(@RequestParam(required = false) Status status, @RequestParam(required = false) String title) {
////        if (status != null) {
////            return taskService.getTasksByStatus(status);
////        } else if (title != null) {
////            return taskService.getTasksByTitle(title);
////        } else {
////            return taskService.getAllTasks();
////        }
////    }
////
////    @PutMapping("/update/{id}")
////    public ResponseEntity <TaskDto> updateTask(@PathVariable Long id, @RequestBody TaskDto updatedTask) {
////        try {
////            TaskDto taskDto = taskService.updateTask(id, updatedTask);
////            return ResponseEntity.ok(taskDto);
////        } catch (RuntimeException e) {
////            return ResponseEntity.notFound().build();
////        }
////    }
////
////    @DeleteMapping("/delete/{id}")
////    public ResponseEntity<Void> deleteTask(@PathVariable Long id) {
////        taskService.deleteTask(id);
////        return ResponseEntity.ok().build();
////    }
////
////}
