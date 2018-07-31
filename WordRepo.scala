package GamePackage

import java.io.File

import scala.collection.mutable.ListBuffer
import scala.io.Source

object WordRepo {
  val filesHere = new File(".").listFiles
  val files = filesHere.filter(file => file.getName.endsWith(".txt"))

  val allWords = Map[Int, ListBuffer[Word]](1 -> ListBuffer[Word](), 2 -> ListBuffer[Word](), 3 -> ListBuffer[Word]())
  files.foreach(file =>
    Source.fromFile(file.getName).getLines.foreach(line =>
      if (line.length >= 10) allWords(1) += new Word(line, file.getName.dropRight(4))
      else if (line.length >= 6) allWords(2) += new Word(line, file.getName.dropRight(4))
      else allWords(3) += new Word(line, file.getName.dropRight(4))))

  def getRandomWord(level: Int): Word = {
    val random = scala.util.Random.nextInt(allWords(level).length)
    allWords(level)(random)
  }
}
