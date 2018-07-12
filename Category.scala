package myPackage

class Category extends MoveWithoutLetter with Card {
  val name:String="Category"
  val cost:Int=5
  var availableCount:Int=1

  def makeAMove(word: Word): String = {
    availableCount-=1
    word.categoryName
  }
}
