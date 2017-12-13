import scala.io.Source

object Day13b extends App {
  val input = Source.fromInputStream(getClass.getResourceAsStream("/day13.txt")).getLines
  val scanners: Map[Int, Int] = input.map(_.split(": ").map(_.toInt)).map(x => (x(0), x(1))).toMap
  val maxTurn = scanners.keySet.max
  var caught = false

  def scannerPosition(length: Int, turn: Int): Int = {
    val max = length - 1
    val mod = Math.abs(turn % max)
    val goingDown = (turn / max) % 2 == 0
    if (goingDown) mod else max - mod
  }

  for (delay <- 0 to Int.MaxValue) {
    caught = false
    for (turn <- 0 to scanners.keySet.max) {
      val scanner = scanners.get(turn)
      if (scanner.isDefined && scannerPosition(scanner.get, turn + delay) == 0) {
        caught = true
      }
    }
    if (!caught) {
      println(delay)
      System.exit(0)
    }
  }


}
