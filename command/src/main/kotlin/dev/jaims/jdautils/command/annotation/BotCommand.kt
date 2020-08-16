package dev.jaims.jdautils.command.annotation

@Target(AnnotationTarget.EXPRESSION)
@Retention(AnnotationRetention.SOURCE)
annotation class BotCommand(val commandName: String)