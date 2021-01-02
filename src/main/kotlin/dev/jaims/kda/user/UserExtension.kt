@file:Suppress("unused")

package dev.jaims.kda.user

import net.dv8tion.jda.api.entities.Guild
import net.dv8tion.jda.api.entities.Role
import net.dv8tion.jda.api.entities.User

/**
 * Check if a user has a role in a specific guild
 * Will require that the user is cached to return true / false
 *
 * @param id the role's id
 * @param guild the guild to check in
 *
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
 *
 * @return null if not in the guild or not cached. otherwise, true if they have the role, false if not
 */
fun User.hasRole(role: Role, guild: Guild): Boolean? = hasRole(role.idLong, guild)

/**
 * Check if a user has any role in a list for a specific guild
 *
 * @param ids the list of ids to check
 * @param guild the guild to check in
 *
 * @return null if not in guild or not cached. true if they have at least one of the roles, false if they don't have one
 */
fun User.hasRole(ids: List<Long>, guild: Guild): Boolean? {
    val member = guild.getMember(this) ?: return null
    return member.hasRole(ids)
}
