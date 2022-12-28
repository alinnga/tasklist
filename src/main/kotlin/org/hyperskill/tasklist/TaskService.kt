package org.hyperskill.tasklist

import kotlinx.datetime.LocalDate
import kotlinx.datetime.LocalDateTime

class TaskService {

    private val tasks = mutableListOf<Task>()
    private val taskPrinter = TaskPrinter()

    fun start(){

        openMenu()

    }

    private fun openMenu() {
        println("Input an action (add, print, end):")
        when(readln()){
            "end" -> {
                exit()
            }
            "add" -> {
                addTasks()
                openMenu()
            }
            "print" -> {
                taskPrinter.printTasks(tasks)
                openMenu()
            }
            else -> {
                println("The input action is invalid")
                openMenu()
            }
        }
    }


    private fun addTasks() {
        val task = Task()
        inputTaskPriority(task)
        inputDateTime(task)
        inputDescription(task)
        tasks.add(task)
    }

    private fun inputDescription(task: Task) {
        println("Input a new task (enter a blank line to end):")
        val firstLine = readln().trim()
        val taskLines = mutableListOf<String>()
        if(firstLine.isBlank()) println("The task is blank")
        else{
            taskLines.add(firstLine)
            while(true){
                val nextLine = readln().trim()
                if(nextLine.isEmpty()){
                    break
                }
                taskLines.add(nextLine)

            }
            task.description = taskLines
        }
    }

    private fun inputTaskPriority(task: Task){
        println("Input the task priority (C, H, N, L):")
        val priority = readln()
        if(priority.length==1 && priority[0] in listOf('C', 'H', 'N', 'L', 'c', 'h', 'n', 'l')){
            task.priority = priority[0]
        }
        else{
            inputTaskPriority(task)
        }
    }

    private fun inputDateTime(task: Task){
        var dateInputList: List<String>
        while(true){
            println("Input the date (yyyy-mm-dd):")
            val dateInput = readln()
            try {
                dateInputList = dateInput.split("-")
                LocalDate(dateInputList[0].toInt(), dateInputList[1].toInt(), dateInputList[2].toInt())
                break
            }
            catch (e: Exception){
                println("The input date is invalid")
                continue
            }
        }

        var localDateTime:LocalDateTime
        while(true){
            println("Input the time (hh:mm):")
            val timeInput = readln()
            try {
                val timeInputList = timeInput.split(":")
                localDateTime = LocalDateTime(
                    dateInputList[0].toInt(),
                    dateInputList[1].toInt(),
                    dateInputList[2].toInt(),
                    timeInputList[0].toInt(),
                    timeInputList[1].toInt())
                break
            }
            catch (e: Exception){
                println("The input time is invalid")
                continue
            }
        }

        task.date = localDateTime
    }

    private fun exit() {
        println("Tasklist exiting!")
    }
}