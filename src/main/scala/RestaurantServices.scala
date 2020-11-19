trait RestaurantServices {
  val kitchen  = new Kitchen
  val supplier = new Supplier(kitchen)
  val chef     = new Chef(kitchen, supplier)
  val waiter   = new Waiter(chef)
  val customer = new Customer(waiter)
}
