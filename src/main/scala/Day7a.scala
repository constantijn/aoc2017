import scala.io.Source

object Day7a extends App {

  val input = Source.fromInputStream(getClass.getResourceAsStream("/day7.txt")).getLines.toArray.toSeq

  val allNodes:Seq[String] = input.map(_.split(" ", 2)(0))
  val childNodes:Seq[String] = input.filter(_.contains("->")).flatMap(_.split(" -> ")(1).split(", "))

  println(allNodes.filter(!childNodes.contains(_)))

}
