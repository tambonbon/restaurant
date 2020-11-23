
class Waiter (chef: Chef) {
//  val chef = Chef
  def order(): Dish = chef.cook()
}
