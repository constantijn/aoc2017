
import scala.collection.mutable
import scala.io.Source

object Day8a extends App {
  val input = Source.fromInputStream(getClass.getResourceAsStream("/day8.txt")).getLines.toArray.toSeq
  val registers = new mutable.HashMap[String,Int]()

  var max = 0

  input.foreach(line => {
    val parts = line.split(" ")
    val registerToUpdate = parts(0)
    val registerCurrentValue = registers.getOrElse(registerToUpdate, 0)
    val amount = if (parts(1) == "dec") - parts(2).toInt else parts(2).toInt
    val registerToCheck = parts(4)
    val checkOperator = parts(5)
    val valueToCheckAgainst = parts(6).toInt

    val conditionMet = checkOperator match {
      case "==" => registers.getOrElse(registerToCheck, 0) == valueToCheckAgainst
      case "<" => registers.getOrElse(registerToCheck, 0) < valueToCheckAgainst
      case ">" => registers.getOrElse(registerToCheck, 0) > valueToCheckAgainst
      case "<=" => registers.getOrElse(registerToCheck, 0) <= valueToCheckAgainst
      case ">=" => registers.getOrElse(registerToCheck, 0) >= valueToCheckAgainst
      case "!=" => registers.getOrElse(registerToCheck, 0) != valueToCheckAgainst
      case _ => throw new RuntimeException("Boom")
    }
    if(conditionMet) {
      registers.put(registerToUpdate, registerCurrentValue + amount)
      max = Math.max(max, registerCurrentValue + amount)
    }
  })


  println(registers.values.max)
  println(max)



}
