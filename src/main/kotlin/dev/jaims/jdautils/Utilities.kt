package dev.jaims.jdautils

import net.dv8tion.jda.api.EmbedBuilder
import net.dv8tion.jda.api.entities.*
import net.dv8tion.jda.api.requests.RestAction
import net.dv8tion.jda.api.requests.restaction.MessageAction
import java.awt.Color
import java.time.Duration

/**
 * Easy way to let your bot send an embedded message.
 *
 * @param message the mesasge to send
 * @param color the color of the embed or white
 * @return a [MessageAction]
 */
fun MessageChannel.send(message: String, color: Color = Color.WHITE): MessageAction {
    return sendMessage(
        EmbedBuilder()
            .setDescription(message)
            .setColor(color).build()
    )
}

/**
 * Cleanup a message action. A good way to delete the message after you use [send].
 *
 * @param delay the delay before deleting
 * @return a [RestAction]
 */
fun MessageAction.cleanup(delay: Long = 3): RestAction<Void> {
    return delay(Duration.ofSeconds(delay))
        .flatMap { it.delete() }
}

/**
 * Turn a hex color code into a [Color]
 *
 * @return a [Color] or [Color.BLACK] if you don't provide a proper hex code
 */
fun String.toColor(): Color {
    if (!this.matches("[#][0-9a-fA-F]{6}".toRegex())) return Color.BLACK
    val digits: String = this.substring(1, this.length.coerceAtMost(7))
    val hxstr = "0x$digits"
    return Color.decode(hxstr)
}

/**
 * Purge messages from a [MessageChannel]
 *
 * @param limit the amount of messages to purge in that channel.
 * @param response should the bot post a response in that channel saying it deleted a message
 * @param responseColor the color for the bot response if there is one
 */
fun MessageChannel.purgeMessages(limit: Int = 25000, response: Boolean = true, responseColor: Color = Color.GREEN) {
    val act = this.iterableHistory
    val list = act.takeWhileAsync(limit) { !it.isPinned }

    this.purgeMessages(list.get())
    println("Purged $limit messages from channel: ${this.idLong}.")
    if (response) send("Successfully deleted ${list.get().size} messages!", responseColor).cleanup().queue()
}

/**
 * Check if a user has a role in a specific guild
 * Will require that the user is cached to return true / false
 *
 * @param id the role's id
 * @param guild the guild to check in
 * @return null if not in the guild or not cached. otherwise, true if they have the role, false if not
 */
fun User.hasRole(id: Long, guild: Guild): Boolean? {
    val member = guild.getMember(this) ?: return null
    return member.hasRole(id)
}

/**
 * Check if a user has a role in a specific guild
 * Will require that the user is cached to return true / false
 *
 * @param role the role
 * @param guild the guild to check in
 * @return null if not in the guild or not cached. otherwise, true if they have the role, false if not
 */
fun User.hasRole(role: Role, guild: Guild): Boolean? = hasRole(role.idLong, guild)

/**
 * Check if a user has any role in a list for a specific guild
 *
 * @param ids the list of ids to check
 * @param guild the guild to check in
 * @return null if not in guild or not cached. true if they have at least one of the roles, false if they don't have one
 */
fun User.hasRole(ids: List<Long>, guild: Guild): Boolean? {
    val member = guild.getMember(this) ?: return null
    return member.hasRole(ids)
}

/**
 * Check if a member has a role by the id of the role
 *
 * @param id the id of the role to check
 * @return true if they have it, false if not
 */
fun Member.hasRole(id: Long): Boolean {
    var b = false
    for (role in roles) {
        if (role.idLong == id) b = true
    }
    return b
}

/**
 * Check if a memebr has a role by the id of the role
 *
 * @param role the role to check
 * @return true if they have it, false if not
 */
fun Member.hasRole(role: Role): Boolean = hasRole(role.idLong)

/**
 * Check if a Member has a role in a list of roles
 *
 * @param ids the list of role ids
 * @return true if they have at least one role, false if they don't have any of the roles
 */
fun Member.hasRole(ids: List<Long>): Boolean {
    var b = false
    for (r in roles) {
        if (ids.contains(r.idLong)) b = true
    }
    return b
}