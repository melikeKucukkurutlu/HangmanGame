package GamePackage

case class Discount() extends Card {
  val name:String = "Discount"
  val cost: Int = 5
  val availableCount: Int = 2

  override def isCardAffordable(point: Int): Boolean = {
    if (point >= 5 && point < 40) true else false
  }
}
