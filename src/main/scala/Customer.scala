

trait RandomNumberGenerator {
  def generate(): Int
}

class Customer (waiter: Waiter, generator: Int) {
//  val waiter = new Waiter
  def order(): Seq[Dish] = {
    println(s"We have $generator order(s)")
    Seq.fill(generator)(waiter.order())
  }
}
