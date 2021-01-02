@file:Suppress("unused")

package dev.jaims.kda.channel

import net.dv8tion.jda.api.entities.Message
import net.dv8tion.jda.api.entities.MessageChannel
import net.dv8tion.jda.api.entities.MessageEmbed
import net.dv8tion.jda.api.requests.restaction.MessageAction

/**
 * Send a [Message].
 *
 * @param message the message to send
 *
 * @return a [MessageAction]
 */
fun MessageChannel.send(message: Message): MessageAction = sendMessage(message)

/**
 * Send a [Message] as just a string in the [MessageChannel]. No fancy embed or anything else.
 *
 * @param content the message to send
 *
 * @return a [MessageAction]
 */
fun MessageChannel.send(content: String): MessageAction = sendMessage(content)

/**
 * Send a [Message] to a channel with only a [MessageEmbed]
 *
 * @param embed the embed to send
 *
 * @return a [MessageAction]
 */
fun MessageChannel.send(embed: MessageEmbed): MessageAction = sendMessage(embed)

/**
 * Purge messages from a [MessageChannel]. Will not purge pinned messages by default, but that can be configured using
 * the [predicate].
 *
 * @param limit the amount of messages to purge in that channel.
 * @param predicate the requirement to be met for the message purge. Defaults to not purging pinned messages.
 *
 * @return the [MessageChannel] that has messages purged.
 */
fun MessageChannel.purge(limit: Int = 25000, predicate: (Message) -> Boolean = { !it.isPinned }): MessageChannel {
    if (limit > 25000) error("Limit too high! Please keep it below 25,000.")
    val list = iterableHistory.takeWhileAsync(limit, predicate)

    purgeMessages(list.get())
    println("Purged $limit messages from channel: $idLong, $name")
    return this
}