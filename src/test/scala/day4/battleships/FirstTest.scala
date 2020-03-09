package day4.battleships
import day4.battleships.Board
import day4.battleships.Main

class FirstTest extends UnitSpec  {

  "We" should "be able to successfully create new board object" in {
    val board = new Board
    assert(board.isInstanceOf[Board])
  }

  "Board object" should "be initialised with 12x12 array" in {
    val board = new Board
    assert(board.arr.length == 12)
    assert(board.visarr.length == 12)
    assert(board.arr(1).length == 12)
    assert(board.visarr(1).length == 12)
  }



}
