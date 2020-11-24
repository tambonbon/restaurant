import Ingredients.ChickenLeg
import javax.inject.Inject

import scala.concurrent.Future

class SupplierChickenLeg @Inject() (kitchen: Kitchen) extends Supplier {
  def supply(amount: Int): Future[Unit] = Future.successful {
    val temp: Seq[ChickenLeg.type] = Seq.fill(amount)(kitchen.chickenLeg)
    kitchen.chickenSeq = kitchen.chickenSeq ++ temp
  }
}
