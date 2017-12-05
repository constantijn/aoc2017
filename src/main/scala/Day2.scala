import scala.io.Source

object Day2 extends App {

  val lines = Source.fromInputStream(getClass.getResourceAsStream("/day2.txt")).getLines
  val parsedLines = lines.map(_.split('\t').map(_.toInt)).toSeq

  println("2a")
  println(parsedLines.map(line => line.max - line.min).sum)

  def computeChecksum(line:Array[Int]):Int = {
    for(i <- line; j <- line) {
      if (i > j && i % j == 0) return i / j
      if (i < j && j % i == 0) return j / i
    }
    throw new RuntimeException("No solution for line " + line)
  }

  println("2b")
  println(parsedLines.map(computeChecksum).sum)

}
