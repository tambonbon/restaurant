package models

import models.Ingredients.{Carrot, ChickenLeg, Rice}

case class Dish(carrot: Seq[Carrot.type], chickenLeg: Seq[ChickenLeg.type], rice: Seq[Rice.type])
