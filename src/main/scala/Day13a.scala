import scala.io.Source

object Day13a extends App {

  val input = Source.fromInputStream(getClass.getResourceAsStream("/day13.txt")).getLines
  val scanners:Map[Int, Int] = input.map(_.split(": ").map(_.toInt)).map(x=>(x(0), x(1))).toMap
  val maxTurn = scanners.keySet.max
  var severity = 0

  def scannerPosition(length:Int, turn:Int):Int = {
    val max = length - 1
    val mod = Math.abs(turn % max)
    val goingDown = (turn / max) % 2 == 0
    if (goingDown) mod else max - mod
  }

  for(turn <- 0 to scanners.keySet.max) {
    val scanner = scanners.get(turn)
    if (scanner.isDefined && scannerPosition(scanner.get, turn) == 0) {
      severity += scanner.get * turn
    }
  }

  println(severity)

}
