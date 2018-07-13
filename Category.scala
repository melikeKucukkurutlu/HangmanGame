package myPackage

class Category extends Card {
  val name:String="Category"
  val cost:Int=5
  var availableCount:Int=1

  def makeAMove(word: Word): String = {
    availableCount-=1
    word.categoryName
  }

  def useCard(word: Word): Unit = {
    println(word.categoryName)
    availableCount=decrease(availableCount)
  }

  override def isCardAffordable(point:Int):Boolean={
    if(point>=5) true else false
  }
}
