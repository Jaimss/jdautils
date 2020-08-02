---
title: hasRole - jdautils
---

[jdautils](../../index.html) / [dev.jaims.jdautils](../index.html) / [net.dv8tion.jda.api.entities.Member](index.html) / [hasRole](./has-role.html)

# hasRole

`fun Member.hasRole(id: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)

Check if a member has a role by the id of the role

### Parameters

`id` - the id of the role to check

**Return**
true if they have it, false if not

`fun Member.hasRole(role: Role): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)

Check if a memebr has a role by the id of the role

### Parameters

`role` - the role to check

**Return**
true if they have it, false if not

`fun Member.hasRole(ids: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`>): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)

Check if a Member has a role in a list of roles

### Parameters

`ids` - the list of role ids

**Return**
true if they have at least one role, false if they don't have any of the roles

