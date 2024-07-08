/*
*
* Objects of a superclass should be replaceable with objects of a subclass without affecting the correctness of the program
* */


// Before LSP
class Rectangle(var width: Int, var height: Int) {
  def setWidth(width: Int): Unit = this.width = width
  def setHeight(height: Int): Unit = this.height = height
  def area: Int = width * height
}

class Square(side: Int) extends Rectangle(side, side) {
  override def setWidth(width: Int): Unit = {
    this.width = width
    this.height = width
  }

  override def setHeight(height: Int): Unit = {
    this.width = height
    this.height = height
  }
}


object LiskovSubstitutionPrinciple extends App{
  // After LSP
  trait Shape {
    def area: Int
  }

  class Rectangle(val width: Int, val height: Int) extends Shape {
    def area: Int = width * height
  }

  class Square(side: Int) extends Shape {
    def area: Int = side * side
  }
}
