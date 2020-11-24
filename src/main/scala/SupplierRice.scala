import Ingredients.Rice
import javax.inject.Inject

import scala.concurrent.Future

class SupplierRice @Inject() (kitchen: Kitchen) extends Supplier {
  def supply(amount: Int): Future[Unit] = Future.successful {
    val temp: Seq[Rice.type] = Seq.fill(amount)(kitchen.rice)
    kitchen.riceSeq = kitchen.riceSeq ++ temp
  }
}
