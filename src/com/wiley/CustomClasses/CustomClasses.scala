package com.wiley.CustomClasses

class CustomClasses(id:Int, name:String) {

  def AddToClassroom(Classroom:scala.collection.mutable.Map[String, Int]):Unit = {
    Classroom.put(name, id)
  }

  def ShowClassmates(Classroom:scala.collection.mutable.Map[String, Int]):Unit = {
    for ((k,v) <- Classroom) printf("Student Name: %s, ID: %s\n", k, v)
  }

  def getRecord(): Unit = {
    print(id + " " + name)
  }
}

  object MainObject extends App{


    var ClassroomMap = scala.collection.mutable.Map(
    "Jack" -> 5
    )


    var student1 = new CustomClasses(1, "Thomas")
    var student2 = new CustomClasses(2, "Charlotte")
    println("What is your name? ")
    var EntryOne = scala.io.StdIn.readLine()
    println("What is your ID? ")
    var EntryTwo = scala.io.StdIn.readInt()
    var student3 = new CustomClasses(EntryTwo, EntryOne)
    println("A new Student entry has been made for you. Here are your classmates")
    student1.AddToClassroom(ClassroomMap)
    student2.AddToClassroom(ClassroomMap)
    student3.AddToClassroom(ClassroomMap)
    student1.ShowClassmates(ClassroomMap)

}

