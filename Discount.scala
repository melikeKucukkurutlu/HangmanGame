package Game

class Discount extends Move with Card {
  val name:String="Discount"
  val cost:Int=5
  var availableCount:Int=2

  override def isCardAffordable(point:Int):Boolean={
    if(point>=5 && point<40) true else false
  }

  def useCard(letter: Letter, word: Word): Int ={
    val letterResult=makeALetterGuess(letter,word)
    if(letterResult==false)
      letter.cost*75/100
    else 0
  }

}
