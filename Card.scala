package GamePackage

import scala.collection.mutable.ListBuffer

abstract class Card {
  val name: String
  val cost: Int
  val availableCount: Int
  def isCardAffordable(p: Int): Boolean

  def isCardAvailable(usedCards:ListBuffer[Card]):Boolean={
    if(usedCards.count( c => c.name == this.name)<this.availableCount)
      true
    else false
  }
}
