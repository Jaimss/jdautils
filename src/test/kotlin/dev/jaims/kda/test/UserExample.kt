package dev.jaims.kda.test

import dev.jaims.kda.user.hasRole
import net.dv8tion.jda.api.entities.Member
import net.dv8tion.jda.api.entities.Role

fun memberExample(member: Member, yourRole: Role) {
    if (!member.hasRole(yourRole)) return
    // member has permission!
}