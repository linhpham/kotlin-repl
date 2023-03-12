import arrow.core.Either
import arrow.core.getOrElse
import arrow.core.left
import arrow.core.right

fun main(args: Array<String>) {
  testEither()

}

fun testEither() {
  val b = Either.Left(5)
  println("b.value = ${b.value}")
  println("b.getOrElse = ${b.getOrElse { "ERROR!" }}")
  println("b.right = ${b.right()}")

  val c = b.right().map { it -> println("inside map $it"); it }
  println("c = $c")

  val d = Exception("abc").left()
  println("d = $d")


}
