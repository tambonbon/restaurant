trait RandomNumberGenerator {
  def generate(): Int
}

class RandomNumberGeneratorImpl extends RandomNumberGenerator {
  override def generate(): Int = scala.util.Random.between(1,6)
}

object RandomNumberGenerator {
  def apply(): RandomNumberGenerator = new RandomNumberGeneratorImpl
}
//object RandomNumberGenerator