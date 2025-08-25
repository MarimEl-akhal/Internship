package org.example.service;

import org.example.dto.TaskDto;
import org.example.enumClass.Status;

import java.util.List;
import java.util.Optional;

/**
 * Service interface for managing tasks.
 */
public interface TaskService {

    /**
     * Creates a new task for a specific user.
     *
     * @param taskDTO  Data transfer object containing task details.
     * @param username Username of the user creating the task.
     * @return Created TaskDto object.
     */
    TaskDto createTask(TaskDto taskDTO, String username);

    /**
     * Retrieves all tasks belonging to a specific user.
     *
     * @param username Username of the user.
     * @return List of TaskDto objects.
     */
    List<TaskDto> getAllTasks(String username);

    /**
     * Retrieves tasks filtered by status for a specific user.
     *
     * @param username Username of the user.
     * @param status   Status filter (e.g., To-Do, In Progress, Completed).
     * @return List of TaskDto objects.
     */
    List<TaskDto> getTasksByStatus(String username, Status status);

    /**
     * Retrieves tasks filtered by title for a specific user.
     *
     * @param username Username of the user.
     * @param title    Title filter (partial or full).
     * @return List of TaskDto objects.
     */
    List<TaskDto> getTasksByTitle(String username, String title);

    /**
     * Retrieves a task by its ID for a specific user.
     *
     * @param taskId   ID of the task.
     * @param username Username of the user requesting the task.
     * @return Optional containing the TaskDto if found.
     */
    Optional<TaskDto> getTaskById(Long taskId, String username);

    /**
     * Updates a task by its ID for a specific user.
     *
     * @param taskId   ID of the task.
     * @param taskDTO  Updated task data.
     * @param username Username of the user performing the update.
     * @return Updated TaskDto.
     */
    TaskDto updateTask(Long taskId, TaskDto taskDTO, String username);

    /**
     * Deletes a task by its ID for a specific user.
     *
     * @param taskId   ID of the task.
     * @param username Username of the user requesting deletion.
     */
    void deleteTask(Long taskId, String username);
}



















//package org.example.service;
//
//import org.example.dto.TaskDto;
//import org.example.entity.Task;
//
//import java.util.List;
//import java.util.Optional;
//
//public interface TaskService {
//
//    TaskDto createTask(TaskDto taskDTO);
//    List<TaskDto> getAllTasks();
//    List<TaskDto> getTasksByStatus(String status);
//    List<TaskDto> getTasksByTitle(String title);
//    Optional<TaskDto> getTaskById(Long id);
//    TaskDto updateTask(Long id, TaskDto taskDTO);
//    void deleteTask(Long id);
//
//
//}
//
///*    TaskDTO createTask(TaskDTO taskDTO);
//    List<TaskDTO> getAllTasks();
//    List<TaskDTO> getTasksByStatus(String status);
//    List<TaskDTO> getTasksByTitle(String title);
//    Optional<TaskDTO> getTaskById(Long id);
//    TaskDTO updateTask(Long id, TaskDTO taskDTO);
//    void deleteTask(Long id);
//
//    TaskDto createTask(TaskDto dto, String username);
//
//    List<TaskDto> getTasks (String usernam, Status status, String title);
//    TaskDto getTask(Long taskId);
//
//    TaskDto updateTask(Long taskId, TaskDto dto, User user);
//    void deleteTask(Long taskId, User user);
//
//* */
//
//
//
//
//
//
