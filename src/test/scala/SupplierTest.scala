import Ingredients.{Carrot, ChickenLeg, Rice}

class SupplierTest extends UnitTest ("Supplier"){
  it must "supply Carrot" in {
    val kitchen  = new Kitchen
    kitchen.carrotSeq.size mustBe 10
    val supplier = new Supplier(kitchen)
    supplier.supply[Carrot.type](5)
    kitchen.carrotSeq.size mustBe 15
  }
  it must "supply Chicken leg" in {
    val kitchen  = new Kitchen
    kitchen.chickenSeq.size mustBe 2
    val supplier = new Supplier(kitchen)
    supplier.supply[ChickenLeg.type](5)
    kitchen.chickenSeq.size mustBe 7
  }
  it must "supply Rice" in {
    val kitchen  = new Kitchen
    kitchen.riceSeq.size mustBe 50
    val supplier = new Supplier(kitchen)
    supplier.supply[Rice.type](5)
    kitchen.riceSeq.size mustBe 55
  }
}
