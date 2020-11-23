import com.google.inject.AbstractModule

class MyModule extends AbstractModule {
  override def configure(): Unit = {
    binder.bind(classOf[KitchenTrait]).to(classOf[Kitchen])
    binder.bind(classOf[Supplier]).to(classOf[SupplierImpl])
    binder.bind(classOf[Chef]).to(classOf[ChefImpl])
    binder.bind(classOf[Waiter]).to(classOf[WaiterImpl])
    binder.bind(classOf[Customer]).to(classOf[CustomerImpl])
    binder.bind(classOf[RandomNumberGenerator]).to(classOf[RandomNumberGeneratorImpl])
  }
}

