import Ingredients.Carrot

class SupplierTest extends UnitTest ("Supplier"){
  it must "supply to appropriate ingredients" in {
    val supplier = new Supplier
    val carrot = supplier.supply(5)[Carrot.type]

  }
}
