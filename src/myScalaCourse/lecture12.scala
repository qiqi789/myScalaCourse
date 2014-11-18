package myScalaCourse

object lecture12 {

  object ESieve {
    def from(n : Int): Stream[Int] = n #:: from(n+1)
    def sieve(s : Stream[Int]): Stream[Int] = 
      s.head #:: sieve(s.tail filter (_ % s.head != 0))
      
  }
  
  def sqrtStream(x: Double): Stream[Double] = {
    def improve(guess: Double) = (guess + x / guess) / 2
    lazy val guesses: Stream[Double] = 1 #:: (guesses map improve)
    guesses
  }
  
  def isGoodEnough(guess: Double, x: Double) = 
    math.abs((guess * guess - x)/x) < 0.0001
  
  def main(args: Array[String]): Unit = {
    import ESieve._
    
    val primes = sieve(from(2))
    println((primes take 6).toList)
    
    val s = sqrtStream(4) filter (isGoodEnough(_, 4))
    println(s.head)
    

  }

}