import java.util

import scala.io.Source

object Day12 extends App {
  val input = Source.fromInputStream(getClass.getResourceAsStream("/day12.txt")).getLines
  val puzzle:Map[Int, Array[Int]] = input.map(_.split(" <-> ")).map(x => (x(0).toInt, x(1).split(", ").map(_.toInt))).toMap

  val visited = new util.ArrayList[Int]()

  def add(id:Int):Unit= {
    visited.add(id)
    puzzle.get(id).get.filter(!visited.contains(_)).foreach(add(_))
  }

  add(0)
  println("a: " + visited.size)

  var groups = 1

  while(visited.size < puzzle.size) {
    add(puzzle.keys.filterNot(visited.contains(_)).head)
    groups += 1
  }

  println("b: " + groups)

}
