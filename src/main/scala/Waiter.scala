import javax.inject.Inject

import scala.concurrent.Future

trait Waiter {
  def order(): Future[Dish]
}
class WaiterImpl @Inject() (chef: Chef) extends Waiter {
  def order(): Future[Dish] = chef.cook()
}
object Waiter {
  def apply(chef: Chef): Waiter = new WaiterImpl(chef)
}