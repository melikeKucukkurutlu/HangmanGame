package myPackage

class Letter(l:Char,c:Int) {
  val letter:Char=l
  val cost:Int=c
  var usability:Boolean=true
  private var state:Boolean=false

  def isLetterUsable():Boolean=usability

  def setState(result:Boolean): Unit ={
    state=result
  }

}
