package myPackage

class BuyALetter extends MoveWithoutLetter with Card  {
  val name:String="Buy A Letter"
  val cost:Int=20
  var availableCount:Int=1

  def makeAMove(word: Word,position:Int)={
    if(word.visibility(position)!=true){
      word.visibility(position)=true
      availableCount-=1
    }
  }



  override def isCardAffordable(point:Int):Boolean={
    if(point>=20) true else false
  }


}
