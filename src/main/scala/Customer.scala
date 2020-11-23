import javax.inject.Inject

import scala.concurrent.Future


trait Customer {
  def order(): Seq[Future[Dish]]
}
class CustomerImpl @Inject() (waiter: Waiter, generator: RandomNumberGenerator) extends Customer {
  def order(): Seq[Future[Dish]] = {
    val num = generator.generate()
    println(s"We have $num order(s)")
    Seq.fill(num)(waiter.order())
  }
}
object Customer {
  def apply(waiter: Waiter, generator: RandomNumberGenerator): Customer = new CustomerImpl(waiter, generator)
}