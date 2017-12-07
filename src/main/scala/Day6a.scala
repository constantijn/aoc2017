import scala.collection.mutable

object Day6a extends App {

//  val input = "0\t2\t7\t0"
  val input = "0\t5\t10\t0\t11\t14\t13\t4\t11\t8\t8\t7\t1\t4\t12\t11"
  val state:Array[Int] = input.split('\t').map(_.toInt)

  val alreadySeen = new mutable.HashSet[String]()
  alreadySeen.add(state.mkString("-"))

  println(state.toSeq)

  var rounds = 0

  while(true) {
    rounds = rounds + 1
    var highestVal = -1
    var highestIndex = -1

    for (i <- 0 until state.length) {
      if (state(i) > highestVal) {
        highestVal = state(i)
        highestIndex = i
      }
    }

    println(s"HighestIndex: $highestIndex HighestVal: $highestVal")

    state(highestIndex) = 0

    for (i <- 1 to highestVal) {
      val arrayIndex = (highestIndex + i) % state.length
      state(arrayIndex) = state(arrayIndex) + 1
    }

    println(state.toSeq)

    if (alreadySeen.contains(state.mkString("-"))) {
      println("Done: " + rounds)
      System.exit(0)
    } else {
      alreadySeen.add(state.mkString("-"))
    }

  }

}
