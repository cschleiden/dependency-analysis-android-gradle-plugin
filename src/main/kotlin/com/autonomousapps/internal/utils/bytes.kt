package com.autonomousapps.internal.utils

import java.text.CharacterIterator
import java.text.StringCharacterIterator

/**
 * Borrowed from https://stackoverflow.com/a/3758880.
 */
internal fun humanReadableBytesBin(bytes: Long): String {
  val absB = if (bytes == Long.MIN_VALUE) Long.MAX_VALUE else Math.abs(bytes)
  if (absB < 1024) {
    return "$bytes B"
  }
  var value = absB
  val ci: CharacterIterator = StringCharacterIterator("KMGTPE")
  var i = 40
  while (i >= 0 && absB > 0xfffccccccccccccL shr i) {
    value = value shr 10
    ci.next()
    i -= 10
  }
  value *= java.lang.Long.signum(bytes).toLong()
  return java.lang.String.format("%.1f %ciB", value / 1024.0, ci.current())
}
