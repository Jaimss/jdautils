---
title: send - jdautils
---

[jdautils](../../index.html) / [dev.jaims.jdautils](../index.html) / [net.dv8tion.jda.api.entities.MessageChannel](index.html) / [send](./send.html)

# send

`fun MessageChannel.send(message: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, color: `[`Color`](https://docs.oracle.com/javase/6/docs/api/java/awt/Color.html)` = Color.WHITE): MessageAction`

Easy way to let your bot send an embedded message.

### Parameters

`message` - the mesasge to send

`color` - the color of the embed or white

**Return**
a [MessageAction](#)

`fun MessageChannel.send(message: MessageEmbed): MessageAction`

Send a message using an embed builder

### Parameters

`message` - the message to send

**Return**
a [MessageAction](#)

`fun MessageChannel.send(message: Message): MessageAction`

Send a message using a messagebuilder

### Parameters

`message` - the message to send

**Return**
a [MessageAction](#)

