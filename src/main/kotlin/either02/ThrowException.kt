package either02

fun main(args: Array<String>) {
  try {
    println(mean(listOf(1.0, 2.0, 3.0, 4.0)))
    println(mean(listOf()))
  } catch (e: Exception) {
    println(e)
  }
}

fun mean(list: List<Double>): Double {
  if (list.isEmpty()) {
    throw IllegalArgumentException("empty list is not allowed")
  }

  return list.sum() / list.size
}
