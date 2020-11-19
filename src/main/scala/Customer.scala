import scala.util.Random

class Customer (waiter: Waiter) {
//  val waiter = new Waiter
  def order(): Seq[Dish] = {
    val numberOfOrders = Random.nextInt(5)
    println(s"We have $numberOfOrders order(s)")
    Seq.fill(numberOfOrders)(waiter.order())
  }
}
