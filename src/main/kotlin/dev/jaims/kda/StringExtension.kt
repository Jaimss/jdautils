package dev.jaims.kda

import java.awt.Color

/**
 * Turn a hex color code into a [Color]
 *
 * @return a [Color] or null if you don't provide a proper hex code
 */
fun String.toColor(): Color? {
    if (!this.matches("[#][0-9a-fA-F]{6}".toRegex())) return null
    val digits: String = this.substring(1, this.length.coerceAtMost(7))
    val hxstr = "0x$digits"
    return Color.decode(hxstr)
}
