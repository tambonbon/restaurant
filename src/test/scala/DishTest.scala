import Ingredients.{Carrot, ChickenLeg, Rice}
import org.scalatest.Inside.inside

class DishTest extends UnitTest ("Dish") {
  it must "have appropriate ingredients " in {
    val dish = Dish(Seq(Carrot), Seq(ChickenLeg), Seq(Rice))
    inside (dish) { case Dish(Seq(rottenCarrot), Seq(spoiledChickenLeg), Seq(overnightRice)) =>
      rottenCarrot mustBe Carrot
      spoiledChickenLeg mustBe ChickenLeg
      overnightRice mustBe Rice
    }
  }
}
