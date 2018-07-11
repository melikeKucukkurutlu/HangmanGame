package myPackage

class Word (w:String,catName:String){
  private val word:String=w
  private val categoryName:String=catName
  private val visibility:Array[Boolean]=new Array[Boolean](word.length)

  def findLetterPosition(l:Letter):List[Int]={
    val positions:List[Int]=List()
    for(c <- word if c==l.letter) {
      val a = word.indexOf(l.letter)
      positions.apply(a)
    }
    positions
  }

  def setPositionsStatus(list: List[Int]): Unit ={
    list.foreach(l=>visibility(l)=true)
  }

  def isAllPositionsRevealed():Boolean={
    for(i<-0 to visibility.length)
      if(visibility(i)==false)
        false
    true
  }


}
