import scala.collection.mutable
import scala.io.Source

object Day7b extends App {

  val input = Source.fromInputStream(getClass.getResourceAsStream("/day7.txt")).getLines.toArray.toSeq

  val individualWeights = input.map(x=> (x.split(" ", 3)(0), x.split(" ", 3)(1).substring(1).reverse.substring(1).reverse.toInt)).toMap

  println(individualWeights)

  val towers:Map[String, Seq[String]] = input.filter(_.contains("->")).map(x => (x.split(" ", 2)(0), x.split(" -> ")(1).split(", ").toSeq)).toMap

  println(towers)

  val totalWeights:mutable.Map[String, Int] = new mutable.HashMap[String, Int]()

  individualWeights.filter(entry => !towers.keySet.contains(entry._1)).foreach(entry => totalWeights.put(entry._1, entry._2))

  while(totalWeights.size != individualWeights.size) {

    val towersToProcess = towers.filter(entry => entry._2.map(totalWeights.keySet.contains(_)).reduce(_ && _)).keySet

    for (key <- towersToProcess) {
      totalWeights.put(key, towers.get(key).get.map(totalWeights.get(_).get).sum + individualWeights.get(key).get)
    }
  }

  println(totalWeights)

  val towerWeights:Map[(String, Int), Seq[(String, Int)]] = towers.map(entry => ((entry._1, totalWeights.get(entry._1).get), entry._2.map(towerId => (towerId, totalWeights.get(towerId).get))))

  towerWeights.foreach(println)

  println()

  towerWeights.filterNot(_._2.map(_._2).toSet.size == 1).foreach(println)




}
