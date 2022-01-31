package singleton

object AppConfig {
    init {
        println("Invoking app configuration")
    }

    fun getConfiguration(){
        println("App version 1.0.0\nEnable threads:5")
    }
}