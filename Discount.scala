package myPackage

class Discount extends GuessWithCard with Card {
  val name:String="Discount"
  val cost:Int=5
  var availableCount:Int=2

  override def makeAMove(letter: Letter,word: Word): Unit = ???
}
