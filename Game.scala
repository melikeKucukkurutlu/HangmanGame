package Game


object Game {
  import scala.collection.immutable.Map
  val alphabet1=new Alphabet

  val cards=Map[String,Card]("buy a letter" -> new BuyALetter(), "category" -> new Category, "discount" -> new Discount, "risk" -> new Risk, "consolation" -> new Consolation)

  val Point:Int=100

  val word1:Word=new Word("tigeer","animal")

  val wordRepo:WordRepo=new WordRepo
  val level=getLevel()
  val word:Word=new Word(wordRepo.findWord(level),wordRepo.findWordCategory())

  //println(word.word)
  word.findSpace()

  def main(args: Array[String]): Unit = {
    recursive(0)
    println(word.word)

}


  def getLevel():Int={
    try {
      println("1) Easy 2) Medium 3) Hard")
      val level:Int=scala.io.StdIn.readInt()
      level

    }catch{
      case e:java.lang.ExceptionInInitializerError => getLevel()
      case e:NumberFormatException => getLevel()
    }
  }

  def getCard():Option[Card]={
    print("Select a card:")
    val card=scala.io.StdIn.readLine()
    cards get card
  }

  def checkCard(c:Option[Card],p:Int):Option[Card]={
    c match {
      case Some(_) =>{
        if(c.get.isCardAffordable(p)&&c.get.isCardAvailable())
          c
        else {
          println("You can't use this card")
          checkCard(getCard(),p)
        }
      }
      case None => None
    }
  }


  def recursive(p:Int): Unit ={
    if(p<=100 && word.isAllPositionsRevealed()){
      word.showWord()

      val newCard = checkCard(getCard(),100-p)
      if(newCard!=None)
      {
        newCard.get.name match {
          case "Buy A Letter" => newCard.get.asInstanceOf[BuyALetter].useCard(word)
            recursive(p+newCard.get.cost)
          case "Category" =>newCard.get.asInstanceOf[Category].useCard(word)
            recursive(p+newCard.get.cost)
          case "Discount" =>
            val newMove=newCard.get.asInstanceOf[Discount]
            recursive(p + newMove.useCard(newMove.checkLetter(newMove.getLetter()).get,word) + newMove.cost)

          case "Risk" =>
            val newMove=newCard.get.asInstanceOf[Risk]
            recursive(p + newMove.useCard(newMove.checkLetter(newMove.getLetter()).get,word) + newMove.cost)

          case "Consolation" =>
            val newMove=newCard.get.asInstanceOf[Consolation]
            recursive(p + newMove.useCard(newMove.checkLetter(newMove.getLetter()).get,word) + newMove.cost)


        }

      }

      else{
        val move:Move=new Move{}
        val newLetter=move.checkLetter(move.getLetter()).get
        val letterResult=move.makeALetterGuess(newLetter,word)
        if(letterResult==true){
          println("Guess is true")
          println("Your point:" + (Point - p))
          recursive(p)
        }
        else {println("guess is false")
          println("Your point:" + (Point - (p + newLetter.cost)))
          recursive(p + newLetter.cost)
        }

      }

    }
  }

}
