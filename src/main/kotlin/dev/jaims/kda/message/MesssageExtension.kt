package dev.jaims.kda.message

import net.dv8tion.jda.api.MessageBuilder
import net.dv8tion.jda.api.entities.Message

/**
 * Build a Message
 *
 * @param properties the properties for the message to have.
 *
 * @return the final [Message]
 *
 * @sample dev.jaims.kda.test.messageExample
 */
fun buildMessage(properties: MessageBuilder.() -> MessageBuilder): Message = properties(MessageBuilder()).build()