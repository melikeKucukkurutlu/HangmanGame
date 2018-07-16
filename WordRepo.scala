package Game

import scala.collection.mutable.ListBuffer

object WordRepo {
  import scala.io.Source
  val easy=ListBuffer[String]()
  val medium=ListBuffer[String]()
  val hard=ListBuffer[String]()


    val filesHere = (new java.io.File(".")).listFiles

  val files = for {file <- filesHere if file.getName.endsWith(".txt")}
    yield file

 /* try {

  } catch {
    case e: NullPointerException => println("File couldn't be found")
  }*/

  val r = scala.util.Random.nextInt(files.length)


  def findWord(level: Int): String = {

    val bufferedSource = Source.fromFile(files(r).getName)
    for (line <- bufferedSource.getLines) {
      if (line.length >= 8)
        easy += line
      else if (line.length >= 5)
        medium += line
      else hard += line
    }
    bufferedSource.close
    val r1 = scala.util.Random.nextInt(easy.length)
    val r2 = scala.util.Random.nextInt(medium.length)
    val r3 = scala.util.Random.nextInt(hard.length)

    level match {
      case 1 => easy(r1)
      case 2 => medium(r2)
      case 3 => hard(r3)
    }
  }


  def findWordCategory(): String = {

    val catName = files(r).getName.toString().dropRight(4)
    catName
  }


}
