package Game

class Category extends Card {
  val name:String="Category"
  val cost:Int=5
  var availableCount:Int=1

  override def isCardAffordable(point:Int):Boolean={
    if(point>=5) true else false
  }


  def useCard(word: Word): Unit = {
    println(word.categoryName)
    availableCount=decrease(availableCount)
  }

}
