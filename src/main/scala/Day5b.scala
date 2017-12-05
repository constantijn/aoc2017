import scala.io.Source

object Day5b extends App {

  val puzzle = Source.fromInputStream(getClass.getResourceAsStream("/day5.txt")).getLines.toArray.map(_.toInt)

  var index = 0
  var counter = 0

  try {
    while(true) {
      var nextIndex = index + puzzle(index)
      if (puzzle(index) >= 3) puzzle(index) = puzzle(index) - 1 else puzzle(index) = puzzle(index) + 1
      counter +=1
      index = nextIndex
    }
  } catch {
    case _:IndexOutOfBoundsException => {
      println(counter)
    }
  }

}
