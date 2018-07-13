package myPackage

import scala.collection.mutable.ListBuffer

object HangmanGame {
  var Point:Int=100
  val word:Word=new Word("tiger","animal")

  val cards=Map[String,Card]("buy a letter" -> new BuyALetter, "category" -> new Category, "discount" -> new Discount, "risk" -> new Risk, "consolation" -> new Consolation)

  val alphabet=new Alphabet
  do{
    word.showWord()
    print("Select a card:")
    val card=scala.io.StdIn.readLine()
    if(cards.contains(card)) {
      if (cards(card).isCardAffordable(Point) && cards(card).isCardAvailable()){
        cards(card).useCard(word)
        Point = cards(card).reduceCardPoint(Point)
      }

      card match {
        case "discount" =>
        case "risk" =>
        case "consolation" =>
        case _ =>

      }
     // Point = cards(card).reduceCardPoint(Point)
      /*card match {
        case "buy a letter" => if (cards(card).isCardAffordable(Point) && cards(card).isCardAvailable()) {

          cards(card).useCard(word)
          /*              Point=b.reduceCardPoint(Point)
        print("Select a position:")

        val specificPosition=scala.io.StdIn.readInt()
        /* while(specificPosition>word.visibility.length||word.visibility(specificPosition)==true){
           println("Please select an empty position")
            val specificPosition=scala.io.StdIn.readInt()
         }
         word.visibility(specificPosition)=true*/
        b.makeAMove(word,specificPosition)            */
        }

        case "category" => if (cards(card).isCardAffordable(Point) && cards(card).isCardAvailable()) {
          Point = cards(card).reduceCardPoint(Point)
          println(cards(card).useCard(word))
        }
        case "discount" =>
        case _ =>
          print("Select a letter:")
          val newLetter = scala.io.StdIn.readChar()
          // Point=reducePoint(alphabet.alphabet(newLetter).cost)
          val g: Guess = new Guess()
          g.makeAMove(alphabet.alphabet(newLetter), word)


      }*/
    }
    else{
      print("Select a letter:")
      val newLetter = scala.io.StdIn.readChar()
      // Point=reducePoint(alphabet.alphabet(newLetter).cost)
      val g: Guess = new Guess()
      g.makeAMove(alphabet.alphabet(newLetter), word)
    }
    println("Your point:"+Point)
  }while(Point>0 && word.isAllPositionsRevealed())


  def reducePoint(quantity:Int):Int={
    Point-=quantity
    Point
  }

 /* def ReducePoint1(ints: Int*): Unit ={
    ints.foreach(Point => Point-_)
  }*/

  /*def main(args: Array[String]): Unit = {
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

  }*/

}
