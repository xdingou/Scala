object Week603 {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  val romanNumbers = Map ("I" -> 1, "V" -> 5, "X" -> 10)
                                                  //> romanNumbers  : scala.collection.immutable.Map[String,Int] = Map(I -> 1, V -
                                                  //| > 5, X -> 10)
 
 romanNumbers get "I"                             //> res0: Option[Int] = Some(1)
 romanNumbers("I")                                //> res1: Int = 1
 //x^3 + 2x + 5  = > Map(3 -> 1, 1 -> 2, 0 -> 5 )
 //2x^3 + 3x + 5 = > Map(3 -> 2, 1 -> 3, 0 -> 5 )
  class Poly(val term: Map[Int, Double]){
  
	  def + (other: Poly) = new Poly(term ++ (other.term map adjust) )
	  
	  def adjust(terms: (Int, Double)):(Int, Double) = {
	  	val (exp, coeff) = terms
	  	println("exp :"+exp +" coeff: "+coeff);
		  term get exp match{
				case Some(coeff1) => exp -> (coeff1 + coeff);
				case None => exp -> coeff
		  }
	  }
	  
	  def adjust(other: Poly) = {
	  
	  }
	  
	  
	  override def toString =
	  (for((exp, coeff) <- term) yield coeff+" x^ "+exp ) mkString " + "
	  
  }
  
  val polynomial1 = new Poly(Map(1 -> 2.0, 3 ->4.0, 5 -> 6.2))
                                                  //> polynomial1  : Week603.Poly = 2.0 x^ 1 + 4.0 x^ 3 + 6.2 x^ 5
  val polynomial2 = new Poly(Map(0 -> 3.0, 3 ->7.0))
                                                  //> polynomial2  : Week603.Poly = 3.0 x^ 0 + 7.0 x^ 3
   
    polynomial1 + polynomial2                     //> exp :0 coeff: 3.0
                                                  //| exp :3 coeff: 7.0
                                                  //| res2: Week603.Poly = 2.0 x^ 1 + 11.0 x^ 3 + 6.2 x^ 5 + 3.0 x^ 0
}