package databaseconnector.skillskompas.service

import databaseconnector.skillskompas.model.AddableTask
import databaseconnector.skillskompas.model.TaskRevision
import databaseconnector.skillskompas.repository.TaskRevisionRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Component

@Component
class TaskRevisionService {
    @Autowired
    lateinit var taskRevisionRepository: TaskRevisionRepository

    fun addTaskRevision(taskRevision: TaskRevision): TaskRevision{
        return taskRevisionRepository.save(taskRevision)
    }

    fun addTaskRevision(addableTask: AddableTask): TaskRevision {
        return addTaskRevision(createTaskRevisionFromAddableTask(addableTask))
    }

    fun getTaskRevision(profileTaskId: Long): ResponseEntity<TaskRevision>? {
        return taskRevisionRepository.findById(profileTaskId)
                .map {source -> ResponseEntity.ok(source)}
                .orElse(ResponseEntity.notFound().build())
    }

    fun removeTaskRevision(taskRevisionId: Long) {
        return taskRevisionRepository.deleteById(taskRevisionId)
    }

    fun getAllTaskRevisions(): MutableIterable<TaskRevision> {
        return taskRevisionRepository.findAll()
    }

    private fun createTaskRevisionFromAddableTask(addableTask: AddableTask): TaskRevision {
        return TaskRevision(
                revision =  addableTask.revision,
                displayName = addableTask.displayName,
                rank = addableTask.rank,
                active = addableTask.active,
                dot = addableTask.dot,
                solverMinTime = addableTask.solverMinTime,
                solverMaxTime =addableTask.solverMaxTime
        )
    }
}

