package either06
//
// fun main(args: Array<String>) {
//   println(findAverageP2PAmountsByCustomer(1))
//   println(findAverageP2PAmountsByCustomer(2))
//   println(findAverageP2PAmountsByCustomer(3))
// }
//
// fun mean(list: List<Double>): Either<String, Double> {
//   if (list.isEmpty()) {
//     return Left("empty list is not allowed")
//   }
//
//   return Right(list.sum() / list.size)
// }
//
// fun findP2PAmountsByCustomer(customerId: Int): Either<String, List<Double>> {
//   // call the database, not found ->
//   if (customerId == 1) {
//     Left("customer id not found: $customerId")
//   }
//
//   // return the list of customer's payments, could be empty
//   if (customerId == 2) {
//     return Right(listOf())
//   }
//
//   return Right(listOf(1.0, 2.0, 3.0, 4.0))
// }
//
// // class CustomerNotFound(message:String): Exception(message)
//
//
// fun findAverageP2PAmountsByCustomer(customerId: Int): Either<String, Double> {
//   val listOfAmounts = findP2PAmountsByCustomer(customerId)
//   return listOfAmounts.flatMap { mean(it) }
// }
//
// sealed class Either<out E, out A>
// data class Left<out E>(val value: E) : Either<E, Nothing>()
// data class Right<out A>(val value: A) : Either<Nothing, A>()
//
// fun <E, A, B> Either<E,A>.map(f: (A) -> B): Either<E, B> =
//   when(this) {
//     is Left -> this
//     is Right -> Right(f(this.value))
//   }
//
// fun <E, A, B> Either<E, A>.flatMap(f: (A) -> Either<E, B>): Either<E, B> =
//   when (this) {
//     is Left -> this
//     is Right -> f(this.value)
//   }
