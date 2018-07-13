package myPackage

trait Card {
  val name:String
  val cost:Int
  var availableCount:Int

 /* def decreaseAvailableCount():Int={
    availableCount-=1
    availableCount
  }*/

  val decrease=(x:Int) => x-1
 /* def isCardUsable(point:Int): Boolean ={
    if(isCardAvailable()==true && isCardAffordable(point)==true) true else false
  }*/
  def isCardAvailable():Boolean ={
    if(availableCount>0) true else false

  }
  def isCardAffordable(p:Int):Boolean

  def reduceCardPoint(point:Int):Int={point-cost}



  def useCard(word:Word)

}
