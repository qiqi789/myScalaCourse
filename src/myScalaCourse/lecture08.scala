package myScalaCourse

object lecture08 {

  object Stacks {
    abstract class Stack[+A] {
      def push[B >: A](x: B): Stack[B] = new NonEmptyStack(x, this)
      def isEmpty: Boolean
      def top: A
      def pop: Stack[A]
    }
    object EmptyStack extends Stack[Nothing] {
      def isEmpty = true
      def top = error("EmptyStack.top")
      def pop = error("EmptyStack.pop")
    }
    class NonEmptyStack[+A](elem: A, rest: Stack[A]) extends Stack[A] {
      def isEmpty = false
      def top = elem
      def pop = rest
    }

  }

  object FunctionType {

    val f: (AnyRef => Int) = x => x.hashCode()
    val g: (String => Int) = f

    //    val g: (String => Int) = x => x.length()
    //    val f: (AnyRef => Int) = g

  }

  def main(args: Array[String]): Unit = {
    import Stacks._
    // Stack[Int]
    val s = EmptyStack.push(8)
    // Stack[Any]
    val ss = s.push("hainan")
    //println(ss)
    
    
    import FunctionType._
    val tmp = g("abc")
    val tmp2 = f(8: java.lang.Integer)
    val tmp3 = f("abc")
    println(tmp)
    println(tmp2)
    println(tmp3)

  }

}