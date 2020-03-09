package day4.battleships
import day4.battleships.Board
import day4.battleships.Main

class FirstTest extends UnitSpec  {
  val board = new Board
  "We" should "be able to successfully create new board object" in {
    assert(board.isInstanceOf[Board])
  }

  "Board object" should "be initialised with 12x12 array of ' ~ '" in {
    assert(board.arr.length == 12)
    assert(board.visarr.length == 12)
    assert(board.arr(1).length == 12)
    assert(board.visarr(1).length == 12)
    assert((List(1) zip board.arr.flatMap(_.toList)).toMap.keys.size == 1)
  }

  "CheckValid method" should "return true if the tile doesn't have a ship already there else false" in {
    assert(board.checkValid(5,5))
    assert(board.checkValid(12,12))
    assert(board.checkValid(1,1))
    board.addShip(1,4,4,"up")
    assert(!board.checkValid(4,4))
  }

  "AddShip method" should "alter the array to reflect the added ship"


}