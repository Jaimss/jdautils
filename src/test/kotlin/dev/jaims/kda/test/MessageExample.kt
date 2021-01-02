package dev.jaims.kda.test

import dev.jaims.kda.message.asMessage
import dev.jaims.kda.message.buildEmbed
import dev.jaims.kda.message.buildMessage
import java.time.LocalTime

fun messageExample() {
    val message = buildMessage {
        setContent("This is my content!")
        setEmbed(
            buildEmbed {
                setDescription("This is my description.")
                setTimestamp(LocalTime.now())
                setAuthor("Its me... Im the author.")
            }
        )
        setTTS(true)
    }
}

fun embedExample() {
    val message = buildEmbed {
        setTitle("Title", "https://jaims.dev")
    }.asMessage()
}