import scala.io.Source

object Day10a extends App {

  val puzzle = Source.fromInputStream(getClass.getResourceAsStream("/day10.txt")).getLines.next.split(",").map(_.toInt).toSeq

  val list = (0 until 256).toArray

  var index = 0
  var skip = 0

  for (length <- puzzle) {
    val sublist = new Array[Int](length)
    for (i <- 0 until length) {
      sublist(i) = list((index + i) % list.length)
    }

    val reverseList = sublist.reverse
    for (i <- 0 until length) {
      list((index + i) % list.length) = reverseList(i)
    }

    index = (index + length + skip) % list.length
    skip += 1

//    println(list.toSeq)
  }

  println(list(0) * list(1))



}
