package com.programming.in.scala.chapter6

class Rational(n : Int, d: Int) {
  
  require(d!=0)
  
  private val gcd: Int = gcd(n, d)
  
  val numer = n / gcd
  
  val denom = d / gcd;
  
  override def toString = numer + "/" + denom
  
  private def gcd(x: Int, y: Int) : Int =  if(y==0) x else gcd(y, x% y)
  
  def + (that: Rational) :Rational = new Rational(numer * that.denom + that.numer * denom, denom * that.denom)  

  def + (i: Int) :Rational = new Rational(numer + i * denom, denom)
  
  def - (that: Rational) : Rational = new Rational(numer*that.denom - that.numer * denom, denom * that.denom)
  
  def - (i: Int) :Rational = new Rational(numer - i * denom, denom)
  
  def * (that: Rational) : Rational = new Rational(numer * that.numer , denom * that.denom)

  def * (i: Int) :Rational = new Rational(numer * i, denom)
  
  def / (that: Rational) : Rational = new Rational(numer * that.denom, denom * that.numer)
  
  def / (i: Int) : Rational = new Rational(numer, denom * i)
  
}

object Rational {
  def main(args : Array[String]){
    println("I am in ")
    
    val r = new Rational(77, 66)
    
    val q = new Rational(6, 3)   
    
    val x = new Rational(2, 3)
    
    println(x +" * "+ x + " = " + x * x)
    
    println(x +" + "+ r + " = " + (x + r))
    
    println(x +" + "+ 10 + " = " + (x + 10))
    
    println(x +" - "+ r + " = " + (x - r))
   
  }
}