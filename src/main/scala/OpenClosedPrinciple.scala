/*
* Software entities (classes, modules, functions, etc.) should be open for extension but closed for modification.
* */

// Before OCP
class DiscountCalculator {
  def calculateDiscount(price: Double, customerType: String): Double = {
    customerType match {
      case "Regular" => price * 0.1
      case "VIP" => price * 0.2
      case _ => 0.0
    }
  }
}

object OpenClosedPrinciple extends App{
  // After OCP
  trait DiscountStrategy {
    def calculate(price: Double): Double
  }

  class RegularDiscount extends DiscountStrategy {
    def calculate(price: Double): Double = price * 0.1
  }

  class VipDiscount extends DiscountStrategy {
    def calculate(price: Double): Double = price * 0.2
  }

  class DiscountCalculator {
    def calculateDiscount(price: Double, discountStrategy: DiscountStrategy): Double = {
      discountStrategy.calculate(price)
    }
  }
}
