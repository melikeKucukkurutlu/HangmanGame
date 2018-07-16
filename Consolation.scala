package Game

class Consolation extends Move with Card {
  val name:String="Consolation"
  val cost:Int=5
  var availableCount:Int=1

  override def isCardAffordable(point:Int):Boolean={
    if(point>=5) true else false
  }

 /* def useCard(letter: Letter, word: Word, p:Int): Int ={
    val letterResult=makeALetterGuess(letter,word)
   // word.showWord()
    if(letterResult==false){
      println("Guess is false")
      println("Your point:" + (100 - p - letter.cost - cost))
      val l2=checkLetter(getLetter()).get
      val letterResult2=makeALetterGuess(l2,word)
      //word.showWord()
      if(letterResult2==false) {
        println("Your point:" + (100 - p - letter.cost - cost - l2.cost/2))
        l2.cost / 2 + letter.cost
      }
      else
        letter.cost
    }
    else 0
  }*/

  def useCard(letter: Letter, word: Word, p:Int, alphabet: Alphabet): Int ={
    val letterResult=makeALetterGuess(letter,word)
    // word.showWord()
    if(letterResult==false) {
      println("Guess is false")
      if (100 - p - letter.cost - cost >= 0) {
        println("Your point:" + (100 - p - letter.cost - cost))
        val l2 = checkLetter(getLetter(alphabet),alphabet).get
        val letterResult2 = makeALetterGuess(l2, word)
        //word.showWord()
        if (letterResult2 == false) {
          println("Your point:" + (100 - p - letter.cost - cost - l2.cost / 2))
          l2.cost / 2 + letter.cost
        }
        else
          letter.cost
      }
      else letter.cost
    }
    else 0
  }

}
