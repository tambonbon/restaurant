class KitchenTest extends UnitTest ("Kitchen"){
  it must "have enough initial Carrot" in {
    val kitchen = new Kitchen
    kitchen.carrotSeq.size mustBe 10
  }
  it must "have enough initial Chicken leg" in {
    val kitchen = new Kitchen
    kitchen.chickenSeq.size mustBe 2
  }
  it must "have enough initial Rice" in {
    val kitchen = new Kitchen
    kitchen.riceSeq.size mustBe 50
  }
}
