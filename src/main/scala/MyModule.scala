import com.google.inject.AbstractModule
import net.codingwell.scalaguice.ScalaModule

class MyModule extends AbstractModule with ScalaModule {
  def configure(): Unit = {
    bind[Chef].to[DefaultChef].in[Singleton]
  }
}
