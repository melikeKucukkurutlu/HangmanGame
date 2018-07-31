package GamePackage

case class BuyALetter(position: Int) extends Card {
  val name:String = "Buy A Letter"
  val cost: Int = 20
  val availableCount: Int = 1

  override def isCardAffordable(point: Int): Boolean = {
    if (point >= 20) true else false
  }
}
