import Ingredients.Carrot
import javax.inject.Inject

import scala.concurrent.Future

class SupplierCarrot @Inject() (kitchen: Kitchen) extends Supplier {
  def supply(amount: Int): Future[Unit] = Future.successful {
    val temp: Seq[Carrot.type] = Seq.fill(amount)(kitchen.carrot)
    kitchen.carrotSeq = kitchen.carrotSeq ++  temp
  }
}
