
object Lab1 {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(23); val res$0 = 

  4 * 3;System.out.println("""res0: Int(12) = """ + $show(res$0));$skip(8); val res$1 = 
  2 / 5;System.out.println("""res1: Int(0) = """ + $show(res$1));$skip(12); val res$2 = 
  2.0 / 5.0;System.out.println("""res2: Double(0.4) = """ + $show(res$2));$skip(8); val res$3 = 
  3 / 5;System.out.println("""res3: Int(0) = """ + $show(res$3));$skip(8); val res$4 = 
  3 % 5;System.out.println("""res4: Int(3) = """ + $show(res$4));$skip(19); 
  
  val a = 6 * 7;System.out.println("""a  : Int = """ + $show(a ));$skip(4); val res$5 = 
  a;System.out.println("""res5: Int = """ + $show(res$5));$skip(9); val res$6 = 
  a / 10;System.out.println("""res6: Int = """ + $show(res$6));$skip(25); 

  val b: BigInt = 6 * 7;System.out.println("""b  : BigInt = """ + $show(b ));$skip(14); val res$7 = 
  b.pow(1000)
  
  import scala.math._;System.out.println("""res7: scala.math.BigInt = """ + $show(res$7));$skip(36); val res$8 = 
  sqrt(10);System.out.println("""res8: Double = """ + $show(res$8));$skip(13); val res$9 = 
 
  1.to(10);System.out.println("""res9: scala.collection.immutable.Range.Inclusive = """ + $show(res$9));$skip(13); val res$10 = 
  
  1 to 10;System.out.println("""res10: scala.collection.immutable.Range.Inclusive = """ + $show(res$10));$skip(24); val res$11 = 
  1.to(10).map(sqrt(_));System.out.println("""res11: scala.collection.immutable.IndexedSeq[Double] = """ + $show(res$11));$skip(9); val res$12 = 
  6.*(7);System.out.println("""res12: Int(42) = """ + $show(res$12));$skip(32); val res$13 = 
  
  
  
  1 to 10 map(sqrt(_));System.out.println("""res13: scala.collection.immutable.IndexedSeq[Double] = """ + $show(res$13));$skip(21); 
  

  val c: Int = 5;System.out.println("""c  : Int = """ + $show(c ));$skip(10); val res$14 = 
  sqrt(c);System.out.println("""res14: Double = """ + $show(res$14));$skip(28); val res$15 = 
  
  "Mississippi".distinct;System.out.println("""res15: String = """ + $show(res$15));$skip(23); val res$16 = 
  "Rhine".permutations;System.out.println("""res16: Iterator[String] = """ + $show(res$16));$skip(31); val res$17 = 
  "Rhine".permutations.toArray;System.out.println("""res17: Array[String] = """ + $show(res$17));$skip(12); val res$18 = 
  "ABC".sum;System.out.println("""res18: Char = """ + $show(res$18));$skip(12); val res$19 = 
  'A'.toInt;System.out.println("""res19: Int = """ + $show(res$19));$skip(12); val res$20 = 
  'B'.toInt;System.out.println("""res20: Int = """ + $show(res$20));$skip(13); val res$21 = 
   'C'.toInt;System.out.println("""res21: Int = """ + $show(res$21));$skip(19); val res$22 = 
   "ABC".sum.toInt;System.out.println("""res22: Int = """ + $show(res$22))}
  
}
