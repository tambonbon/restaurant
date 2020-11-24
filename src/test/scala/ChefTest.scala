import Ingredients.{Carrot, ChickenLeg, Rice}

class ChefTest extends UnitTest ("Chef"){
  it must "cook Carrot" in {
    val kitchen  = new Kitchen
//    val supplier = new SupplierImpl(kitchen)
    val supplierCarrot = new SupplierCarrot(kitchen)
    val supplierChickenLeg = new SupplierChickenLeg(kitchen)
    val supplierRice = new SupplierRice(kitchen)
    val chef     = new ChefImpl(kitchen, supplierCarrot, supplierChickenLeg, supplierRice)
    kitchen.carrotSeq.size mustBe 10 //for referencing initial value
    val dish = chef.cook()
    chef.carrotForDish.size mustBe 5
    kitchen.carrotSeq.size mustBe 5
  }

  it must "cook Chicken" in {
    val kitchen  = new Kitchen
    val supplierCarrot = new SupplierCarrot(kitchen)
    val supplierChickenLeg = new SupplierChickenLeg(kitchen)
    val supplierRice = new SupplierRice(kitchen)
    val chef     = new ChefImpl(kitchen, supplierCarrot, supplierChickenLeg, supplierRice)
    kitchen.chickenSeq.size mustBe 2
    chef.cook()
    kitchen.chickenSeq.size mustBe 1
  }
  it must "cook Rice" in {
    val kitchen  = new Kitchen
    val supplierCarrot = new SupplierCarrot(kitchen)
    val supplierChickenLeg = new SupplierChickenLeg(kitchen)
    val supplierRice = new SupplierRice(kitchen)
    val chef     = new ChefImpl(kitchen, supplierCarrot, supplierChickenLeg, supplierRice)
    kitchen.riceSeq.size mustBe 50
    val dish = chef.cook()
    chef.riceForDish.size mustBe 20
    kitchen.riceSeq.size mustBe 30
  }

//  it must "cook Dish" in {
//    val kitchen  = new Kitchen
//    val supplier = new Supplier(kitchen)
//    val chef     = Chef(kitchen, supplier)
//    val dish = chef.cook()
//    dish mustBe Dish()
//  }

  it must "ask for Carrot supply" in {
    val carrot   = Carrot
    val kitchen  = new Kitchen
    val supplierCarrot = new SupplierCarrot(kitchen)
    val supplierChickenLeg = new SupplierChickenLeg(kitchen)
    val supplierRice = new SupplierRice(kitchen)
    val chef     = new ChefImpl(kitchen, supplierCarrot, supplierChickenLeg, supplierRice)
    kitchen.carrotSeq = Seq.fill(4)(carrot)
    chef.cook()
    kitchen.carrotSeq.size mustBe 9
  }
  it must "ask for Chicken leg supply" in {
    val chickenLeg = ChickenLeg
    val kitchen    = new Kitchen
    val supplierCarrot = new SupplierCarrot(kitchen)
    val supplierChickenLeg = new SupplierChickenLeg(kitchen)
    val supplierRice = new SupplierRice(kitchen)
    val chef     = new ChefImpl(kitchen, supplierCarrot, supplierChickenLeg, supplierRice)
    kitchen.chickenSeq = Seq.fill(0)(chickenLeg)
    chef.cook()
    kitchen.chickenSeq.size mustBe 1
  }
  it must "ask for Rice supply" in {
    val rice     = Rice
    val kitchen  = new Kitchen
    val supplierCarrot = new SupplierCarrot(kitchen)
    val supplierChickenLeg = new SupplierChickenLeg(kitchen)
    val supplierRice = new SupplierRice(kitchen)
    val chef     = new ChefImpl(kitchen, supplierCarrot, supplierChickenLeg, supplierRice)
    kitchen.riceSeq = Seq.fill(10)(rice)
    chef.cook()
    kitchen.riceSeq.size mustBe 40
  }
}
