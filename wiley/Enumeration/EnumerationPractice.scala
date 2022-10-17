package com.wiley.Enumeration

object EnumerationPractice extends Enumeration {
  //An enumeration is a set of values with named constants
/*
  Enumerations offer an easy way to work with sets of related constants.
  An enumeration, or Enum, is a symbolic name for a set of values.
   Enumerations are treated as data types,
   and you can use them to create sets of constants for use
   with variables and properties.
*/

/*
  1. Reduces errors caused by transposing or mistyping numbers.
  2. Makes it easy to change values in the future.
  3. Makes code easier to read, which means it is less likely that errors will creep into it.
  4. Ensures forward compatibility. With enumerations, your code is less likely to fail if in the future someone changes the values corresponding to the member names.
*/

  //How do we do it in scala?
  //Declare a new type
  //Assign variables to that type
  //Then to access you can use ObjectName.values
  //In our case, it's EnumerationPractice.values

  type Planets = Value

  val Mercury, Venus, Earth, Jupiter, Saturn, Uranus, Neptune = Value

  val Pluto = Value(9, "Pluto")
  val Zoto = Value(10, "Zoto")


  def isMilyway(planets: Planets): Unit = {
    println(s"Planet ${planets.id} and ${planets}")
  }

  def isPlanet(planet:String):Boolean= EnumerationPractice.values.toList.map(v => v.toString).contains(planet)


  def main(args: Array[String]): Unit = {
    println(s"The se values of type planets that milkway holds ${EnumerationPractice.values}")

    isMilyway(EnumerationPractice.Earth)
    isMilyway(EnumerationPractice.Zoto)

    println("Is this entry a planet?: "+isPlanet("Earth"))
    println("Is this entry a planet?: "+isPlanet("Zoto"))
  }





}
