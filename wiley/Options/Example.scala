package com.wiley.Options
class StudentTemp(roll:Int){
  var rollNumber=roll
}

class PeronalDetails(NameV:String,ageT:Int){
  var Name=NameV
  var age=ageT
}


object MatchNumbers extends  App{
  var st=new StudentTemp(1)
  var pt=new PeronalDetails("Jinesh",35)
  var test1=new StudentTemp(60)
  var test2=new PeronalDetails("Thomas", 22)
  val studentRegster:Map[StudentTemp,PeronalDetails]= Map(st->pt,
    test1->test2)



  for ((key, value) <- studentRegster) {
    printingStatus(getStudentName(studentRegster, key.rollNumber))
  }


  def getStudentName(studentRegster:Map[StudentTemp,PeronalDetails],roll:Int):Option[PeronalDetails]={
    var alpha:Option[PeronalDetails]=None
    var studentKeys=studentRegster.keys
    var check=false
    for(a <- studentKeys){
      if(a.rollNumber.equals(roll)){
        alpha=studentRegster.get(a)
        check=true
      }

    }
    if(!check){
      var pt1:Option[PeronalDetails]=None
      pt1

    }else{
      alpha
    }
  }



  def printingStatus(student:Option[PeronalDetails]):Unit={
    student match {
      case student => println("One "+student.get.Name)

      case None => println("No")
    }
  }
}