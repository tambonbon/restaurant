import Ingredients.{Carrot, ChickenLeg, Rice}

class ChefTest extends UnitTest ("Chef"){
  it must "cook Carrot" in {
    val kitchen  = new Kitchen
    val supplier = new Supplier(kitchen)
    val chef     = new Chef(kitchen, supplier)
    kitchen.carrotSeq.size mustBe 10 //for referencing initial value
    chef.cook()
    kitchen.carrotSeq.size mustBe 5
  }

  it must "cook Chicken" in {
    val kitchen  = new Kitchen
    val supplier = new Supplier(kitchen)
    val chef     = new Chef(kitchen, supplier)
    kitchen.chickenSeq.size mustBe 2
    chef.cook()
    kitchen.chickenSeq.size mustBe 1
  }
  it must "cook Rice" in {
    val kitchen  = new Kitchen
    val supplier = new Supplier(kitchen)
    val chef     = new Chef(kitchen, supplier)
    kitchen.riceSeq.size mustBe 50
    chef.cook()
    kitchen.riceSeq.size mustBe 30
  }

  it must "cook Dish" in {
    val kitchen  = new Kitchen
    val supplier = new Supplier(kitchen)
    val chef     = new Chef(kitchen, supplier)
    chef.cook() mustBe Dish(kitchen.carrotSeq, kitchen.chickenSeq,kitchen.riceSeq)
  }

  it must "ask for Carrot supply" in {
    val carrot   = Carrot
    val kitchen  = new Kitchen
    val supplier = new Supplier(kitchen)
    val chef     = new Chef(kitchen, supplier)
    kitchen.carrotSeq = Seq.fill(4)(carrot)
    chef.cook()
    kitchen.carrotSeq.size mustBe 9
  }
  it must "ask for Chicken leg supply" in {
    val chickenLeg = ChickenLeg
    val kitchen    = new Kitchen
    val supplier   = new Supplier(kitchen)
    val chef       = new Chef(kitchen, supplier)
    kitchen.chickenSeq = Seq.fill(0)(chickenLeg)
    chef.cook()
    kitchen.chickenSeq.size mustBe 1
  }
  it must "ask for Rice supply" in {
    val rice     = Rice
    val kitchen  = new Kitchen
    val supplier = new Supplier(kitchen)
    val chef     = new Chef(kitchen, supplier)
    kitchen.riceSeq = Seq.fill(10)(rice)
    chef.cook()
    kitchen.riceSeq.size mustBe 40
  }
}
