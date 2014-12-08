package myScalaCourse

object lecture15 {

  trait Mobile
  class Animals extends Mobile {
    def race(m: Mobile) {
      println(this + " race with: "+ m)
    }
    override def toString = {
      "Animals"
    }
  }
  class Vehicles extends Mobile {
    def race(m: Mobile) {
      println(this + " race with: " + m)
    }
    override def toString = {
      "Vehicles"
    }
  }
  
  def main(args: Array[String]): Unit = {
    val a = new Animals
    val v = new Vehicles
    a.race(v)
    v.race(a)
    
  }

}