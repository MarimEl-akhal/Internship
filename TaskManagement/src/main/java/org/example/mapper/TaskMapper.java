// TaskMapper.java
package org.example.mapper;

import org.example.dto.TaskDto;
import org.example.enumClass.Status;
import org.example.entity.Task;
import org.springframework.stereotype.Component;

@Component
public class TaskMapper {
    public TaskDto toDto(Task task) {
        TaskDto dto = new TaskDto();
        dto.setId(task.getId());
        dto.setTitle(task.getTitle());
        dto.setDescription(task.getDescription());
        dto.setStatus(Status.valueOf(task.getStatus().name()));
        dto.setDueDate(task.getDueDate());
        return dto;
    }

    public Task toEntity(TaskDto dto) {
        Task task = new Task();
        task.setTitle(dto.getTitle());
        task.setDescription(dto.getDescription());
        task.setStatus(Status.valueOf(String.valueOf(dto.getStatus())));
        task.setDueDate(dto.getDueDate());
        return task;
    }



}
