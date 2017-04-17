package com.programming.in.scala.chapter7

object MultiplicationTable {
  def main(args: Array[String]): Unit = {
    println(multiTable)
  }
  
  def multiTable() = {
    val table = for(row <- 1 to 10)yield makeRow(row).mkString(" ")
    table.mkString("\n")
  }
  
  def makeRow(row: Int) = {
      for (col <- 1 to 10)yield{
        /*val product = */
        (row * col).toString
        //val padding = " "
        //print(product + padding)
        //product + padding
      }.mkString
  } 
}