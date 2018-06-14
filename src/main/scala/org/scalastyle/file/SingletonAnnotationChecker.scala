package org.scalastyle.file

import org.scalastyle.{FileChecker, LineError, Lines, ScalastyleError}
import scala.collection.mutable.MutableList

class SingletonAnnotationChecker extends FileChecker {

  val errorKey = "singleton.annotation.checker"

  def verify(lines: Lines): List[ScalastyleError] = {
    val lineIndices = lines.lines.zipWithIndex
    var errorStack = MutableList.empty[ScalastyleError]
    lineIndices.foreach {
      case (line, lineNumber) => if (line.text.contains("class") && (!line.text.contains("case"))) {
        if (!lineIndices(lineNumber - 1)._1.text.contains("@Singleton")) {
          errorStack += LineError(lineNumber, errorKey = Some(errorKey))
        }
        else {
          println(s"line valid at ${lineNumber}: ${line}")
        }
      }
    }
    errorStack.toList
  }

}
