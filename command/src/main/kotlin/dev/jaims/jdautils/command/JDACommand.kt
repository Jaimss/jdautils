package dev.jaims.jdautils.command

import com.jagrosh.jdautilities.command.Command
import com.jagrosh.jdautilities.command.CommandEvent
import dev.jaims.jdautils.command.annotation.*
import dev.jaims.jdautils.common.hasRole
import java.lang.reflect.Method


open class JDACommand : Command() {

    init {
        val name =
            getCommandName() ?: error("The ${BotCommand::class.java.name} annotation is required for your class.")
    }

    /**
     * Handle the Command
     */
    override fun execute(event: CommandEvent) {
        val default = getDefault() ?: error("The ${Default::class.java.name} annotation is required.")
        for (subCommand in getSubCommands()) {
            if (event.args.split(" ")
                    .firstOrNull() == subCommand.name && event.member.hasRole(subCommand.getPermissionRoles().toList())
            ) {
                subCommand.invoke(this, *event.args.split(" ").toTypedArray())
                return
            }
        }
        default.invoke(this, *event.args.split(" ").toTypedArray())
    }

    private fun getCommandName(): String? {
        return this.javaClass.getAnnotation(BotCommand::class.java)?.commandName
    }

    /**
     * Get the default method. This is run if there is no subcommand.
     */
    private fun getDefault(): Method? {
        for (m in this.javaClass.methods) {
            if (m.isAnnotationPresent(Default::class.java)) return m
        }
        return null
    }

    /**
     * Get the usage method or null if there is none.
     */
    private fun getUsage(): Method? {
        for (m in this.javaClass.methods) {
            if (m.isAnnotationPresent(Usage::class.java)) return m
        }
        return null
    }

    /**
     * Get the roles that have permission to execute specific commands.
     */
    private fun Method.getPermissionRoles(): LongArray {
        if (isAnnotationPresent(PermissionRoles::class.java)) {
            return getAnnotation(PermissionRoles::class.java).roles
        }
        return emptyArray<Long>().toLongArray()
    }

    /**
     * Get all the subcommands in the class
     */
    private fun getSubCommands(): MutableList<Method> {
        val methods = mutableListOf<Method>()
        for (m in this.javaClass.methods) {
            if (m.isAnnotationPresent(BotSubCommand::class.java)) methods.add(m)
        }
        return methods
    }


}