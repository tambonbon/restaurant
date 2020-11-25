import com.google.inject.Guice

object Main {
  def main(args: Array[String]): Unit = {

//    println(customer.order())
    val injector = Guice.createInjector(new MyModule)
    val customer = injector.getInstance(classOf[CustomerImpl])
    val order    = customer.order()
    println(order)
    if (order == null) {
      throw new AssertionError()
    } else {
      println("it worked")
    }
  }
}
