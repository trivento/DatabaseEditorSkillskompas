package databaseconnector.skillskompas.controller.dto
import databaseconnector.skillskompas.model.Competence
import databaseconnector.skillskompas.model.Domain
import databaseconnector.skillskompas.model.TaskCluster

fun Competence.toKeyValue() = mapOf(competence_id to display_name)
fun Domain.toKeyValue() = mapOf(domain_id to display_name)
fun TaskCluster.toKeyValue() = mapOf(taskcluster_id to name)
