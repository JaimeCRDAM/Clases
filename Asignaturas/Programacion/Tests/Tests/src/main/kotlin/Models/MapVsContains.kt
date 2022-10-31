package Models

import java.nio.charset.Charset
import kotlin.random.Random


class MapVsContains {
    var insuranceArray = Array<String>(3){
        givenUsingPlainJava_whenGeneratingRandomStringUnbounded_thenCorrect()
    }
    init {
        var time = 0
        var timer = System.nanoTime()
        while (time < 1000000) {
            contains()
            time++
        }
        println(System.nanoTime()-timer)
        time = 0
        timer = System.nanoTime()
        while (time < 1000000) {
            map()
            time++
        }
        println(System.nanoTime()-timer)
    }


    fun map():Boolean{
       var ak =  insuranceArray.map {

        }
        return false
    }
    fun contains():Boolean{
        return insuranceArray.contains(insuranceArray[Random.nextInt(0, insuranceArray.size)])
    }
    fun givenUsingPlainJava_whenGeneratingRandomStringUnbounded_thenCorrect():String {
        val array = ByteArray(10) // length is bounded by 7
        Random.nextBytes(array)
        val generatedString = String(array, Charset.forName("UTF-8"))
        return generatedString
    }
}