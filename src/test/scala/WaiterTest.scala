class WaiterTest extends UnitTest ("Waiter") {
  it must "give order to chef to cook" in {
    val kitchen  = new Kitchen
    kitchen.carrotSeq.size mustBe 10
    kitchen.chickenSeq.size mustBe 2
    kitchen.riceSeq.size mustBe 50
    val supplier = new Supplier(kitchen)
    val chef     = new Chef(kitchen, supplier)
    val waiter   = new Waiter(chef)
//    waiter.order() mustBe chef.cook()
    waiter.order()
    kitchen.carrotSeq.size mustBe 5
    kitchen.chickenSeq.size mustBe 1
    kitchen.riceSeq.size mustBe 30
  }


}
