import Ingredients.{Carrot, ChickenLeg, Rice}
import org.mockito.Mockito.{times, verify, when}
import org.mockito.MockitoSugar.mock

import scala.concurrent.Future

class WaiterTest extends UnitTest ("Waiter") {
  it must "give order to chef to cook" in {
    val carrot     = Carrot
    val chickenLeg = ChickenLeg
    val rice       = Rice

    val chef     = mock[Chef] // not real chefcreate a puppet,
    val dish = Future.successful(Dish(Seq(carrot),Seq(chickenLeg),Seq(rice)))
    when (chef.cook()).thenReturn(dish) // tell that puppet what it should do when cook is called
    // onwards, chef cook returns a dish (fake behaviour)
    val waiter   = new WaiterImpl(chef) // test the waiter works as expected (real waiter)
    val order = waiter.order()
    order mustBe dish
    verify(chef, times(1)).cook()
    // verify that chef cooks only 1 dish --> important
    // DI --><-- Testing
  }


}
