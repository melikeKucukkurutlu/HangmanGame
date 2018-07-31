package GamePackage

import scala.collection.immutable.Map

object Alphabet {
  val alphabet = Map[Char, Letter]('a' -> new Letter('a', 18), 'b' -> new Letter('b', 8),
    'c' -> new Letter('c', 12), 'd' -> new Letter('d', 10), 'e' -> new Letter('e', 20),
    'f' -> new Letter('f', 8), 'g' -> new Letter('g', 9), 'h' -> new Letter('h', 10),
    'i' -> new Letter('i', 16), 'j' -> new Letter('j', 5), 'k' -> new Letter('k', 6),
    'l' -> new Letter('l', 13), 'm' -> new Letter('m', 10), 'n' -> new Letter('n', 15),
    'o' -> new Letter('o', 15), 'q' -> new Letter('q', 5), 'p' -> new Letter('p', 10),
    'r' -> new Letter('r', 16), 's' -> new Letter('s', 14), 't' -> new Letter('t', 15)
    , 'u' -> new Letter('u', 11), 'v' -> new Letter('v', 6), 'w' -> new Letter('w', 6),
    'x' -> new Letter('x', 5), 'y' -> new Letter('y', 8), 'z' -> new Letter('z', 5))
}
