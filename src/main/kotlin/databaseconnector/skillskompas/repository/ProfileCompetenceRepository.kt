package databaseconnector.skillskompas.repository

import databaseconnector.skillskompas.model.DomainTaskCluster
import databaseconnector.skillskompas.model.ProfileCompetence
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import databaseconnector.skillskompas.model.TaskRevision

@Repository
interface ProfileCompetenceRepository : CrudRepository<ProfileCompetence, Long>
