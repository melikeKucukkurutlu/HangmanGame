package GamePackage

class Word(wordName:String, categoryName:String) {
  val name=wordName
  val category=categoryName

  var visibility:Array[Boolean]= new Array[Boolean](wordName.length)

  findSpace()

  def isLetterExist(l:Letter):Boolean={
    val list=findLetterPosition(l)
    if(list.isEmpty){
      false
    }
    else{
      setPositionsStatus(list)
      true
    }
  }

  def findLetterPosition(l: Letter): List[Int] = {
    import scala.collection.mutable.ListBuffer
    var positions = new ListBuffer[Int]()
    var a: Int = -1
    for (c <- wordName if c == l.letter) {
      a = wordName.indexOf(c, a + 1)
      positions += a
    }
    positions.toList
  }

  def setPositionsStatus(list: List[Int]): Unit = {
    list.foreach(l => visibility(l) = true)
  }

  def isAllPositionsRevealed(): Boolean = visibility.exists(_ != true)


  def showWord(): Unit = {
    for (i <- 0 until  wordName.length) {
      if (visibility(i) == false)
        print("_ ")
      else print(wordName(i))
    }
  }

  def findSpace(): Unit ={
    for(c <- wordName if c.isWhitespace) {
      visibility(wordName.indexOf(c))=true
    }
  }
}