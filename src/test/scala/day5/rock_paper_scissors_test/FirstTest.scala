package day5.rock_paper_scissors_test
import day5.rock_paper_scissors.Main.rock

class FirstTest extends UnitSpec {

  "Rock" must "return rock" in {
    assert(rock("Rock",Array(1,1,1,1,1))=="rock")
    assert(rock("Paper",Array(1,1,1,1,1))=="rock")
    assert(rock("Scissors",Array(5,1,4,12,2))=="rock")
    assert(rock("Lizard",Array(0,0,4,9,1))=="rock")
    assert(rock("Spock",Array(4,15,7,11,3))=="rock")
  }

  "Rock" should "lose to paper, printing message" in {
    val stream = new java.io.ByteArrayOutputStream()
    assert(Console.withOut(stream) {
      rock("Paper",Array(1,1,1,1,1)) == "rock"
    })
  }

}
