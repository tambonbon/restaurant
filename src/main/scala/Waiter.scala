
class Waiter {
  val chef = new Chef
  def order(): Dish = chef.cook()
}
