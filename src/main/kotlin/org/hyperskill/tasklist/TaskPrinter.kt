package org.hyperskill.tasklist

class TaskPrinter {

    fun printTasks(tasks:MutableList<Task>){
        if(tasks.isEmpty()){
            println("No tasks have been input")
        }
        else{
            for(i in tasks.indices){
                if(i+1<10){
                    printTask(i+1, "  ", tasks[i])
                }
                else{
                    printTask(i+1, " ", tasks[i])
                }
            }
        }
    }

    private fun printTask(number:Int, spaces:String, task:Task) {
        val dateTime = task.date.toString().split("T")
        val firstLine = "${dateTime[0]} ${dateTime[1]} ${task.priority}"
        val taskLines = task.description
        println("$number$spaces$firstLine")
        for(i in taskLines.indices){
            println("   ${taskLines[i]}")
        }
        println()
    }
}