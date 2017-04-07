package chapter6

class Rational(n : Int, d: Int) {
  
  require(d!=0)
  
  private val gcd: Int = gcd(n, d)
  
  val numer = n
  
  val denom = d;
  
  override def toString = numer + "/" + denom
  
  private def gcd(x: Int, y: Int) : Int = {
    if(y==0) x else gcd(y, x% y)
  }
  
  def + (that: Rational) :Rational = {
    new Rational(
        numer * that.denom + denom * that.numer, denom * that.denom   
    )  
  }
  
  def * (that: Rational) : Rational = {
    new Rational(
      numer * that.numer , denom * that.denom    
    )
  }
  
  def * (i: Int) :Rational = new Rational(numer * i, denom)
  
}

object Rational {
  def main(args : Array[String]){
    println("I am in ")
    
    val r = new Rational(1, 2)
    
    val q = new Rational(2, 5)   
   println(r + q)
   
   println(r * 10)
   
   println(r.gcd)
   
   println(q.gcd)
  }
}