package org.hyperskill.tasklist

class TaskList {

    val tasks = mutableListOf<List<String>>()
    val taskPrinter = TaskPrinter()

    fun start(){

        openMenu()

    }

    private fun openMenu() {
        println("Input an action (add, print, end):")
        val action = readln()
        when(action){
            "end" -> {
                exit()
            }
            "add" -> {
                addTasks()
                start()
            }
            "print" -> {
                taskPrinter.printTasks(tasks)
                start()
            }
            else -> {
                println("The input action is invalid")
                start()
            }
        }
    }


    private fun addTasks() {
        println("Input a new task (enter a blank line to end):")
        val firstLine = readln().trim()
        val task = mutableListOf<String>()
        if(firstLine.isBlank()) println("The task is blank")
        else{
            task.add(firstLine)
            while(true){
                val nextLine = readln().trim()
                if(nextLine.isEmpty()){
                    break
                }
                task.add(nextLine)

            }
            tasks.add(task)
        }

    }

    private fun exit() {
        println("Tasklist exiting!")
    }
}