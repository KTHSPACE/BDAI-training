object Lab3 {
  
  import scala.collection.mutable.ArrayBuffer;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(133); 
   
  val a = ArrayBuffer(3, 6, 7, 3,-4, 8, -3, -5, 6, 7, -2, 9, -1);System.out.println("""a  : scala.collection.mutable.ArrayBuffer[Int] = """ + $show(a ));$skip(11); val res$0 = 
 	
 	a(3);System.out.println("""res0: Int = """ + $show(res$0));$skip(219); 
 	  
  def rmNeg1(a: ArrayBuffer[Int]): ArrayBuffer[Int] = {
   	var negs = for (i <- 0 until a.length if (a(i) < 0)) yield i
   	negs = negs.drop(1)

   	negs = negs.reverse
   	for (i <- negs) a.remove(i)
   	a
  };System.out.println("""rmNeg1: (a: scala.collection.mutable.ArrayBuffer[Int])scala.collection.mutable.ArrayBuffer[Int]""");$skip(498); 
  
  def rmNeg2(a: ArrayBuffer[Int]): ArrayBuffer[Int] = {
  	var leng = a.length
  	var i = 0
  	var firstNeg = false
  	
   	while (!firstNeg && (i < leng)) {
   		if (a(i) >= 0) i += 1
   		else {
   			firstNeg = true
   			i += 1
   		}
   	}
   	// we get here because either we saw our first neg or we reached the end of the array
   	if (firstNeg) {
   		while (i < leng) {
	   		if (a(i) >= 0) i += 1
	   		else {
	   			a.remove(i)
	   			leng -= 1
	   		}
   		}
   	}
   	
   	a
  };System.out.println("""rmNeg2: (a: scala.collection.mutable.ArrayBuffer[Int])scala.collection.mutable.ArrayBuffer[Int]""");$skip(18); val res$1 = 
   
   rmNeg1(a);System.out.println("""res1: scala.collection.mutable.ArrayBuffer[Int] = """ + $show(res$1))}
   //rmNeg2(a)
   
}


object Lab32 {

  import scala.io.Source

	val filename = "C:\\Users\\HenryPark\\Desktop\\Scala Lecture\\alice.txt"
	
	val count = scala.collection.mutable.Map[String, Int]()
	for (line <- Source.fromFile(filename).getLines) {
		for (word <- line.split(" ")) {
			count(word) = count.getOrElse(word,0) + 1
		}
	}
  
  count("Alice")
  count("Rabbit")

	var count2 = scala.collection.immutable.Map[String, Int]()
	for (line <- Source.fromFile(filename).getLines) {
		for (word <- line.split(" ")) {
			val cnt = count2.getOrElse(word,0) + 1
			count2 = count2 + (word -> cnt)
			
		}
	}
	
	count2("Alice")
	count2("Rabbit")
  
}


object Lab33 {
 
  val words = Array("Mary", "had", "a", "little", "lamb", "its", "fleece", "was", "white", "as", "snow",
  									"and", "everywhere", "that", "Mary", "went", "the", "lamb", "was", "sure", "to", "go")
  									
  val groupedBy1stLetter = words.groupBy(_.substring(0,1))
  
  groupedBy1stLetter("t")
  
  val groupedByLength = words.groupBy(_.length)
  
  groupedByLength(3)
  
  def evenLength(s: String): Boolean = s.length % 2 == 0
  
  val groupedByEven = words.groupBy(evenLength(_))
  
  groupedByEven(true)
  
}
object Lab34 {
	"New York".partition(_.isUpper)
	import scala.collection.mutable.ArrayBuffer
  val b = ArrayBuffer(3, 6, 7, 3, -4, 8, -3, -5, 6, 7, -2, 9, -1)
  val (neg, pos) = b.partition(_ < 0)
  val result = pos
  result += neg(0)
  
}
