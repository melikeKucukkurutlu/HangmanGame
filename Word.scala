package myPackage

class Word (w:String,catName:String){
  private val word:String=w
  val categoryName:String=catName
  var visibility:Array[Boolean]=new Array[Boolean](word.length)

  def findLetterPosition(l:Letter):List[Int]={
    import scala.collection.mutable.ListBuffer
    var positions=new ListBuffer[Int]()
    for(c <- word ) {
      if (c==l.letter) {
        val a:Int = word.indexOf(c)
        positions+=a
      }
    }
    positions.toList
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
