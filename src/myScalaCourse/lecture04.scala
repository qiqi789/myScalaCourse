package myScalaCourse

object lecture04 {

  object Fruits {
    class Fruit
    case class Apple(color: String) extends Fruit
  }

  object MVC_example {
    trait Controllers { this: MVC =>
      class Controller {
        def updateModel = { model = new Model }
        def updateControl = { gui.update }
      }
    }
    trait Models {
      class Model {}
    }
    trait Views { this: MVC =>
      class View {
        def visualize = { model }
      }
    }
    trait GUIs { this: MVC =>
      class GUI {
        def tellController = {
          view.visualize
          controller.updateControl
        }
        def update = {}
      }
    }
    class MVC extends Models with Views with GUIs with Controllers {
      var model = new Model
      val view = new View
      val gui = new GUI
      val controller = new Controller
    }
  }

  object TypeExamples {
    val x = new Array[String](1)
    //val y: Array[Any] = x

  }

  object StackExample {
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
      override def toString = {
        "[]"
      }
    }
    class NonEmptyStack[+A](elem: A, rest: Stack[A]) extends Stack[A] {
      def isEmpty = false
      def top = elem
      def pop = rest
      override def toString = {
        top + " | " + rest.toString()
      }
    }

  }

  object FunctionType {
    
    val f: (AnyRef => Int) = x => x.hashCode()
    val g: (String => Int) = f

//    val g: (String => Int) = x => x.length()
//    val f: (AnyRef => Int) = g

  }

  def main(args: Array[String]): Unit = {
    import Fruits._
    val apple = Apple("red")
    val fruit = new Fruit
    val fruitList: List[Fruit] = List(apple)
    //val appleList:List[Apple] = List(fruit)

    import MVC_example._
    val mvc = new MVC

    import StackExample._
    val s = new NonEmptyStack[String]("1", EmptyStack)
    val s2 = s.push(2)
    println(s2)
    val s3 = s2.push(3.0)
    println(s3)

  }

}