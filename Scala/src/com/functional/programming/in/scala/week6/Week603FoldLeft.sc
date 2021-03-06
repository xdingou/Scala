object Week603FoldLeft {
 
 //x^3 + 2x + 5  = > Map(3 -> 1, 1 -> 2, 0 -> 5 )
 //2x^3 + 3x + 5 = > Map(3 -> 2, 1 -> 3, 0 -> 5 )
  class Poly(val term0: Map[Int, Double]){
  
  	//Auxillary Constructor
  	def this(bindings: (Int, Double)*) = this(bindings.toMap)
  	
  	//With Default Value for Maps
  	val term  = term0 withDefaultValue 0.0
  	
  	//++ adds / combines two maps, key value will overwritten from second map
	  def + (other: Poly) = new Poly((term foldLeft other.term)(addTerm))
	  
	  def addTerm(terms: Map[Int, Double],term : (Int, Double)):Map[Int, Double] = {
	  	
	  	val (exp, coeff) = term
	  	
	  	println("exp :"+exp +" coeff: "+coeff);
	  	
		  terms + (exp -> (coeff + terms(exp)))
	  }
	  
	  override def toString =
	  (for((exp, coeff) <- term.toList.sorted.reverse) yield coeff+" x^ "+exp ) mkString " + "
	  
  }
  
  val polynomial1 = new Poly(1 -> 2.0, 3 ->4.0, 5 -> 6.2)
                                                  //> polynomial1  : Week603FoldLeft.Poly = 6.2 x^ 5 + 4.0 x^ 3 + 2.0 x^ 1
  val polynomial2 = new Poly(0 -> 3.0, 3 ->7.0)   //> polynomial2  : Week603FoldLeft.Poly = 7.0 x^ 3 + 3.0 x^ 0
   
    polynomial1 + polynomial2                     //> exp :1 coeff: 2.0
                                                  //| exp :3 coeff: 4.0
                                                  //| exp :5 coeff: 6.2
                                                  //| res0: Week603FoldLeft.Poly = 6.2 x^ 5 + 11.0 x^ 3 + 2.0 x^ 1 + 3.0 x^ 0
}