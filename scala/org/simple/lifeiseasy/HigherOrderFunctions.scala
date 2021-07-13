package org.simple.lifeiseasy

import sun.applet.Main

object HigherOrderFunctionsObj {
  
  def main(args: Array[String]): Unit = {
    val sumOfNumbersBetween1and5 = sumOfNumbers(1,5);
    println(s"sum of numbers between 1 and 5 =$sumOfNumbersBetween1and5")
    val sumOfCubesBetween1and5 = sumOfCubes(1,5);
    println(s"sum of cubes between 1 and 5 =$sumOfCubesBetween1and5")
    val sumOfFactorialsBetween1and5 = sumOfFactorials(1,5);
    println(s"sum of factorials between 1 and 5 =$sumOfFactorialsBetween1and5")
  }
  
  def sumOfNumbers(a: Int, b: Int): Int =
    if(a>b) 0 else a + sumOfNumbers(a+1, b)
    
  def sumOfCubes(a: Int, b: Int): Int =
    if(a>b) 0 else a*a*a + sumOfCubes(a+1, b)
    
  def sumOfFactorials  (a: Int, b: Int): Int =
    if(a>b) 0 else fact(a) + sumOfFactorials(a+1, b)
    
  def fact(a: Int): Int = 
    if(a<=1) a else a * fact(a-1)
}