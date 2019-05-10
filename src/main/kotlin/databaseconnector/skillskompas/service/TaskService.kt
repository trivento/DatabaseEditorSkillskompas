package databaseconnector.skillskompas.service
import databaseconnector.skillskompas.model.AddableTask
import databaseconnector.skillskompas.model.TaskRevision
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class TaskService{

    @Autowired
    lateinit var taskRevisionService: TaskRevisionService
    @Autowired
    lateinit var domainTaskClusterService: DomainTaskClusterService
    @Autowired
    lateinit var taskCompetenceMappingService : TaskCompetenceMappingService
    @Autowired
    lateinit var profileTaskService: ProfileTaskService
    @Autowired
    lateinit var profileCompetenceService: ProfileCompetenceService

    fun addTask(addableTask: AddableTask) {
            val taskRevision = taskRevisionService.addTaskRevision(addableTask)
            addableTask.taskRevisionId = taskRevision.taskrevision_id
            domainTaskClusterService.addDomainTaskCluster(addableTask)
            taskCompetenceMappingService.addTaskCompetenceMapping(addableTask)
            val profileTask = profileTaskService.addProfileTask(addableTask)
            addableTask.profileTaskId = profileTask.profiletask_id
            profileCompetenceService.addProfileCompetence(addableTask)
            activateTask(taskRevision.taskrevision_id)
    }

    fun activateTask(taskRevisionId: Long){
        return taskRevisionService.activateTask(taskRevisionId)
    }

    fun deactivateTask(taskRevisionId: Long) {
        return taskRevisionService.decativateTask(taskRevisionId)

    }
}
