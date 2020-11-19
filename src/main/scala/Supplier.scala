import Ingredients.{Carrot, ChickenLeg, Rice}

import scala.reflect.runtime.universe._
class Supplier {
  val kitchen = new Kitchen
  def supply[A: TypeTag](amount: Int) = typeOf[A] match {
    case x if x =:= typeOf[Carrot.type] => {
      val temp: Seq[Carrot.type] = Seq.fill(amount)(kitchen.carrot)
      kitchen.carrotSeq ++:  temp
    }
    case x if x =:= typeOf[ChickenLeg.type] => {
      val temp: Seq[ChickenLeg.type] = Seq.fill(amount)(kitchen.chickenLeg)
      kitchen.chickenSeq ++ temp
    }
    case x if x =:= typeOf[Rice.type] => {
      val temp: Seq[Rice.type] = Seq.fill(amount)(kitchen.rice)
      kitchen.riceSeq ++ temp
    }
  }
}

  //https://gist.github.com/jkpl/5279ee05cca8cc1ec452fc26ace5b68b