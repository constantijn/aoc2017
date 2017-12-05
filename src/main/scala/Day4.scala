import scala.io.Source

object Day4 extends App {

  val lines = Source.fromInputStream(getClass.getResourceAsStream("/day4.txt")).getLines
  val parsedLines = lines.map(_.split(' ')).toSeq

  print("4a: ")
  println(parsedLines.count(line => line.length == line.toSet.size))

  print("4b: ")
  println(parsedLines.map(_.map(_.sorted)).count(line => line.length == line.toSet.size))
}
