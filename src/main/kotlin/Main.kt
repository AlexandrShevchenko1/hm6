package org.example
import kotlinx.serialization.Serializable

import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import java.io.File
import java.io.FileReader
import java.io.FileWriter
import java.time.LocalDateTime

fun getCodeLocation(): String {
    val stackTrace = Thread.currentThread().stackTrace
    if (stackTrace.size >= 3) {
        val caller = stackTrace[3]
        return "Called the ${caller.methodName} method in class ${caller.className}, file: ${caller.fileName}, line: ${caller.lineNumber}"
    }
    else {
        return "The thread is empty"
    }
}

@Serializable
class Message(private val type: String, private val information:String){
    private val time = LocalDateTime.now().toString()
    private val location = getCodeLocation()
    fun messageToString(): String {
        return "$type: $time, $location, $information\n"
    }
}

object Journal {
    fun writeToJournal(item: Message) {
        val messageJson: MutableList<Message> = Json.decodeFromString<MutableList<Message>>(File("journal.json").readText())

        val messageTxt: String = FileReader("journal.txt").use { file ->
            file.readText()
        }
        val txt = messageTxt + item.messageToString()
        FileWriter("journal.txt").use { file1 ->
            file1.write(txt)
        }

        messageJson.add(item)
        val json = Json.encodeToString(messageJson)
        FileWriter("journal.json").use { file2 ->
            file2.write(json)
        }
    }
}

class Multiplier {
    fun multiply(a: Int, b: Int) : Int {
        if (a == 0) {
            Journal.writeToJournal(
                Message("Warning", "Multiplying by zero always equals zero!")
            )
            return 0
        }
        else {
            val result =  a * b
            Journal.writeToJournal(Message("Inf", "Result of multiplication operation: $result"))
            return result
        }
    }
}

fun main() {
    val a = readln().toIntOrNull()
    if(a == null) {
        Journal.writeToJournal(Message("Err","Empty line entered"))
    } else {
        val multiplier = Multiplier()
        Journal.writeToJournal(Message("Inf","Calculator created"))
        var result = multiplier.multiply(a, 99)
    }
}