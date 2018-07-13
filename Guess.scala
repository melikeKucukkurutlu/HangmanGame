package myPackage

class Guess extends Move{

  def makeAMove(letter: Letter,word: Word): Unit ={

    if(letter.isLetterUsable()){
      //var list=word.findLetterPosition(letter)
      val list=word.findLetterPosition1(letter)
      if(list==null){
        letter.setState(false)
      }
      else {
        word.setPositionsStatus(list)
        letter.setState(true)
      }
      letter.usability=false
    }
    else println("letter was used before")

  }



}
