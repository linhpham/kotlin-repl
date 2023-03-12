package either04

fun main(args: Array<String>) {
  println(mean(listOf()))
  println(mean(listOf(1.0, 2.0, 3.0, 4.0)))


}

// TODO: Convert me!
fun mean(list: List<Double>): Double {
  if (list.isEmpty()) {
    throw IllegalArgumentException("empty list is not allowed")
  }

  return list.sum() / list.size
}

sealed class Either<out E, out A>
data class Left<out E>(val value: E) : Either<E, Nothing>()
data class Right<out A>(val value: A) : Either<Nothing, A>()
