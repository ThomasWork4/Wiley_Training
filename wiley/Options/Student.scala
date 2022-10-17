package com.wiley.Options
class Student(roll:Int){
  var rollNumber=0
}
object test2 extends  App{
  // var st=new Student(8)
  //prin
  //printingStatus(st)

  val studentRegster:Map[Int,String]=Map(1 -> "John",2-> "jdfhasjkhf")
  //printingStatus(getStudentName(studentRegster,2))
  def getStudentName(studentRegster:Map[Int,String],roll:Int):Option[String]={
    studentRegster.get(roll)
  }
  def printingStatus(student:Option[String]):Unit={
    student match {
      case student => println("One"+student)

      case None => println("No")
    }
  }
}
