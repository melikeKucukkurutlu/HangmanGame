package GamePackage

case class Risk() extends Card {
  val name:String = "Risk"
  val cost: Int = 8
  val availableCount: Int = 2

  override def isCardAffordable(point: Int): Boolean = {
    if (point > 25 && point < 50) true else false
  }
}
