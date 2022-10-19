package com.wiley.Dates

import org.joda.time.DateTime

import java.util.Date


object Dates{

  var d2 = new Date()
  println(d2)

  val d3 = new Date(122, 8, 19)
  println(d3)
  println(d3.getDay) //1 - Monday, 2 - Tuesday etc

  var dt = new DateTime();
  var dt2 = new DateTime(2022, 3, 26, 12, 0, 0, 0);

  println(dt)
  println(dt2)

}
