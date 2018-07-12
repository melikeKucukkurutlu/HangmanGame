package myPackage

class Discount extends GuessWithCard with Card {
  val name:String="Discount"
  val cost:Int=5
  var availableCount:Int=2

  override def makeAMove(letter: Letter,word: Word): Unit = ???

  override def isCardAffordable(point:Int):Boolean={
    if(point>=5 && point<40) true else false
  }
}
