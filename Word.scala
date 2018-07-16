package Game

class Word (w:String,catName:String){
  val word:String=w
  val categoryName:String=catName
  var visibility:Array[Boolean]= new Array[Boolean](word.length)


    def findSpace(): Unit ={
      for(c <- word if c.isWhitespace) {
        visibility(word.indexOf(c))=true
      }
    }

    def findLetterPosition1(l: Letter): List[Int] = {
      import scala.collection.mutable.ListBuffer
      var positions = new ListBuffer[Int]()
      var a: Int = -1
      for (c <- word if c == l.letter) {
        a = word.indexOf(c, (a + 1))
        positions += a

      }
      positions.toList
    }


    def setPositionsStatus(list: List[Int]): Unit = {
      list.foreach(l => visibility(l) = true)
    }

    def isAllPositionsRevealed(): Boolean = visibility.exists(_ != true)


    def showWord(): Unit = {
      for (i <- 0 to word.length - 1) {
        if (visibility(i) == false)
          print("_ ")
        else print(word(i))
      }
    }


}
