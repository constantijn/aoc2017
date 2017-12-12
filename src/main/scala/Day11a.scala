import scala.io.Source

object Day11a extends App {

  val puzzle = Source.fromInputStream(getClass.getResourceAsStream("/day11.txt")).getLines.next.split(",").toSeq

  var x = 0
  var y = 0
  var z = 0
  var max = 0

  def dist() = (Math.abs(x) + Math.abs(y) + Math.abs(z)) / 2

  for(step <- puzzle) {
    step match {
      case "n" =>  { y +=1; z -=1 }
      case "s" =>  { y -=1; z +=1 }
      case "nw" => { x -=1; y +=1 }
      case "se" => { x +=1; y -=1 }
      case "ne" => { x +=1; z -=1 }
      case "sw" => { x -=1; z +=1 }
    }

    max = Math.max(max, dist)
  }

  println(dist)
  println(max)

}
