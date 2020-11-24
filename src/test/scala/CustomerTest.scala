import Ingredients.{Carrot, ChickenLeg, Rice}
import org.mockito.MockitoSugar.{mock, when}

import scala.concurrent.Future

class CustomerTest extends UnitTest ("Customer"){
  it must "order something for the waiter" in {
    val carrot     = Carrot
    val chickenLeg = ChickenLeg
    val rice       = Rice
    val waiter     = mock[Waiter] // we mock a puppet waiter
    val random     = new RandomNumberGeneratorImpl
    val customer =  new CustomerImpl(waiter, random)
//    val dish = Seq(Future.successful(Dish(Seq(carrot),Seq(chickenLeg),Seq(rice))))
    customer.order().size must be > 0
//    when(orders).thenReturn(dish) // stubbing
//    verify(orders, atLeastOnce())
  }
  it must "order something for a chef to cook" in {
    val carrot     = Carrot
    val chickenLeg = ChickenLeg
    val rice       = Rice
    val dish = Seq(Future.successful(Dish(Seq(carrot),Seq(chickenLeg),Seq(rice))))

    val chef     = mock[Chef]
    val cook = chef.cook()
    when(cook).thenReturn(dish.head) // stubbing

    val waiter     = mock[Waiter] // we mock a puppet waiter
    val random     = new RandomNumberGeneratorImpl {
      override def generate(): Int = 1
    }

    val customer = new CustomerImpl(waiter, random)
    val orders = customer.order()
    orders mustBe dish.head
  }

}
