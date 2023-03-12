package either05

fun main(args: Array<String>) {
  var result = addThreeToMeanOf(listOf())
  printResult(result)

  result = addThreeToMeanOf(listOf(1.0, 2.0, 3.0, 4.0))
  printResult(result)


  // result = addThreeToMeanOfViaMap(listOf())
  // printResult(result)

  // result = addThreeToMeanOfViaMap(listOf(1.0, 2.0, 3.0, 4.0))
  // printResult(result)

}

fun printResult(result: Either<String, Double>) {
  when(result) {
    is Left -> println("ERROR! ${result.value}")
    is Right -> println("Value: ${result.value}")
  }
}

fun addThreeToMeanOf(list: List<Double>): Either<String, Double> {
  // get the mean and add 3 to it when valid
  // default to zero if invalid
  val mean = mean(list)
  return when(mean) {
    is Left -> mean
    is Right -> Right(mean.value + 3.0)
  }
}

fun addThreeToMeanOfViaMap(list: List<Double>): Either<String, Double> {
  val mean = mean(list)
  return mean.map { it + 3.0 }
}

fun mean(list: List<Double>): Either<String, Double> {
  if (list.isEmpty()) {
    return Left("empty list is not allowed")
  }

  return Right(list.sum() / list.size)
}

sealed class Either<out E, out A>
data class Left<out E>(val value: E) : Either<E, Nothing>()
data class Right<out A>(val value: A) : Either<Nothing, A>()

fun <E, A, B> Either<E,A>.map(f: (A) -> B): Either<E, B> =
  when(this) {
    is Left -> this
    is Right -> Right(f(this.value))
  }

