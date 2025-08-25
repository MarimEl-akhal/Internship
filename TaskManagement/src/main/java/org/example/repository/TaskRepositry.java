package org.example.repository;

import org.example.entity.Task;
import org.example.entity.User;
import org.example.enumClass.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TaskRepositry extends JpaRepository<Task,Long> {

//    List<Task> findByUserName(String username, Status status);
//    List<Task> findByUserAndTitle(String username, String title);
    List<Task> findByStatus(String status);
    List<Task> findByTitleContainingIgnoreCase(String title);
//    Optional<Task> findByUserAndId(String username, Long id);


         List<Task> findByUser(User user);
        List<Task> findByUserAndStatus(User user, Status status);
        List<Task> findByUserAndTitleContainingIgnoreCase(User user, String title);
        Optional<Task> findByIdAndUser(Long id, User user);


}

