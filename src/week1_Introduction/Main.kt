package week1_Introduction

class TodoTask(taskName: String, taskDescription: String) {
    private val taskName: String = taskName
    private val taskDescription: String = taskDescription


    public fun getTaskName(): String {
        return this.taskName
    }

    public fun getTaskDescription(): String {
        return this.taskDescription
    }

}


class TodoDisplay() {
    private val tasks: MutableList<TodoTask> = mutableListOf<TodoTask>()


    fun run() {
        while (true) {
            println("To-Do List Menu:")
            println("1. Add Task")
            println("2. View Tasks")
            println("3. Remove Task")
            println("4. Exit")

            print("Choose an option: ")

            when (readln()) {
                "1" -> addTask()
                "2" -> viewTasks()
                "3" -> removeTask()
                "4" -> {
                println("Exiting...")
                break
                }

                else -> println("Invalid Option, try again")

            }
        }
    }
    fun addTask() {
        print("Task Name: ")
        val userResponseName = readln()

        print("Task Description: ")
        val userResponseDescription = readln()


        this.tasks.add(TodoTask(userResponseName, userResponseDescription))
    }

    fun viewTasks() {
        for (task in tasks) {
            println("Task Name: ${task.getTaskName()}")
            println("Task Description: ${task.getTaskDescription()}")
        }
    }

    fun removeTask() {
        for (task in tasks) {
            println("Task Name: ${task.getTaskName()}")
            println("Task Description: ${task.getTaskDescription()}")
        }

        print("Which Task would you like to remove (Task Number): ")
        val userResponse: Int = (Integer.valueOf(readln()) - 1);
        tasks.removeAt(userResponse)
    }



}

fun main() {
    val todoOperation: TodoDisplay = TodoDisplay()

    todoOperation.run()
}


