trait RestaurantServices {
  val kitchen  = new Kitchen
  val supplier = new SupplierImpl(kitchen)
  val chef     = new ChefImpl(kitchen, supplier)
  val waiter   = new WaiterImpl(chef)
  val numberofOrders = new RandomNumberGenerator {
    override def generate(): Int = util.Random.between(1,6)
  }
//  val customer = new CustomerImpl(waiter, numberofOrders.generate())
}
