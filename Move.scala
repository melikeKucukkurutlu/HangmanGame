package Game

//import Game.alphabet1

abstract class Move {

  def makeALetterGuess(letter: Letter,word: Word): Boolean ={
    val list=word.findLetterPosition1(letter)
    if(list.isEmpty){
      letter.setState(false)
      false
    }
    else {
      word.setPositionsStatus(list)
      letter.setState(true)
      true
    }

  }

  def getLetter(alphabet: Alphabet):Option[Letter]={
    try {
      print("Select a letter:")
      val newLetter = scala.io.StdIn.readChar()
      alphabet.alphabet get newLetter

    }catch {
      case e:StringIndexOutOfBoundsException =>getLetter(alphabet)
    }

  }

  def checkLetter(l:Option[Letter],alphabet: Alphabet):Option[Letter]={
    l match {
      case Some(_) => {
        if(l.get.isLetterUsable()==true) {
          l.get.setUsability()
          l
        }
        else checkLetter(getLetter(alphabet),alphabet)
      }

      case None => checkLetter(getLetter(alphabet),alphabet)
    }

  }

}
