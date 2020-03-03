object Main extends App {
  import scala.io.Source

  def letterFind(letters: String): Unit= {
    val lines = Source.fromFile("/home/qa-admin/Downloads/dictionary.txt").getLines.toArray
    val words = scala.collection.mutable.ArrayBuffer.empty[String]
    val let = letters.toList
    for (word <- lines) {
      var x = word.length()
      for (i <- (0 until word.length())) {
        if (!let.contains(word(i))) {
          x -= 1
        }
      }
      if (x == word.length()) {
        words += word
      }
      }
    //println(words)
    println(words.maxBy(_.length))
    }

  val number = scala.io.StdIn.readLine("How many keyboards? ").toInt
  for (i <- (0 until number)) {
    val keyboard = scala.io.StdIn.readLine("Which keys work? ")
    letterFind(keyboard)
  }

}
