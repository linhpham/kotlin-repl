package either03

fun main(args: Array<String>) {
  println(findAverageP2PAmountsByCustomer(1))
  println(findAverageP2PAmountsByCustomer(2))
  println(findAverageP2PAmountsByCustomer(3))
}

fun mean(list: List<Double>): Double {
  if (list.isEmpty()) {
    throw IllegalArgumentException("empty list is not allowed")
  }

  return list.sum() / list.size
}

fun findP2PAmountsByCustomer(customerId: Int): List<Double> {
  // call the database, not found ->
  if (customerId == 1) {
    throw CustomerNotFound("customer id not found: $customerId")
  }

  // return the list of customer's payments, could be empty
  if (customerId == 2) {
    return listOf()
  }

  return listOf(1.0, 2.0, 3.0, 4.0)
}

class CustomerNotFound(message:String): Exception(message)


fun findAverageP2PAmountsByCustomer(customerId: Int): Double {
  try {
    val listOfAmounts = findP2PAmountsByCustomer(customerId)
    return mean(listOfAmounts)
  } catch (e: Exception) {
    println(e)
    throw e
  }
}
