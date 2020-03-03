object Main extends App {
  import scala.io.Source

  def letterFind(letters: String): Unit= {
    val lines = Source.fromFile("/home/qa-admin/Downloads/dictionary.txt").getLines.toArray
    val words = scala.collection.mutable.ArrayBuffer.empty[String]
    val let = letters.toList
    var x = 0
    for (word <- lines) {
      for (i <- let) {
        if (word.contains(i)) {
          x += 1
          if (x == word.length()) {
            words += word
          }
        }
      }
      x = 0
    }
    println(words)
  }
  letterFind("qwertyuiopasdfghjklmnbvcxz")
}
