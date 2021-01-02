package dev.jaims.kda.message

import net.dv8tion.jda.api.EmbedBuilder
import net.dv8tion.jda.api.entities.Message
import net.dv8tion.jda.api.entities.MessageEmbed

/**
 * Build a Message Embed.
 *
 * @param properties the properties for the embed to have.
 *
 * @return the final [MessageEmbed]
 */
fun buildEmbed(properties: EmbedBuilder.() -> EmbedBuilder): MessageEmbed = properties(EmbedBuilder()).build()

/**
 * Build a message from an embed only.
 *
 * @return the appropriate [Message].
 */
fun MessageEmbed.asMessage(): Message = buildMessage { setEmbed(this@asMessage) }