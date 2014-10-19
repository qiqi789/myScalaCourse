package myScalaCourse

object lecture07 {

  object MS {
    def msort[A](less: (A, A) => Boolean)(xs: List[A]): List[A] = {
      def merge(xs1: List[A], xs2: List[A]): List[A] =
        if (xs1.isEmpty) xs2
        else if (xs2.isEmpty) xs1
        else if (less(xs1.head, xs2.head)) xs1.head :: merge(xs1.tail, xs2) else xs2.head :: merge(xs1, xs2.tail)
      val n = xs.length / 2
      if (n == 0) xs
      else merge(msort(less)(xs take n), msort(less)(xs drop n))
    }
  }

  def main(args: Array[String]): Unit = {

    import MS._
    val lst = msort((x: Int, y: Int) => x < y)(List(5, 7, 1, 3))
    println(lst)

    val intSort = msort((x: Int, y: Int) => x < y) _
    
    val reverseSort = msort((x: Int, y: Int) => x > y) _
    
    println(intSort(List(6,5,4,3,2,1)))

  }

}