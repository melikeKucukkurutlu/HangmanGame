package GamePackage

import scala.collection.mutable.ListBuffer

class Game(level: Int) {

  var Point: Int = 100

  val moves = ListBuffer[Move]()
  val usedCards = ListBuffer[Card]()
  val word: Word = WordRepo.getRandomWord(level)

  //println(word.name + "->" + word.category)


  def makeANewGuess(letter: Option[Letter], card: Option[Card]): Unit = {
    if (!isGameFinished()) {
      if (card.isDefined) {
        if (card.get.isCardAvailable(usedCards) && card.get.isCardAffordable(Point)) {
          if (letter.isDefined) {
            if (!moves.exists(m => m.letter == letter)) {

              if (checkLastMove())
                println("There is a active card")
              else {
                Point = reducePoint(card.get.cost)
                card.get match {
                  case Discount() =>
                    createAMove(letter.get.cost * 25 / 100)
                  case Risk() =>
                    createAMove(letter.get.cost)
                  case Consolation() =>
                    createAMove(letter.get.cost)
                }
                usedCards += card.get
              }
            }
            else println("This letter already choosed")
          }
          else {
            if (checkLastMove())
              println("There is a active card")
            else
              card.get match {
                case BuyALetter(position) =>
                  if (!word.visibility(position)) {
                    Point = reducePoint(card.get.cost)
                    word.visibility(position) = true
                    usedCards += card.get
                  }
                  else println("Position already opened")

                case Category() => println(word.category)
                  Point = reducePoint(card.get.cost)
                  usedCards += card.get
              }
          }
        }
        else println("Card isn't available or affordable! Make a new guess")
      }
      else if (letter.isDefined) {
        if (!moves.exists(m => m.letter == letter)) {
          if (checkLastMove()) {
            moves.last.card.get match {
              case Risk() => createAMove(0)
              case Consolation() => createAMove(letter.get.cost / 2)
            }
          }
          else createAMove(letter.get.cost)
        }
        else println("This letter already choosed")
      }
      else println("Invalid move")

      word.showWord()
      println("Point:" + Point)

      def createAMove(cost: Int) {
        if (!word.isLetterExist(letter.get)) {
          moves += Move(letter, card, Some(false))
          Point = reducePoint(cost)
        }
        else moves += Move(letter, card, Some(true))
      }

      def checkLastMove(): Boolean = {
        moves.nonEmpty && moves.last.card.isDefined && ((moves.last.card.get == Risk() && moves.last.result.get) || (moves.last.card.get == Consolation() && !moves.last.result.get))
      }

    }

  }

  def reducePoint(total: Int): Int = {
    Point - total
  }

  def isGameFinished(): Boolean = {
    if (word.isAllPositionsRevealed()) {
      println("You won!")
      true
    }
    else if (Point < 0) {
      println("You lost")
      true
    }
    else
      false
  }

}
