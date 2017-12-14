object Day14 extends App {

  val puzzle = "xlqgujun"

  def knotHash(input:String) = {
    val lengths = input.toCharArray.map(_.toInt).toSeq ++ Seq(17, 31, 73, 47, 23)

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

    list.sliding(16, 16).flatMap(_.reduce(_ ^ _).toHexString.reverse.padTo(2,"0").reverse).mkString
  }

  def hex2bits(char: Char):String = {
    char match {
      case '0' => "0000"
      case '1' => "0001"
      case '2' => "0010"
      case '3' => "0011"
      case '4' => "0100"
      case '5' => "0101"
      case '6' => "0110"
      case '7' => "0111"
      case '8' => "1000"
      case '9' => "1001"
      case 'a' => "1010"
      case 'b' => "1011"
      case 'c' => "1100"
      case 'd' => "1101"
      case 'e' => "1110"
      case 'f' => "1111"
    }
  }

  val grid:Array[Array[Int]] = (0 to 127).toArray.map(i => knotHash(s"$puzzle-" + i)).map(_.toCharArray.map(hex2bits).mkString).map(_.toCharArray.map(_ - '0'))

  println("Part1: " + grid.map(_.sum).sum)

  var regionCount = 0

  def markRegion(i:Int, j:Int): Unit = {
    grid(i)(j) = 2
    try {
      if(grid(i-1)(j) == 1) markRegion(i-1, j)
    } catch {
      case _:ArrayIndexOutOfBoundsException => // do nothing
    }
    try {
      if(grid(i+1)(j) == 1) markRegion(i+1, j)
    } catch {
      case _:ArrayIndexOutOfBoundsException => // do nothing
    }
    try {
      if(grid(i)(j-1) == 1) markRegion(i, j-1)
    } catch {
      case _:ArrayIndexOutOfBoundsException => // do nothing
    }
    try {
      if(grid(i)(j+1) == 1) markRegion(i, j+1)
    } catch {
      case _:ArrayIndexOutOfBoundsException => // do nothing
    }
  }

  for (i <- 0 to 127) {
    for (j <- 0 to 127) {
      val cell = grid(i)(j)
      if (cell == 1) {
        regionCount += 1
        markRegion(i,j)
      }
    }
  }

  println("Part2: " + regionCount)
}
