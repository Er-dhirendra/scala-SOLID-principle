/*
* 
* High-level modules should not depend on low-level modules. Both should depend on abstractions.
* 
* */

// Before DIP
class MySQLDatabase {
  def connect(): Unit = {
    // connection code
  }
}

class UserRepository {
  val db = new MySQLDatabase

  def save(user: User): Unit = {
    db.connect()
    // save user code
  }
}



object DependencyInversionPrinciple extends App{
  // After DIP
  trait Database {
    def connect(): Unit
  }

  class MySQLDatabase extends Database {
    def connect(): Unit = {
      // connection code
    }
  }

  class UserRepository(db: Database) {
    def save(user: User): Unit = {
      db.connect()
      // save user code
    }
  }

  val mySQLDatabase = new MySQLDatabase
  val userRepository = new UserRepository(mySQLDatabase)
  // use userRepository to save users
}
