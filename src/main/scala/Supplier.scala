import Ingredients.{Carrot, ChickenLeg, Rice}
import javax.inject.Inject

import scala.reflect.runtime.universe._
trait Supplier {
  def supply[A: TypeTag](amount: Int): Unit
}
class SupplierImpl @Inject() (kitchen: Kitchen) extends Supplier {
//  val kitchen = new Kitchen
  def supply[A: TypeTag](amount: Int): Unit = typeOf[A] match {
    case x if x =:= typeOf[Carrot.type] => {
      val temp: Seq[Carrot.type] = Seq.fill(amount)(kitchen.carrot)
      kitchen.carrotSeq = kitchen.carrotSeq ++  temp
    }
    case x if x =:= typeOf[ChickenLeg.type] => {
      val temp: Seq[ChickenLeg.type] = Seq.fill(amount)(kitchen.chickenLeg)
      kitchen.chickenSeq = kitchen.chickenSeq ++ temp
    }
    case x if x =:= typeOf[Rice.type] => {
      val temp: Seq[Rice.type] = Seq.fill(amount)(kitchen.rice)
      kitchen.riceSeq = kitchen.riceSeq ++ temp
    }
  }
}

object Supplier {
  def apply(kitchen: Kitchen): Supplier =  new SupplierImpl(kitchen)
}
  //https://gist.github.com/jkpl/5279ee05cca8cc1ec452fc26ace5b68b