package myPackage

class BuyALetter extends Card  {
  val name:String="Buy A Letter"
  val cost:Int=20
  var availableCount:Int=1

 /* def makeAMove(word: Word,position:Int)={
    if(word.visibility(position)!=true){
      word.visibility(position)=true
      availableCount-=1
    }
  }*/




   def useCard(word: Word): Unit = {

    print("Select a position:")
    val specificPosition:Int = scala.io.StdIn.readInt()
    if (word.visibility(specificPosition) != true) {
      word.visibility(specificPosition) = true
      availableCount=decrease(availableCount)
    }
    else useCard(word)
  }





  override def isCardAffordable(point:Int):Boolean={
    if(point>=20) true else false
  }


}
