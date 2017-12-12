import scala.io.Source

object Day10b extends App {

  val puzzle = Source.fromInputStream(getClass.getResourceAsStream("/day10.txt")).getLines.next.toCharArray.map(_.toInt).toSeq
  val lengths = puzzle ++ Seq(17, 31, 73, 47, 23)

  val list = (0 until 256).toArray

  var index = 0
  var skip = 0

  for (_ <- 0 until 64) {
    for (length <- lengths) {
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
    }
  }

  println(list.sliding(16, 16).flatMap(_.reduce(_ ^ _).toHexString.reverse.padTo(2,"0").reverse).mkString)
}
