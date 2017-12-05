object Day3a extends App {
  val puzzle = 361527

  var xloc = 0
  var yloc = 0
  var start = 1

  def getLoc(input:Int):Int = {
    var i = 1
    while(true) {
      if(i % 2 == 1) {
        xloc += i
        println(s"${start+i} ($xloc,$yloc)")
        yloc += i
      } else {
        xloc -= i
        println(s"${start+i} ($xloc,$yloc)")
        yloc -= i
      }
      start += 2*i
      println(s"$start ($xloc,$yloc)")
      if( start >= input) {

        return i
      }
      i += 1
    }
    -1 // shouldn't happen
  }

  println(getLoc(puzzle))

  println(Math.abs(-300+361803-puzzle)+ 301 +1)


}