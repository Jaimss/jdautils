package dev.jaims.kda.test

import dev.jaims.kda.channel.send
import dev.jaims.kda.message.cleanup
import net.dv8tion.jda.api.entities.Message
import net.dv8tion.jda.api.entities.TextChannel

fun messageActionExample(channel: TextChannel, message: Message) {
    val x: Long = 5
    // send a message and then delete it after x seconds
    channel.send(message).cleanup(x).queue()
}