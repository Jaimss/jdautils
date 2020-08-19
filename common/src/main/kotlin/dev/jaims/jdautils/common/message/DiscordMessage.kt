package dev.jaims.jdautils.common.message

import net.dv8tion.jda.api.MessageBuilder
import net.dv8tion.jda.api.entities.Message
import net.dv8tion.jda.api.entities.MessageEmbed

/**
 * A discord message with [content] and an [embed]
 */
data class DiscordMessage(
    var content: String? = null,
    var embed: MessageEmbed? = null
)

/**
 * A method to create a [DiscordMessage], which will be built to a [Message]
 * @return a [Message]
 */
inline fun createMessage(body: DiscordMessage.() -> Unit): Message {
    val m = DiscordMessage().apply(body)
    return MessageBuilder()
        .setContent(m.content)
        .setEmbed(m.embed)
        .build()
}