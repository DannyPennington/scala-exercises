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

  "checkValid method" should "return true if the tile doesn't have a ship already there else false" in {
    assert(board.checkValid(5,5))
    assert(board.checkValid(12,12))
    assert(board.checkValid(1,1))
    board.addShip(1,1,1,"up")
    assert(!board.checkValid(1,1))
  }

  "AddShip method" should "alter the array to reflect the added ship and not alter the visible array" in {
    board.addShip(2,8,8,"up")
    assert(board.arr(7)(7) == " 1 ")
    assert(board.visarr(7)(7) == " ~ ")
    assert(board.arr(6)(7) == " 1 ")
    assert(board.visarr(6)(7) == " ~ ")
  }

  "Shoot method" should "alter both arrays to display either a hit or miss" in {
    board.addShip(2,8,8,"up")
    board.shoot(8,8)
    board.shoot(4,4)
    assert(board.arr(7)(7) == " X ")
    assert(board.visarr(7)(7) == " X ")
    assert(board.arr(3)(3) == " 0 ")
    assert(board.visarr(3)(3) == " 0 ")
  }

  "Lose method" should "return true when the board has no more ships remaining, else false" in {
    val board2 = new Board
    assert(board2.lose)
    board2.addShip(1,1,1,"up")
    assert(!board2.lose)
    board2.shoot(1,1)
    assert(board2.lose)

  }
}
