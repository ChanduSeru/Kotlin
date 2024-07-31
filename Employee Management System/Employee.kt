class Employee(
var id: Int,
var name: String,
var department: String,
var salary: Double){
    override fun toString(): String{
        return "Employee[id=$id, name=$name, department=$department, salary=$salary]"
    }
    
}
class EmployeeManager{
    private val employees = mutableListOf<Employee>()
    private var currId = 1
    
    //Create New Employee
    fun createEmployee(name: String, department: String,salary: Double){
        val newEmployee = Employee(currId++,name,department,salary)
        employees.add(newEmployee)
        println("New Employee Created")
    }
    //update Existing function
    fun updateEmployee(id: Int,name: String, department: String,salary: Double){
        val index = findEmployeeIndexById(id)
        if(index != -1){
            employees[index].apply{
                this.name = name
                this.department = department
                this.salary = salary
            }
            println("Employee details updated")
        }else{
             println("Employee with ID $id not found.")
        }
    }
    //Delete Employee
    fun deleteEmployee(id: Int){
        val index = findEmployeeIndexById(id)
        if(index != 1){
            employees.removeAt(index)
            println("Employee Deleted Successfully")
        }
        else{
            println("Employee with ID $id not found.")
        }
    }
    //Show All Employees
    fun showAllEmployees(){
        if(employees.isEmpty()){
            println("Empty")
        }
        else{
            println("Employee List :")
             println("---------------")
            employees.forEach{
                println(it)
            }
        }
    }
    //find employee by id
    private fun findEmployeeIndexById(id: Int): Int{
        for ((index, employee) in employees.withIndex()){
            if(employee.id == id){
                return index
            }
        }
        return -1
    }
    
}

fun main(){
    val emp = EmployeeManager();
    emp.createEmployee("chan", "software", 6000000.0)
    emp.createEmployee("chand", "Development", 7000000.0)
    emp.createEmployee("lunar", "Mobile Dev", 4000000.0)
    emp.createEmployee("chand", "Web-Development", 7000000.0)
    
    emp.showAllEmployees()
    //updating
    emp.updateEmployee(1, "Ram", "SAP", 1100000.0)
    emp.showAllEmployees()
    emp.deleteEmployee(1)
    emp.showAllEmployees()    
}