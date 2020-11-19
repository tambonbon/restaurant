import Ingredients.{Carrot, ChickenLeg, Rice}

class   Kitchen {
  val carrot     = Carrot
  val chickenLeg = ChickenLeg
  val rice       = Rice

  var carrotSeq : Seq[Carrot.type]     = Seq.fill(10)(carrot)
  var chickenSeq: Seq[ChickenLeg.type] = Seq.fill(2)(chickenLeg)
  var riceSeq   : Seq[Rice.type]       = Seq.fill(50)(rice) // I reduce a bit of rice for the sake of brevity

}

