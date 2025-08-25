package org.example.service;

import org.example.dto.TaskDto;
import org.example.entity.Task;
import org.example.entity.User;
import org.example.enumClass.Status;

import org.example.mapper.TaskMapper;
import org.example.repository.TaskRepositry;
import org.example.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskServiceImpl implements TaskService {

        private final TaskRepositry taskRepository;
        private final TaskMapper taskMapper;
        private final UserRepository userRepository;

        @Autowired
        public TaskServiceImpl(TaskRepositry taskRepository, TaskMapper taskMapper, UserRepository userRepository) {
            this.taskRepository = taskRepository;
            this.taskMapper = taskMapper;
            this.userRepository = userRepository;
        }

        @Override
        public TaskDto createTask(TaskDto taskDTO, String username) {
            User user = userRepository.findByUsername(username)
                    .orElseThrow(() -> new RuntimeException("User not found"));
            Task task = taskMapper.toEntity(taskDTO);
            task.setUser(user);
            Task savedTask = taskRepository.save(task);
            return taskMapper.toDto(savedTask);
        }

        @Override
        public List<TaskDto> getAllTasks(String username) {
            User user = userRepository.findByUsername(username)
                    .orElseThrow(() -> new RuntimeException("User not found"));
            List<Task> tasks = taskRepository.findByUser(user);
            return tasks.stream().map(taskMapper::toDto).toList();
        }

        @Override
        public List<TaskDto> getTasksByStatus(String username, Status status) {
            User user = userRepository.findByUsername(username)
                    .orElseThrow(() -> new RuntimeException("User not found"));
            List<Task> tasks = taskRepository.findByUserAndStatus(user, status);
            return tasks.stream().map(taskMapper::toDto).toList();
        }

        @Override
        public List<TaskDto> getTasksByTitle(String username, String title) {
            User user = userRepository.findByUsername(username)
                    .orElseThrow(() -> new RuntimeException("User not found"));
            List<Task> tasks = taskRepository.findByUserAndTitleContainingIgnoreCase(user, title);
            return tasks.stream().map(taskMapper::toDto).toList();
        }

        @Override
        public Optional<TaskDto> getTaskById(Long taskId, String username) {
            Optional<Task> taskOpt = taskRepository.findById(taskId);
            if (taskOpt.isPresent() && taskOpt.get().getUser().getUsername().equals(username)) {
                return Optional.of(taskMapper.toDto(taskOpt.get()));
            }
            return Optional.empty();
        }

        @Override
        public TaskDto updateTask(Long taskId, TaskDto taskDTO, String username) {
            Task task = taskRepository.findById(taskId)
                    .orElseThrow(() -> new RuntimeException("Task not found"));

            if (!task.getUser().getUsername().equals(username)) {
                throw new UnauthorizedException("You are not authorized to update this task");
            }

            task.setTitle(taskDTO.getTitle());
            task.setDescription(taskDTO.getDescription());
            task.setStatus(taskDTO.getStatus());
            task.setDueDate(taskDTO.getDueDate());

            Task updatedTask = taskRepository.save(task);
            return taskMapper.toDto(updatedTask);
        }

        @Override
        public void deleteTask(Long taskId, String username) {
            Task task = taskRepository.findById(taskId)
                    .orElseThrow(() -> new RuntimeException("Task not found"));

            if (!task.getUser().getUsername().equals(username)) {
                throw new UnauthorizedException("You are not authorized to delete this task");
            }

            taskRepository.delete(task);
        }

    }



//
//    private final TaskRepositry taskRepository;
//    private final TaskMapper taskMapper;
//    private final UserRepository userRepository;
//
//    @Autowired
//    public TaskServiceImpl(TaskRepositry taskRepository, TaskMapper taskMapper, UserRepository userRepository) {
//        this.taskRepository = taskRepository;
//        this.taskMapper = taskMapper;
//        this.userRepository = userRepository;
//    }
//
//    // Create task for specific user
//    @Override
//    public org.springframework.scheduling.config.Task createTask(TaskDto taskDTO, String username) {
//        User user = userRepository.findByUsername(username)
//                .orElseThrow(() -> new RuntimeException("User not found"));
//        Task task = taskMapper.toEntity(taskDTO);
//        task.setUser(user);
//        Task savedTask = taskRepository.save(task);
//        return taskMapper.toDto(savedTask);
//    }
//
//    // Get all tasks for a specific user
//    @Override
//    public List<TaskDto> getAllTasks(String username) {
//        User user = userRepository.findByUsername(username)
//                .orElseThrow(() -> new RuntimeException("User not found"));
//        List<Task> tasks = taskRepository.findByUser(user);
//        return tasks.stream().map(taskMapper::toDto).toList();
//    }
//
//    @Override
//    public List<TaskDto> getTasksByStatus(String username, Status status) {
//        User user = userRepository.findByUsername(username)
//                .orElseThrow(() -> new RuntimeException("User not found"));
//        List<Task> tasks = taskRepository.findByUserAndStatus(user, status);
//        return tasks.stream().map(taskMapper::toDto).toList();
//    }
//
//    @Override
//    public List<TaskDto> getTasksByTitle(String username, String title) {
//        User user = userRepository.findByUsername(username)
//                .orElseThrow(() -> new RuntimeException("User not found"));
//        List<Task> tasks = taskRepository.findByUserAndTitleContainingIgnoreCase(user, title);
//        return tasks.stream().map(taskMapper::toDto).toList();
//    }
//
//    // Get a specific task by ID for a user
//    @Override
//    public Optional<TaskDto> getTaskById(Long taskId, String username) {
//        Optional<Task> taskOpt = taskRepository.findById(taskId);
//        if (taskOpt.isPresent() && taskOpt.get().getUser().getUsername().equals(username)) {
//            return Optional.of(taskMapper.toDto(taskOpt.get()));
//        }
//        return Optional.empty(); // or throw exception if preferred
//    }
//
//    // Update a task only if it belongs to the user
//    @Override
//    public TaskDto updateTask(Long taskId, TaskDto taskDTO, String username) {
//        Optional<Task> taskOpt = taskRepository.findById(taskId);
//        if (taskOpt.isEmpty() || !taskOpt.get().getUser().getUsername().equals(username)) {
//            throw new UnauthorizedException("You are not authorized to update this task");
//        }
//        Task task = taskOpt.get();
//        task.setTitle(taskDTO.getTitle());
//        task.setDescription(taskDTO.getDescription());
//        task.setStatus(taskDTO.getStatus());
//        task.setDueDate(taskDTO.getDueDate());
//        Task savedTask = taskRepository.save(task);
//        return taskMapper.toDto(savedTask);
//    }
//
//    // Delete a task only if it belongs to the user
//    @Override
//    public void deleteTask(Long taskId, String username) {
//        Optional<Task> taskOpt = taskRepository.findById(taskId);
//        if (taskOpt.isEmpty() || !taskOpt.get().getUser().getUsername().equals(username)) {
//            throw new UnauthorizedException("You are not authorized to delete this task");
//        }
//        taskRepository.delete(taskOpt.get());
//    }
//}






































//package org.example.service;
//
//
//import org.example.dto.TaskDto;
//import org.example.entity.Task;
//import org.example.repository.TaskRepositry;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.example.mapper.TaskMapper;
//
//import java.util.List;
//import java.util.Optional;
//
//@Service
//public class TaskServiceImpl implements TaskService {
//
//
//    private final TaskRepositry taskRepository;
//    private final TaskMapper taskMapper;
//
//
//    @Autowired
//    public TaskServiceImpl( TaskRepositry taskRepository, TaskMapper taskMapper) {
//        this.taskRepository = taskRepository;
//        this.taskMapper = taskMapper;
//
//    }
//
//
//
//    @Override
//    public TaskDto createTask(TaskDto taskDTO) {
//        Task task = taskMapper.toEntity(taskDTO);
//        Task savedTask = taskRepository.save(task);
//        return taskMapper.toDto(savedTask);
//    }
//
//    @Override
//    public List<TaskDto> getAllTasks() {
//        List<Task> tasks = taskRepository.findAll();
//        return tasks.stream().map(taskMapper::toDto).toList();
//    }
//
//    @Override
//    public List<TaskDto> getTasksByStatus(String status) {
//        List<Task> tasks = taskRepository.findByStatus(status);
//        return tasks.stream().map(taskMapper::toDto).toList();
//    }
//
//    @Override
//    public List<TaskDto> getTasksByTitle(String title) {
//        List<Task> tasks = taskRepository.findByTitleContainingIgnoreCase(title);
//        return tasks.stream().map(taskMapper::toDto).toList();
//    }
//
//    @Override
//    public Optional<TaskDto> getTaskById(Long id) {
//        return taskRepository.findById(id).map(taskMapper::toDto);
//    }
//
//    @Override
//    public TaskDto updateTask(Long id, TaskDto updatedTaskDTO) {
//        Task updatedTask = taskMapper.toEntity(updatedTaskDTO);
//        return taskRepository.findById(id).map(task -> {  // <-- rename taskDto to task here!
//            task.setTitle(updatedTask.getTitle());
//            task.setDescription(updatedTask.getDescription());
//            task.setStatus(updatedTask.getStatus());
//            task.setDueDate(updatedTask.getDueDate());
//            Task saved = taskRepository.save(task);
//            return taskMapper.toDto(saved);
//        }).orElseThrow(() -> new RuntimeException("Task not found with id " + id));
//    }
//
//
//    @Override
//    public void deleteTask(Long id) {
//        taskRepository.findById(id).ifPresent(taskRepository::delete);
//    }
////
////todo :@Override
////    public TaskDto createTask(TaskDto dto, User user) {
////
////    }
////
////    @Override
////    public List<TaskDto> getTasks(User user, Status status, String title) {
////        List<Task> tasks;
////        if (status != null) {
////            tasks = taskRepository.findByUserAndStatus(user, status);
////        } else if (title != null) {
////            tasks = taskRepository.findByUserAndTitle(user, title);
////        } else {
////            tasks = taskRepository.findByUser(user);
////        }
////        return tasks.stream().toList();
////    }
////
////
////
////    @Override
////    public TaskDto updateTask(Long taskId, TaskDto dto, User user) {
////
////    }
////
////    @Override
////    public void deleteTask(Long taskId, User user) {
////
////}
//
//
//
//}