
class Waiter (chef: Chef) {
//  val chef = new Chef
  def order(): Dish = chef.cook()
}
