package Game

trait Card {
  val name:String
  val cost:Int
  var availableCount:Int


  val decrease=(x:Int) => x-1


  def isCardAvailable():Boolean ={
    if(availableCount>0) true else false

  }
  def isCardAffordable(p:Int):Boolean

  def reduceCardPoint(point:Int):Int={point-cost}



 // def useCard(word:Word)

}
