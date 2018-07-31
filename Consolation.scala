package GamePackage

case class Consolation() extends Card {
  val name:String = "Consolation"
  val cost: Int = 5
  val availableCount: Int = 1

  override def isCardAffordable(point: Int): Boolean = {
    if (point >= 5) true else false
  }

}
