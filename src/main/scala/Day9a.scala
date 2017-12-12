import scala.io.Source

object Day9a extends App {

  val puzzle = Source.fromInputStream(getClass.getResourceAsStream("/day9.txt")).getLines.toSeq(0)

  var garbageStarted = false
  var index = 0
  val cleanPuzzleBuilder = new StringBuilder()
  var garbageCount = 0

  while (index < puzzle.length) {
    (puzzle.charAt(index), garbageStarted) match {
      case ('!', true) => index += 1
      case ('<', false) => garbageStarted = true
      case ('>', true) => garbageStarted = false
      case (c:Char, false) => cleanPuzzleBuilder.append(c)
      case (_, true) => garbageCount += 1
    }
    index += 1
  }

  val cleanPuzzle = cleanPuzzleBuilder.toString()
  index = 0

  var depth = 0
  var score = 0

  while (index < cleanPuzzle.length) {
    cleanPuzzle.charAt(index) match {
      case '{' => depth += 1
      case '}' => {score += depth; depth -= 1}
      case _ => // do nothing
    }
    index += 1
  }

  println(s"Score: $score")
  println(s"GarbageCount: $garbageCount")

}
