@file:Suppress("unused")

package dev.jaims.kda.user

import net.dv8tion.jda.api.entities.Member
import net.dv8tion.jda.api.entities.Role

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
