package com.gowtham.taskmanager.controller;

import com.gowtham.taskmanager.entity.Task;
import com.gowtham.taskmanager.service.TaskService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/tasks")
@CrossOrigin(origins = "*")
public class TaskController {

    private final TaskService service;

    public TaskController(TaskService service) {
        this.service = service;
    }

    // ✅ CREATE TASK
    @PostMapping
    public Task createTask(@RequestBody Task task) {
        task.setStatus("PENDING");
        return service.addTask(task);
    }

    // ✅ GET ACTIVE TASKS
    @GetMapping
    public List<Task> getTasks() {
        return service.getAllTasks();
    }

    // ✅ GET DELETED TASKS
    @GetMapping("/deleted")
    public List<Task> getDeletedTasks() {
        return service.getDeletedTasks();
    }

    // ✅ UPDATE STATUS
    @PutMapping("/{id}/status")
    public Task updateStatus(
            @PathVariable Long id,
            @RequestBody Map<String, String> body
    ) {
        String status = body.get("status");
        return service.updateTaskStatus(id, status);
    }
    // ✅ UPDATE TASK TITLE
    @PutMapping("/{id}")
    public Task updateTask(
            @PathVariable Long id,
            @RequestBody Map<String, String> body
    ) {
        String title = body.get("title");
        return service.updateTaskTitle(id, title);
    }


    // ✅ SOFT DELETE
    @DeleteMapping("/{id}")
    public String deleteTask(@PathVariable Long id) {
        service.deleteTask(id);
        return "Task moved to trash";
    }

    // ✅ RESTORE TASK
    @PutMapping("/{id}/restore")
    public Task restoreTask(@PathVariable Long id) {
        return service.restoreTask(id);
    }
}
