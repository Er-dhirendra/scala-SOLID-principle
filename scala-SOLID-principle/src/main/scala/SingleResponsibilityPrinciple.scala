/*
* A class should have only one reason to change, meaning it should have only one job or responsibility.
* 
* */

// Before SRP
class User(val name: String, val email: String) {
  def saveToDatabase(): Unit = {
    // Code to save user to database
  }

  def sendEmailVerification(): Unit = {
    // Code to send email verification
  }
}

object SingleResponsibilityPrinciple extends App{
  // After SRP
  class User(val name: String, val email: String)

  class UserRepository {
    def save(user: User): Unit = {
      // Code to save user to database
    }
  }

  class EmailService {
    def sendVerification(user: User): Unit = {
      // Code to send email verification
    }
  }
}
