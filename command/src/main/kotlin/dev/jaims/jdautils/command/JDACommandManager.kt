package dev.jaims.jdautils.command

import com.jagrosh.jdautilities.command.CommandClient
import com.jagrosh.jdautilities.command.CommandClientBuilder
import java.util.function.Supplier

class JDACommandManagerBuilder : Supplier<CommandClient> {

    private val commands = mutableListOf<JDACommand>()
    private var commandClient: CommandClientBuilder? = null

    /**
     * Register a variable amount of [commands].
     */
    fun registerCommands(vararg commands: JDACommand) = apply {
        commands.forEach {
            this.commands.add(it)
        }
    }

    /**
     * Set the Command Client
     */
    fun setCommandClient(commandClient: CommandClientBuilder) = apply { this.commandClient = commandClient }

    /**
     * Get the CommandClient
     */
    override fun get(): CommandClient {
        TODO()
    }

}