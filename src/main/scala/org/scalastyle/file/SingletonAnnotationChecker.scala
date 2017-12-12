package org.scalastyle.file

import org.scalastyle.Lines

/**
  * Created by emma on 12/12/2017.
  */
class SingletonAnnotationChecker {

  def verify(lines: Lines): Unit = {
    val lineIndices = lines.lines.zipWithIndex
    lineIndices.foreach {
      case (line, lineNumber) => if (line.text.contains("class")) {
        if (!lineIndices(lineNumber - 1)._1.text.contains("@Singleton")) {
          println(s"error at line number ${lineNumber}: ${line}")
        }
        else {
          println(s"line valid at ${lineNumber}: ${line}")
        }
      }
    }
  }

}
