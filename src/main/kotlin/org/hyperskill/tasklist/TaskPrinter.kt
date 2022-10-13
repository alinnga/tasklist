package org.hyperskill.tasklist

class TaskPrinter {

    fun printTasks(tasks:MutableList<List<String>>){
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

    private fun printTask(number:Int, spaces:String, list:List<String>) {
        val firstLine = list[0]
        println("$number$spaces$firstLine")
        for(i in 1..list.size-1){
            println("   ${list[i]}")
        }
        println()
    }
}