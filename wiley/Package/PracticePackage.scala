package com.wiley.Package

//Using a package object is similar practice to classes
//regarding allowing you to import variables and methods created
//into other methods

package object PracticePackage{

  val a = 200

  def add(a:Int, b:Int):Int = {
    a + b
  }

}
