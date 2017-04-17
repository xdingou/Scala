package com.programming.in.scala.chapter7

object TryFinally {
    def main(args: Array[String])= {
      
      println("/////////////////////try-finally=>finally///////////////////////")
      
      println(f)
      
      println("/////////////////////try-finally=>try///////////////////////")
      
      println(g)
      
    }
    def f: Int = try { return 1 } finally { return 2 }
    
    def g: Int = try { 1 } finally { 2 }
}