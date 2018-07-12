package myPackage

import scala.collection.mutable.ListBuffer

object HangmanGame {
  var Point:Int=100
  val word:Word=new Word("flower","animal")

  val cards=ListBuffer[Card]()
  val b:BuyALetter=new BuyALetter()
  val r:Risk=new Risk
  cards+=b
  cards+=r
  print("Select a card:")
  val card=scala.io.StdIn.readLine()
  if(card=="none")
    println("selam")
  card match {
    case "buy a letter"=>if(b.isCardAffordable(Point) && b.isCardAvailable()){
      val specificPosition=scala.io.StdIn.readInt()
      while(specificPosition>word.visibility.length||word.visibility(specificPosition)==true){
        println("Please select an empty position")
         val specificPosition=scala.io.StdIn.readInt()
      }
    }


  }

  def main(args: Array[String]): Unit = {
    val guesses=List[Guess]()

    val letter:Letter=new Letter('p',5)
    val word:Word=new Word("flower","animal")
   // val list=word.findLetterPosition(letter)
    //list.foreach(println)


    val letter1:Letter=new Letter('l',5)
    val letter2:Letter=new Letter('m',5)
      var guess: Guess = new Guess()
    var guess1: Guess = new Guess()

    guess.makeAMove(letter, word)
    guess1.makeAMove(letter1, word)
    guess.makeAMove(letter2, word)



    word.visibility.foreach(println)

  }

}
