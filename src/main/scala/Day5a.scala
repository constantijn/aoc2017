import scala.io.Source

object Day5a extends App {

  val puzzle = Source.fromInputStream(getClass.getResourceAsStream("/day5.txt")).getLines.toArray.map(_.toInt)

  var index = 0
  var counter = 0

  while(true) {
    println(counter)
    var nextIndex = index + puzzle(index)
    puzzle(index) = puzzle(index) + 1
    counter +=1
    index = nextIndex
  }
}
