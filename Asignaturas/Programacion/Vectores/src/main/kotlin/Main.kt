import java.io.File
import java.lang.Exception
import kotlin.reflect.*
fun main(args: Array<String>) {
    val ejerciciosDisponibles = ejerciciosDisponibles()
    ejerciciosDisponibles.sort()
    val debug = areWeDebugging()

    while(true){
        if(ejerciciosDisponibles.isEmpty()) return
        println("\nLos ejercicios disponibles son:\n")
        ejerciciosDisponibles.map{
            println(it)
        }

        print("\nEscribe el nombre del ejercicio que quieras.")
        val ejercicio = readLine()

        try {
            val c: Class<Any> = Class.forName("Ejercicios.$ejercicio") as Class<Any>
            c.getDeclaredConstructor().newInstance()

        }
        catch (e: Exception) {
            if (debug){
                e.printStackTrace()
            } else{
                println("Has escrito mal el ejercicio")
            }
        }
    }
    println("Gracias por participar")
}
fun  areWeDebugging(): Boolean{
    val user: String = System.getProperty("user.name")
    if(user.indexOf("dam") >= 0 || user.indexOf("Lnote") >= 0){
        return true
    }
    return false
}
fun ejerciciosDisponibles(): Array<String> {

    val folder = File("src/main/kotlin/Ejercicios").list()
    val size = folder.count { it.contains(".kt") }
    if(size == 0) return arrayOf("")
    val files = folder.filter { it.contains(".kt") }
    return Array(size) {files[it].substring(0, files[it].indexOf(".kt"))}
}