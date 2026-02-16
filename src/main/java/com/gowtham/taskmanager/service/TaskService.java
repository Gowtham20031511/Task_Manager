package com.gowtham.taskmanager.service;

import com.gowtham.taskmanager.entity.Task;
import com.gowtham.taskmanager.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskService {

    private final TaskRepository repository;

    public TaskService(TaskRepository repository) {
        this.repository = repository;
    }

    // ✅ CREATE TASK
    public Task addTask(Task task) {
        return repository.save(task);
    }

    // ✅ SHOW ONLY NON-DELETED TASKS
    public List<Task> getAllTasks() {
        return repository.findAll()
                .stream()
                .filter(task -> !task.getDeleted())
                .collect(Collectors.toList());
    }

    // ✅ SOFT DELETE
    public void deleteTask(Long id) {
        Task task = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Task not found"));

        task.setDeleted(true);
        repository.save(task);
    }

    // ✅ RESTORE TASK
    public Task restoreTask(Long id) {
        Task task = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Task not found"));

        task.setDeleted(false);
        return repository.save(task);
    }

    // ✅ GET ONLY DELETED TASKS
    public List<Task> getDeletedTasks() {
        return repository.findAll()
                .stream()
                .filter(Task::getDeleted)
                .collect(Collectors.toList());
    }

    // ✅ UPDATE STATUS
    public Task updateTaskStatus(Long id, String status) {
        Task task = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Task not found"));

        task.setStatus(status);
        return repository.save(task);
    }

    // ✅ UPDATE TITLE
    public Task updateTaskTitle(Long id, String title) {
        Task task = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Task not found"));

        task.setTitle(title);
        return repository.save(task);
    }
}
