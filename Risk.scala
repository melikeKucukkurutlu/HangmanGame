package myPackage

class Risk extends GuessWithCard with Card {
  val name:String="Risk"
  val cost:Int=8
  var availableCount:Int=2


  override def makeAMove(letter:Letter,word: Word): Unit = {

  }


}
