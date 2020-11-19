

class CustomerTest extends UnitTest ("Customer"){
  it must "order something" in {
    val kitchen  = new Kitchen
    val supplier = new Supplier(kitchen)
    val chef     = new Chef(kitchen, supplier)
    val waiter   = new Waiter(chef)
    val customer = new Customer(waiter)
    customer.order().size must be >  0
  }
  it must "order something that is a Dish" in {
    val kitchen  = new Kitchen
    val supplier = new Supplier(kitchen)
    val chef     = new Chef(kitchen, supplier)
    val waiter   = new Waiter(chef)
    val customer = new Customer(waiter)
    customer.order().
  }
}
