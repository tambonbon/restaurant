
object Main extends App{
  val customer = new Customer
  val waiter   = new Waiter
  val chef     = new Chef

  println(customer.order())

}
