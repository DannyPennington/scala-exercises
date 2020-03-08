object Main extends App {
  import scala.io.Source

  def letterFind(letters: String): Unit= {
    val lines = Source.fromFile("/home/qa-admin/Downloads/dictionary.txt").getLines.toArray
    val words = scala.collection.mutable.ArrayBuffer.empty[String]
    for (word <- lines) {
      var x = 0
      for (i <- (0 until word.length)) {
        if (!letters.toList.contains(word(i))) {
          x += 1
        }
      }
      x match {
        case 0 => words += word
        case _ =>
      }
    }
    println(words.maxBy(_.length))
    }
  // Asking for user input
  val number = scala.io.StdIn.readLine("How many keyboards? ").toInt
  for (i <- (0 until number)) {
    val keyboard = scala.io.StdIn.readLine("Which keys work? ")
    letterFind(keyboard)
  }

}
