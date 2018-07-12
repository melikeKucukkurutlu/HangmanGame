package myPackage

class Consolation extends GuessWithCard with Card {
  val name:String="Consolation"
  val cost:Int=5
  var availableCount:Int=1


  override def makeAMove(letter: Letter,word: Word): Unit = {
  }

  override def isCardAffordable(point:Int):Boolean={
    if(point>=5) true else false
  }
}
