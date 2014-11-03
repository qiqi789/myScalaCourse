package myScalaCourse

object test {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  List.range(1,3)                                 //> res0: List[Int] = List(1, 2)
  List.range(1,6).flatMap(i => List.range(1,i).map(x=>(i,x)))
                                                  //> res1: List[(Int, Int)] = List((2,1), (3,1), (3,2), (4,1), (4,2), (4,3), (5,1
                                                  //| ), (5,2), (5,3), (5,4))
  List.range(1,6).map(x=>(6,x))                   //> res2: List[(Int, Int)] = List((6,1), (6,2), (6,3), (6,4), (6,5))
}