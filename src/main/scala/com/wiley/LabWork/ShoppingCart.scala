package com.wiley.LabWork

case class ShoppingCartItem(name:String, price:Double, Quantity:Int)


object MainCaseClass extends App{
  var Item1 = ShoppingCartItem("Vanilla Ice cream",2.99,10)
  var Item2 = ShoppingCartItem("Chocolate biscuits",3.99,3)
  var Item3 = ShoppingCartItem("Cupcakes",4.99,5)

  var ShoppingTrolley = Array(Item1, Item2, Item3)

  ShowShoppingTrolley(ShoppingTrolley)
  ShowIceCreamOnly(ShoppingTrolley)

  def ShowShoppingTrolley(Trolley:Array[ShoppingCartItem]): Unit ={
    for(item <- Trolley){
      println(item.Quantity+" "+item.name+" at $"+item.price+" each")
    }
  }

  def ShowIceCreamOnly(Trolley:Array[ShoppingCartItem]): Unit = {
    for(item <- Trolley){
      if(item.name == "Vanilla Ice cream"){
        println(item.Quantity+" "+item.name+" at $"+item.price+" each")
      }
      else{
        println("Found another item")
      }
    }
  }

}


