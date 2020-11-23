import javax.inject.Inject


trait Customer {
  def order(): Seq[Dish]
}
class CustomerImpl @Inject() (waiter: Waiter, generator: RandomNumberGenerator) extends Customer {
//  val waiter = new Waiter
  def order(): Seq[Dish] = {
    val num = generator.generate()
    println(s"We have $num order(s)")
    Seq.fill(num)(waiter.order())
  }
}
object Customer {
  def apply(waiter: Waiter, generator: RandomNumberGenerator): Customer = new CustomerImpl(waiter, generator)
}