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
    visibility.exists(_ != false)
   /* for(i<-0 to visibility.length-1)
      if(visibility(i)==false)
        false
    true*/
  }

  def showWord(): Unit ={
    for(i <- 0 to word.length-1){
      if(visibility(i)==false)
        print("_ ")
      else print(word(i))
    }
  }


}
