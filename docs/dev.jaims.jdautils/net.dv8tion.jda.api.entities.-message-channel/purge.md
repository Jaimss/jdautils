---
title: purge - jdautils
---

[jdautils](../../index.html) / [dev.jaims.jdautils](../index.html) / [net.dv8tion.jda.api.entities.MessageChannel](index.html) / [purge](./purge.html)

# purge

`fun MessageChannel.purge(limit: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)` = 25000, response: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)` = true, responseColor: `[`Color`](https://docs.oracle.com/javase/6/docs/api/java/awt/Color.html)` = Color.GREEN): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Purge messages from a [MessageChannel](#)

### Parameters

`limit` - the amount of messages to purge in that channel.

`response` - should the bot post a response in that channel saying it deleted a message

`responseColor` - the color for the bot response if there is one