package Game

import javafx.scene.effect.Light


object Game {
  import scala.collection.immutable.Map



  val Point:Int=100
  val wordRepo=WordRepo
def startAGame() {
  do {
    val cards = Map[String, Card]("buy a letter" -> new BuyALetter(), "category" -> new Category, "discount" -> new Discount, "risk" -> new Risk, "consolation" -> new Consolation)
    val level = getLevel()
    val word: Word = new Word(wordRepo.findWord(level), wordRepo.findWordCategory())
    val alphabet = new Alphabet
    //println(word.word)
    word.findSpace()


    recursiveMove(0, word, alphabet, cards)
    println(word.word)

    println("Play again:(Y/N)")


  } while (scala.io.StdIn.readChar() == 'Y')

}
  def recursiveMove(p:Int,word: Word,alphabet: Alphabet,cards:Map[String,Card]): Unit ={
    if(p<=Point && word.isAllPositionsRevealed()){
      word.showWord()

      val newCard = checkCard(getCard(cards),Point-p,cards)
      if(newCard.isDefined)
      {
        newCard.get.name match {
          case "Buy A Letter" => newCard.get.asInstanceOf[BuyALetter].useCard(word)
            recursiveMove(p+newCard.get.cost,word,alphabet,cards)
          case "Category" =>newCard.get.asInstanceOf[Category].useCard(word)
            recursiveMove(p+newCard.get.cost,word,alphabet,cards)
          case "Discount" =>
            val newMove=newCard.get.asInstanceOf[Discount]
            recursiveMove(p + newMove.useCard(newMove.checkLetter(newMove.getLetter(alphabet),alphabet).get,word) + newMove.cost,word,alphabet,cards)

          case "Risk" =>
            val newMove=newCard.get.asInstanceOf[Risk]
            recursiveMove(p + newMove.useCard(newMove.checkLetter(newMove.getLetter(alphabet),alphabet).get,word,alphabet) + newMove.cost,word,alphabet,cards)

          case "Consolation" =>
            val newMove=newCard.get.asInstanceOf[Consolation]
            recursiveMove(p + newMove.useCard(newMove.checkLetter(newMove.getLetter(alphabet),alphabet).get,word,p,alphabet) + newMove.cost,word,alphabet,cards)


        }

      }

      else{
        val move:Move=new Move{}
        val newLetter=move.checkLetter(move.getLetter(alphabet),alphabet).get
        val letterResult=move.makeALetterGuess(newLetter,word)
        if(letterResult){
          println("Guess is true")
          println("Your point:" + (Point - p))
          recursiveMove(p,word,alphabet,cards)
        }
        else {println("guess is false")
          println("Your point:" + (Point - (p + newLetter.cost)))
          recursiveMove(p + newLetter.cost,word,alphabet,cards)
        }

      }
    }
    else if(!word.isAllPositionsRevealed())
      println("you won")
    else println("you lose")
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

  def getCard(cards:Map[String,Card]):Option[Card]={
    print("Select a card:")
    val card=scala.io.StdIn.readLine()
    cards get card
  }

  def checkCard(c:Option[Card],p:Int,cards:Map[String,Card]):Option[Card]={
    c match {
      case Some(_) =>
        if(c.get.isCardAffordable(p)&&c.get.isCardAvailable())
          c
        else {
          println("You can't use this card")
          checkCard(getCard(cards),p,cards)
        }

      case None => None
    }
  }

}
