@file:Suppress("unused")

package dev.jaims.kda.message

import net.dv8tion.jda.api.requests.RestAction
import net.dv8tion.jda.api.requests.restaction.MessageAction
import java.time.Duration

/**
 * Cleanup a bot message that was sent.
 *
 * @param delay the delay in seconds before deleting
 *
 * @return a [RestAction]
 *
 * @sample dev.jaims.kda.test.messageActionExample
 */
fun MessageAction.cleanup(delay: Long = 3): RestAction<Void> = delay(Duration.ofSeconds(delay)).flatMap { it.delete() }