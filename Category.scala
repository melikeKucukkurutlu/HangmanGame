package GamePackage

case class Category() extends Card {
  val name:String = "Category"
  val cost: Int = 5
  val availableCount: Int = 1

  override def isCardAffordable(point: Int): Boolean = {
    if (point >= 5) true else false
  }
}
