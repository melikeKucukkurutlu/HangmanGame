package Game

class Consolation extends Move with Card {
  val name:String="Consolation"
  val cost:Int=5
  var availableCount:Int=1

  override def isCardAffordable(point:Int):Boolean={
    if(point>=5) true else false
  }

  def useCard(letter: Letter, word: Word): Int ={
    val letterResult=makeALetterGuess(letter,word)
   // word.showWord()
    if(letterResult==false){
      val l2=checkLetter(getLetter()).get
      val letterResult2=makeALetterGuess(l2,word)
      //word.showWord()
      if(letterResult2==false)
        l2.cost/2 + letter.cost
      else
        letter.cost
    }
    else 0
  }
}
