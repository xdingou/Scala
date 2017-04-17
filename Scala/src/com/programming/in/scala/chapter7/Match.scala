package com.programming.in.scala.chapter7

import sun.security.util.Length

object Match {
  
  def main(args: Array[String]) = {
    
    val Name = if (args.length > 0) args(0) else ""
     val  friend = Name match {
      case "Dinesh" => "Dinesh Gouda"
      case "Gouda"  => "Dinesh Gouda"
      case _ => "Blank"
    }
    
    println("Name: "+ friend)
  }
  
}