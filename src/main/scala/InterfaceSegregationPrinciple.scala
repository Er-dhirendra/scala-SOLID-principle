/*
* Clients should not be forced to depend on methods they do not use.
* */
// Before ISP
trait Worker {
  def work(): Unit
  def eat(): Unit
}

class HumanWorker extends Worker {
  def work(): Unit = {
    // working code
  }

  def eat(): Unit = {
    // eating code
  }
}

class RobotWorker extends Worker {
  def work(): Unit = {
    // working code
  }

  def eat(): Unit = {
    // Robots don't eat, unnecessary method
  }
}

object InterfaceSegregationPrinciple extends App{
  // After ISP
  trait Workable {
    def work(): Unit
  }

  trait Eatable {
    def eat(): Unit
  }

  class HumanWorker extends Workable with Eatable {
    def work(): Unit = {
      // working code
    }

    def eat(): Unit = {
      // eating code
    }
  }

  class RobotWorker extends Workable {
    def work(): Unit = {
      // working code
    }
  }
}
