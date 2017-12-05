import scala.collection.mutable

object Day3b extends App {
  val puzzle = 361527

  var xloc = 0
  var yloc = 0

  val grid = new mutable.HashMap[(Int,Int), Int]()
  grid.put((0,0), 1)

  def fillSquare(x:Int, y:Int):Unit = {
    if(grid.get((x,y)).isDefined) return
    val gridValue =
      grid.getOrElse((x-1, y  ),0) +
      grid.getOrElse((x-1, y-1),0) +
      grid.getOrElse((x  , y-1),0) +
      grid.getOrElse((x+1, y-1),0) +
      grid.getOrElse((x+1, y  ),0) +
      grid.getOrElse((x+1, y+1),0) +
      grid.getOrElse((x  , y+1),0) +
      grid.getOrElse((x-1, y+1),0)
    println(s"${(x,y)}, $gridValue")
    grid.put((x,y), gridValue)
    if(gridValue > puzzle) {
      println("Done")
      System.exit(0)
    }
  }

  def fillGrid():Unit = {
    var i = 1
    while(true) {
      if(i % 2 == 1) {
        println(s"x1 $xloc to ${xloc+i}")
        for (j <- xloc+1 to xloc+i) fillSquare(j, yloc)
        xloc += i
        println(s"corner ($xloc,$yloc)")
        println(s"y1 $yloc to ${yloc+i}")
        for (j <- yloc+1 to yloc+i) fillSquare(xloc, j)
        yloc += i
      } else {
        println(s"x0 $xloc to ${xloc-i}")
        for (j <- (xloc-i to xloc-1).reverse) fillSquare(j, yloc)
        xloc -= i
        println(s"corner ($xloc,$yloc)")
        println(s"y0 $yloc to ${yloc-i}")
        for (j <- (yloc-i to yloc-1).reverse) fillSquare(xloc, j)

        yloc -= i
      }
      println(s"corner ($xloc,$yloc)")
      i += 1
    }
  }

  fillGrid()



}