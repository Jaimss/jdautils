package dev.jaims.kda.test

import dev.jaims.kda.channel.purge
import dev.jaims.kda.channel.send
import dev.jaims.kda.message.buildEmbed
import dev.jaims.kda.message.cleanup
import net.dv8tion.jda.api.entities.MessageChannel
import net.dv8tion.jda.api.entities.TextChannel
import net.dv8tion.jda.api.entities.User

fun messageChannelExample(channel: MessageChannel, textChannel: TextChannel, someUser: User) {
    // send a message and clean it up
    channel.send(buildEmbed { setDescription("This is my embed!") }).cleanup().queue()

    // send a message
    textChannel.send("This is an example!").queue()

    // purge a channel with a custom predicate
    textChannel.purge { it.author != someUser && !it.isPinned }
}