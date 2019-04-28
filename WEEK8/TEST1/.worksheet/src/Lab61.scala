object Lab61 {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(64); 

  val zones = java.util.TimeZone.getAvailableIDs;System.out.println("""zones  : Array[String] = """ + $show(zones ));$skip(31); val res$0 = 
  zones.map(s => s.split("/"));System.out.println("""res0: Array[Array[String]] = """ + $show(res$0));$skip(29); val res$1 = 
  
  zones.map(_.split("/"));System.out.println("""res1: Array[Array[String]] = """ + $show(res$1));$skip(95); val res$2 = 
  //zones.map(_.split("/")).map(_(1))
  zones.map(_.split("/")).filter(_.length > 1).map(_(1));System.out.println("""res2: Array[String] = """ + $show(res$2));$skip(69); val res$3 = 
  zones.map(_.split("/")).filter(_.length > 1).map(_(1)).grouped(10);System.out.println("""res3: Iterator[Array[String]] = """ + $show(res$3));$skip(77); val res$4 = 
  zones.map(_.split("/")).filter(_.length > 1).map(_(1)).grouped(10).toArray;System.out.println("""res4: Array[Array[String]] = """ + $show(res$4));$skip(87); val res$5 = 
  zones.map(_.split("/")).filter(_.length > 1).map(_(1)).grouped(10).toArray.map(_(0));System.out.println("""res5: Array[String] = """ + $show(res$5))}
}

object Lab62 {

  1.to(10).reduceLeft(_*_)
  1 to 10 reduceLeft(_*_)
    
  def factorial (n: Integer): Integer = {
  	1 to n reduceLeft(_*_)
  }
  
  factorial(5)
  
  val mulLR = (x: Int, y: Int) => x * y
  
  (1 to 5).reduceLeft(mulLR)
  

  1.to(10).map(x => 2)
  1.to(10).map(x => 2).reduceLeft(_*_)
  

  (1 to 10).map(x => 2).reduceLeft(_*_)
  
  def biN(n: Int): Int = {
  	1.to(n).map(s => 2).reduceLeft(_*_)
  }

	biN(10)
	
	def pow(a: Int, n: Int): Integer = {
  	1.to(n).map(s => a).reduceLeft(_*_)
  }
  
  pow(2,10)
  pow(5, 5)
	
	def concat(strings: Seq[String], separator: String): String = {
		strings.reduceLeft(_ + separator + _)
	}
	
	concat(Array("Mary", "had", "a", "little", "lamb"), " ")
	
	
	
		
		
		
	val n3 = 10
 	var i = 1
  var f = 1

	def While3(cond: => Boolean) (body: => Unit) {
  	if (cond) {
  		body
  		While3(cond) (body)
  	}
  }
  
  While3 (i < n3) {f *= i; i += 1}
  

}
