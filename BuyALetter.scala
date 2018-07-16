package Game

class BuyALetter extends Card {
  val name:String="Buy A Letter"
  val cost:Int=20
  var availableCount:Int=1

  override def isCardAffordable(point:Int):Boolean={
    if(point>=20) true else false
  }



  def useCard(word: Word): Unit = {
try {
  print("Select a position:")
  val specificPosition: Int = scala.io.StdIn.readInt()
  if (word.visibility(specificPosition) != true) {
    word.visibility(specificPosition) = true
    availableCount=decrease(availableCount)
  }
  else {
    println("Position already opened")
    useCard(word)
  }
}catch {
  case e:java.lang.NumberFormatException => useCard(word)
  case e:java.lang.ArrayIndexOutOfBoundsException =>useCard(word)
}

  }
}
