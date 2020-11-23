import javax.inject.Inject

trait RandomNumberGenerator {
  def generate(): Int
}
trait Customer {
  def order(): Seq[Dish]
}
class CustomerImpl @Inject() (waiter: Waiter, generator: Int) extends Customer {
//  val waiter = new Waiter
  def order(): Seq[Dish] = {
    println(s"We have $generator order(s)")
    Seq.fill(generator)(waiter.order())
  }
}
object Customer {
  def apply(waiter: Waiter, generator: Int): Customer = new CustomerImpl(waiter, generator)
}