package day3.garage

class Part(val name:String, val cost:Int, val time:Int, var working:Boolean) {

  def fix(): Unit = {
    working = true
  }

}
