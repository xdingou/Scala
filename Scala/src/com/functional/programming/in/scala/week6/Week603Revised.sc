import scala.collection.immutable.Map.WithDefault

object Week603Revised {
 
 //x^3 + 2x + 5  = > Map(3 -> 1, 1 -> 2, 0 -> 5 )
 //2x^3 + 3x + 5 = > Map(3 -> 2, 1 -> 3, 0 -> 5 )
  class Poly(val term0: Map[Int, Double]){
  
  	//Auxillary Constructor
  	def this(bindings: (Int, Double)*) = this(bindings.toMap)
  	
  	//With Default Value for Maps
  	val term  = term0 withDefaultValue 0.0
  	
  	//++ adds / combines two maps, key value will overwritten from second map
	  def + (other: Poly) = new Poly(term ++ (other.term map adjust) )
	  
	  def adjust(terms: (Int, Double)):(Int, Double) = {
	  	
	  	val (exp, coeff) = terms
	  	
	  	println("exp :"+exp +" coeff: "+coeff);
	  	
		  exp -> (coeff + term(exp))
	  }
	  
	  override def toString =
	  (for((exp, coeff) <- term) yield coeff+" x^ "+exp ) mkString " + "
	  
  }
  
  val polynomial1 = new Poly(1 -> 2.0, 3 ->4.0, 5 -> 6.2)
                                                  //> polynomial1  : Week603Revised.Poly = 2.0 x^ 1 + 4.0 x^ 3 + 6.2 x^ 5
  val polynomial2 = new Poly(0 -> 3.0, 3 ->7.0)   //> polynomial2  : Week603Revised.Poly = 3.0 x^ 0 + 7.0 x^ 3
   
    polynomial1 + polynomial2                     //> exp :0 coeff: 3.0
                                                  //| exp :3 coeff: 7.0
                                                  //| res0: Week603Revised.Poly = 2.0 x^ 1 + 11.0 x^ 3 + 6.2 x^ 5 + 3.0 x^ 0
}