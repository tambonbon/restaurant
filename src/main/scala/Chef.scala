import Ingredients.{Carrot, ChickenLeg, Rice}

class Chef (kitchen: Kitchen, supplier: Supplier)  {
//  val kitchen  = new Kitchen
//  val supplier = new Supplier(kitchen)
  def cook(): Dish = {
    if (kitchen.carrotSeq.size < 5) supplier.supply[Carrot.type](10)
    if (kitchen.chickenSeq.size < 1) supplier.supply[ChickenLeg.type](2)
    if (kitchen.riceSeq.size < 20) supplier.supply[Rice.type](50)

    kitchen.carrotSeq  = kitchen.carrotSeq.drop(5)
    kitchen.chickenSeq = kitchen.chickenSeq.drop(1)
    kitchen.riceSeq    = kitchen.riceSeq.drop(20)
    Dish(kitchen.carrotSeq,kitchen.chickenSeq, kitchen.riceSeq)

  }
}
