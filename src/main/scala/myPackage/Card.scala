package myPackage

abstract class Card {
  val name:String
  val cost:Int
  val availableCount:Int

  def decreaseAvailableCount()
  def isCardUsable()
  private def isCardAvailable():Boolean ={
    false

  }
  private def isCardAffordable():Boolean={
    false

  }

}
