package either01

fun main(args: Array<String>) {
  println(mean(listOf(1.0, 2.0, 3.0, 4.0)))
  println(mean(listOf()))
}

fun mean(list: List<Double>): Double {
  return list.sum() / list.size
}