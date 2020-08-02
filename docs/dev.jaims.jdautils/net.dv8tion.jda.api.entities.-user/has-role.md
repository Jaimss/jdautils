---
title: hasRole - jdautils
---

[jdautils](../../index.html) / [dev.jaims.jdautils](../index.html) / [net.dv8tion.jda.api.entities.User](index.html) / [hasRole](./has-role.html)

# hasRole

`fun User.hasRole(id: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`, guild: Guild): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`?`

Check if a user has a role in a specific guild
Will require that the user is cached to return true / false

### Parameters

`id` - the role's id

`guild` - the guild to check in

**Return**
null if not in the guild or not cached. otherwise, true if they have the role, false if not

`fun User.hasRole(role: Role, guild: Guild): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`?`

Check if a user has a role in a specific guild
Will require that the user is cached to return true / false

### Parameters

`role` - the role

`guild` - the guild to check in

**Return**
null if not in the guild or not cached. otherwise, true if they have the role, false if not

`fun User.hasRole(ids: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`>, guild: Guild): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`?`

Check if a user has any role in a list for a specific guild

### Parameters

`ids` - the list of ids to check

`guild` - the guild to check in

**Return**
null if not in guild or not cached. true if they have at least one of the roles, false if they don't have one

