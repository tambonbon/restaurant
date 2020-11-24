import Ingredients.{Carrot, ChickenLeg, Rice}
import org.mockito.Mockito.{atLeastOnce, verify}
import org.mockito.MockitoSugar.{mock, when}

import scala.concurrent.Future

class CustomerTest extends UnitTest ("Customer"){
  it must "order something" in {
    val carrot     = Carrot
    val chickenLeg = ChickenLeg
    val rice       = Rice

    val customer = mock[Customer] // should I create a 'puppet' customer to test him?
    val dish = Seq(Future.successful(Dish(Seq(carrot),Seq(chickenLeg),Seq(rice))))
    val orders = customer.order()
    when(orders).thenReturn(dish) // stubbing
    verify(orders, atLeastOnce())
  }
  it must "order something for a chef to cook" in {
    val carrot     = Carrot
    val chickenLeg = ChickenLeg
    val rice       = Rice
    val dish = Seq(Future.successful(Dish(Seq(carrot),Seq(chickenLeg),Seq(rice))))

    val chef     = mock[Chef]
    val cook = chef.cook()
    when(cook).thenReturn(dish.head) // stubbing
    val customer = mock[Customer] // should I create a 'puppet'?
    val orders = customer.order()
    when(orders).thenReturn(dish) // stubbing
    verify(orders).equals(cook)
  }

}
