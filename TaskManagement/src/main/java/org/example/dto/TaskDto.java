package org.example.dto;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;
import org.example.enumClass.Status;

import java.time.LocalDate;

@Data
public class TaskDto {

private Long id;
private String title;
private String description;
@Enumerated(EnumType.STRING)
private Status status;
private LocalDate dueDate;

}
