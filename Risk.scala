package Game


class Risk extends Move with Card {
  val name:String="Risk"
  val cost:Int=8
  var availableCount:Int=2

  override def isCardAffordable(point:Int):Boolean={
    if(point>25 && point<50) true else false
  }

  def useCard(letter: Letter, word: Word, alphabet: Alphabet): Int ={
    val letterResult=makeALetterGuess(letter,word)
    word.showWord()
    if(letterResult==true){
      makeALetterGuess(checkLetter(getLetter(alphabet),alphabet).get,word)
      word.showWord()
      0
    }
    else letter.cost
  }

}
