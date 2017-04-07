object Week603 {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(60); 
  println("Welcome to the Scala worksheet");$skip(57); 
  val romanNumbers = Map ("I" -> 1, "V" -> 5, "X" -> 10);System.out.println("""romanNumbers  : scala.collection.immutable.Map[String,Int] = """ + $show(romanNumbers ));$skip(24); val res$0 = 
 
 romanNumbers get "I";System.out.println("""res0: Option[Int] = """ + $show(res$0));$skip(19); val res$1 = 
 romanNumbers("I")
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
	  
  };System.out.println("""res1: Int = """ + $show(res$1));$skip(682); 
  
  val polynomial1 = new Poly(Map(1 -> 2.0, 3 ->4.0, 5 -> 6.2));System.out.println("""polynomial1  : Week603.Poly = """ + $show(polynomial1 ));$skip(53); 
  val polynomial2 = new Poly(Map(0 -> 3.0, 3 ->7.0));System.out.println("""polynomial2  : Week603.Poly = """ + $show(polynomial2 ));$skip(34); val res$2 = 
   
    polynomial1 + polynomial2;System.out.println("""res2: Week603.Poly = """ + $show(res$2))}
}
