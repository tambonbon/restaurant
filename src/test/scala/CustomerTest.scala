

class CustomerTest extends UnitTest ("Customer"){
  it must "order something" in {
    val kitchen  = new Kitchen
    val supplier = new SupplierImpl(kitchen)
    val chef     = Chef(kitchen, supplier)
    val waiter   = new WaiterImpl(chef)
    val random   = new RandomNumberGenerator {
      override def generate(): Int = util.Random.between(1,6)
    }
    val customer = new CustomerImpl(waiter, random)
    customer.order().size must be >  0
  }
  it must "order something that is a Dish" in {
    val kitchen  = new Kitchen
    val supplier = new SupplierImpl(kitchen)
    val chef     = new ChefImpl(kitchen, supplier)
    val waiter   = new WaiterImpl(chef)
    val random   = new RandomNumberGenerator {
      override def generate(): Int = 1
    }
    val customer = new CustomerImpl(waiter, random)
    val cook = chef.cook()
    customer.order().head mustBe Dish(chef.carrotForDish,(chef.chickenLegForDish),(chef.riceForDish))
  }
}
