package co.innovaciones.bflow_server.rest

import co.innovaciones.bflow_server.model.TaskDTO
import co.innovaciones.bflow_server.service.TaskService
import io.swagger.v3.oas.annotations.responses.ApiResponse
import jakarta.validation.Valid
import java.lang.Void
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping(
    value = ["/api/tasks"],
    produces = [MediaType.APPLICATION_JSON_VALUE]
)
class TaskResource(
    private val taskService: TaskService
) {

    @GetMapping
    fun getAllTasks(): ResponseEntity<List<TaskDTO>> = ResponseEntity.ok(taskService.findAll())

    @GetMapping("/{id}")
    fun getTask(@PathVariable(name = "id") id: Long): ResponseEntity<TaskDTO> =
            ResponseEntity.ok(taskService.get(id))

    @PostMapping
    @ApiResponse(responseCode = "201")
    fun createTask(@RequestBody @Valid taskDTO: TaskDTO): ResponseEntity<Long> {
        val createdId = taskService.create(taskDTO)
        return ResponseEntity(createdId, HttpStatus.CREATED)
    }

    @PutMapping("/{id}")
    fun updateTask(@PathVariable(name = "id") id: Long, @RequestBody @Valid taskDTO: TaskDTO):
            ResponseEntity<Long> {
        taskService.update(id, taskDTO)
        return ResponseEntity.ok(id)
    }

    @DeleteMapping("/{id}")
    @ApiResponse(responseCode = "204")
    fun deleteTask(@PathVariable(name = "id") id: Long): ResponseEntity<Void> {
        taskService.delete(id)
        return ResponseEntity.noContent().build()
    }

}
