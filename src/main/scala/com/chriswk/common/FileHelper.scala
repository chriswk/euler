package com.chriswk.common

object FileHelper {
  def fromClasspath(filename: String) = scala.io.Source.fromInputStream(
    getClass.getClassLoader.getResourceAsStream(filename)
  )
}
