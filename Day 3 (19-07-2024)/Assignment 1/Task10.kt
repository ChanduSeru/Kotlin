class Student {
    // Private properties
    private var id: Int = 0
    private var name: String = ""
    private var age: Int = 0
    private var grade: String = ""

    // Getter and setter for id
    fun getId(): Int {
        return id
    }

    fun setId(newId: Int) {
        // Here you can add validation logic if needed
        id = newId
    }

    // Getter and setter for name
    fun getName(): String {
        return name
    }

    fun setName(newName: String) {
        name = newName
    }

    // Getter and setter for age
    fun getAge(): Int {
        return age
    }

    fun setAge(newAge: Int) {
        // Example validation: age should be non-negative
        if (newAge >= 0) {
            age = newAge
        } else {
            throw IllegalArgumentException("Age cannot be negative")
        }
    }

    // Getter and setter for grade
    fun getGrade(): String {
        return grade
    }

    fun setGrade(newGrade: String) {
        grade = newGrade
    }
}

fun main() {
    // Create a list of students
    val studentList = mutableListOf<Student>()

    // Add students to the list with age validation
    val student1 = Student()
    student1.setId(1)
    student1.setName("Alice")
    student1.setAge(20)
    student1.setGrade("A")
    if (student1.getAge() >= 3) {
        studentList.add(student1)
    } else {
        println("Student ${student1.getName()} is too young to be added.")
    }

    val student2 = Student()
    student2.setId(2)
    student2.setName("Bob")
    student2.setAge(21)
    student2.setGrade("B")
    if (student2.getAge() >= 3) {
        studentList.add(student2)
    } else {
        println("Student ${student2.getName()} is too young to be added.")
    }

    val student3 = Student()
    student3.setId(3)
    student3.setName("Charlie")
    student3.setAge(2) // Setting age less than 3
    student3.setGrade("A")
    if (student3.getAge() >= 3) {
        studentList.add(student3)
    } else {
        println("Student ${student3.getName()} is too young to be added.")
    }

    // Display information of all valid students in the list
    println("List of Students:")
    for (student in studentList) {
        println("Student ID: ${student.getId()}")
        println("Student Name: ${student.getName()}")
        println("Student Age: ${student.getAge()}")
        println("Student Grade: ${student.getGrade()}")
        println()
    }
}
