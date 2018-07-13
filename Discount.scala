package myPackage

class Discount extends Move with Card {
  val name:String="Discount"
  val cost:Int=5
  var availableCount:Int=2

  override def makeAMove(letter: Letter,word: Word){
    if(letter.isLetterUsable()){
      //var list=word.findLetterPosition(letter)
      val list=word.findLetterPosition1(letter)
      letter.usability=false
      if(list==null){
        letter.setState(false)
      }
      else {
        word.setPositionsStatus(list)
        letter.setState(true)
      }
    }
    //else println("letter was used before")
  }

  override def isCardAffordable(point:Int):Boolean={
    if(point>=5 && point<40) true else false
  }

  def useCard(word:Word): Unit ={

  }




}
