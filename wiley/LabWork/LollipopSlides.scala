package com.wiley.LabWork

case class LollipopType(name:String)

class ShoppingCart{
  def addCartItem[subtype >: VanillaDonut](p : subtype):Unit = {
    println("Item has been added to shopping cart: "+p)
  }
}


object mainlollipop extends App {
  var obj1 = new LollipopType("Vanilla Lollipop")
  //var obj2 = new Pastry[LollipopType](new LollipopType("Strawberry Lollipop"))

  var obj3 = new ShoppingCart
  obj3.addCartItem(VanillaDonut)
  obj3.addCartItem(GlazedDonut)
  obj3.addCartItem(LollipopType)
  obj3.addCartItem("Random item")

}