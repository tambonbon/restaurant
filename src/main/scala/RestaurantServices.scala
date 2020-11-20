trait RestaurantServices {
  val kitchen  = new Kitchen
  val supplier = new Supplier(kitchen)
  val chef     = new Chef(kitchen, supplier)
  val waiter   = new Waiter(chef)
  val numberofOrders = new RandomNumberGenerator {
    override def generate(): Int = util.Random.between(1,6)
  }
  val customer = new Customer(waiter, numberofOrders.generate())
}
