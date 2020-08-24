package dev.jaims.jdautils.common.message

import net.dv8tion.jda.api.EmbedBuilder
import net.dv8tion.jda.api.entities.MessageEmbed
import java.awt.Color
import java.time.temporal.TemporalAccessor

/**
 * A discord embed class to hold all the relevant pieces of a discord embed.
 */
class DiscordEmbed(
    var title: String? = null,
    var titleUrl: String? = null,
    var description: String? = null,
    var color: Color? = null,
    var fields: MutableList<DiscordEmbedField> = mutableListOf(),
    var authorName: String? = null,
    var authorUrl: String? = null,
    var imgUrl: String? = null,
    var footerText: String? = null,
    var footerUrl: String? = null,
    var thumbnailUrl: String? = null,
    var timestamp: TemporalAccessor? = null
) {

    /**
     * A function to build a message embed.
     */
    fun build(): MessageEmbed {

        val emb = EmbedBuilder()
            .setTitle(title, titleUrl)
            .setDescription(description)
            .setColor(color)
            .setAuthor(authorName, authorUrl)
            .setImage(imgUrl)
            .setFooter(footerText, footerUrl)
            .setThumbnail(thumbnailUrl)
            .setTimestamp(timestamp)
        fields.forEach {
            emb.addField(it.name, it.value, it.inline)
        }
        return emb.build()

    }

}

/**
 * Discord Embed Field. Holds all the relevant parts of an embed.
 */
class DiscordEmbedField(
    var name: String? = null,
    var value: String? = null,
    var inline: Boolean = false
)

/**
 * Create an embedded message for jda.
 * @return a [MessageEmbed]
 */
inline fun createEmbed(body: DiscordEmbed.() -> Unit): MessageEmbed = DiscordEmbed().apply(body).build()


/**
 * A method to set an embed for the [DiscordMessage]
 */
inline fun DiscordMessage.setEmbed(body: DiscordEmbed.() -> Unit) {
    val m = DiscordEmbed().apply(body)
    this.embed = m.build()
}

/**
 * A method to add a field to a [DiscordEmbed]
 */
inline fun DiscordEmbed.addField(body: DiscordEmbedField.() -> Unit) {
    val f = DiscordEmbedField().apply(body)
    this.fields.add(f)
}