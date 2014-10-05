package myScalaCourse

object lecture04 {

  object Fruits {
  class Fruit 
  case class Apple(color: String) extends Fruit
  }
  
  object MVC_example {
    trait Controllers { this: MVC =>
      class Controller { 
        def updateModel = {model = new Model}
        def updateControl = { gui.update}
      }
    }
    trait Models {
      class Model { }
    }
    trait Views { this: MVC =>
      class View {
        def visualize = {model}
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
  
  def main(args: Array[String]): Unit = {
    import Fruits._
    val apple = Apple("red")
    val fruit = new Fruit
    val fruitList:List[Fruit] = List(apple)
    //val appleList:List[Apple] = List(fruit)
    
    import MVC_example._
    val mvc = new MVC
    
  }

}