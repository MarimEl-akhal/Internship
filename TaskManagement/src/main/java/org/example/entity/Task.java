package org.example.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.enumClass.Status;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tasks")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(length = 50, nullable = false)
    private String title;
    @Column(length = 1000, nullable = false)
    private String description;

    @Enumerated(EnumType.STRING)
    private Status status;
    @JsonFormat(pattern = "yyyy-mm-dd")
    private LocalDate dueDate;



    @ManyToOne
    @JoinColumn(name = "user_id" , nullable = false)
    private User user;





}
