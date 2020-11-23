import Ingredients.{Carrot, ChickenLeg, Rice}
import javax.inject.Inject

trait Chef {
  def cook(): Dish
}
class ChefImpl @Inject() (kitchen: Kitchen, supplier: Supplier) extends Chef{
  val carrotForDish    = kitchen.carrotSeq.take(5)
  val chickenLegForDish    = kitchen.chickenSeq.take(1)
  val riceForDish    = kitchen.riceSeq.take(20)

  def cook(): Dish = {
    if (kitchen.carrotSeq.size < 5) supplier.supply[Carrot.type](10)
    if (kitchen.chickenSeq.size < 1) supplier.supply[ChickenLeg.type](2)
    if (kitchen.riceSeq.size < 20) supplier.supply[Rice.type](50) //should be 5000


    kitchen.carrotSeq  = kitchen.carrotSeq.drop(5)
    kitchen.chickenSeq = kitchen.chickenSeq.drop(1)
    kitchen.riceSeq    = kitchen.riceSeq.drop(20)
//    Dish(kitchen.carrotSeq,kitchen.chickenSeq, kitchen.riceSeq)

    Dish(carrotForDish, chickenLegForDish, riceForDish)

  }
}

object Chef {
  def apply(kitchen: Kitchen, supplier: Supplier): Chef = new ChefImpl(kitchen,supplier)
}
