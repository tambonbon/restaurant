import com.google.inject.Guice

object Main{
  def main(args: Array[String]): Unit = {
    val injector = Guice.createInjector(new MyModule)
    val customer = injector.getInstance(classOf[CustomerImpl])

    if (customer.order() == null) {
      throw new AssertionError()
    } else {
      println("it worked")
    }

//    println(customer.order())

  }

}
