import javax.inject.Inject

trait Waiter {
  def order(): Dish
}
class WaiterImpl @Inject() (chef: Chef) extends Waiter {
//  val chef = Chef
  def order(): Dish = chef.cook()
}
object Waiter {
  def apply(chef: Chef): Waiter = new WaiterImpl(chef)
}