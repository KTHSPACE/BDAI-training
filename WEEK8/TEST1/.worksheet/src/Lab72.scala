object Lab72 {

	abstract class Item
	case class Article(description: String, price: Double) extends Item
	case class Bundle(description: String, discount: Double, items: Item*) extends Item;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(330); 
	
	def price (it: Item): Double = {
		it match {
			case Article(_,p) => p
			case Bundle(_,dis,its@_*) =>  its.map(price).sum - dis
		}
	};System.out.println("""price: (it: Lab72.Item)Double""");$skip(44); 
	
	val book = Article("Learn Scala", 39.95);System.out.println("""book  : Lab72.Article = """ + $show(book ));$skip(41); 
	val jinro = Article("Jinro Soju", 9.95);System.out.println("""jinro  : Lab72.Article = """ + $show(jinro ));$skip(56); 
	
	val gift = Bundle("Book and Booze", 10, book, jinro);System.out.println("""gift  : Lab72.Bundle = """ + $show(gift ));$skip(45); 
	val likeFirst = Article("Like First", 9.95);System.out.println("""likeFirst  : Lab72.Article = """ + $show(likeFirst ));$skip(58); 
	val soju = Bundle("Soju Sampler", 5.0, jinro, likeFirst);System.out.println("""soju  : Lab72.Bundle = """ + $show(soju ));$skip(64); 
	val special = Bundle("Father's Day Special", 10.0, book, soju);System.out.println("""special  : Lab72.Bundle = """ + $show(special ));$skip(171); 
	val special2 = Bundle("Father's Day Special", 10.0, Article("Learn Scala", 39.95),
	Bundle("Soju Sampler", 5.0,
		Article("Jinro", 9.95),
		Article("Like First", 9.95)));System.out.println("""special2  : Lab72.Bundle = """ + $show(special2 ));$skip(15); val res$0 = 
	
	price(book);System.out.println("""res0: Double = """ + $show(res$0));$skip(13); val res$1 = 
	price(gift);System.out.println("""res1: Double = """ + $show(res$1));$skip(17); val res$2 = 
	price(special2);System.out.println("""res2: Double = """ + $show(res$2));$skip(38); val res$3 = 
	(39.95 + (9.95 + 9.95 - 5.0) - 10.0);System.out.println("""res3: Double = """ + $show(res$3));$skip(13); val res$4 = 
	price(soju);System.out.println("""res4: Double = """ + $show(res$4));$skip(16); val res$5 = 
	price(special);System.out.println("""res5: Double = """ + $show(res$5));$skip(50); 
	
	val Bundle(_,_,Article(des, pr), _) = special2
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
	abstract class DoubleOption {
		def isEmpty: Boolean
		def get: Double
	}
	case class SomeDouble(value: Double) extends DoubleOption {
		def isEmpty = true
		def get = value
	}
	case object NoDouble extends DoubleOption {
		def isEmpty = false
		def get = throw new NoSuchElementException
	};System.out.println("""des  : String = """ + $show(des ));System.out.println("""pr  : Double = """ + $show(pr ));$skip(456); 
	
	def inv(x: Double) = if (x == 0) NoDouble else SomeDouble(1 / x);System.out.println("""inv: (x: Double)Product with Serializable with Lab72.DoubleOption""");$skip(10); val res$6 = 
	
	inv(2);System.out.println("""res6: Product with Serializable with Lab72.DoubleOption = """ + $show(res$6));$skip(9); val res$7 = 
  inv(0)
	
	import scala.math._;System.out.println("""res7: Product with Serializable with Lab72.DoubleOption = """ + $show(res$7));$skip(93); 
	
	def f(x: Double) = if (x <= 1) SomeDouble(sqrt(1-x)) else NoDouble;System.out.println("""f: (x: Double)Product with Serializable with Lab72.DoubleOption""");$skip(179); 
	
	def compose(f: Double => DoubleOption, g: Double => DoubleOption) = {
		(x: Double) => g(x) match {
			case SomeDouble(result) => f(result)
			case NoDouble => NoDouble
		}
	};System.out.println("""compose: (f: Double => Lab72.DoubleOption, g: Double => Lab72.DoubleOption)Double => Lab72.DoubleOption""");$skip(27); 
	
	val h = compose(f, inv);System.out.println("""h  : Double => Lab72.DoubleOption = """ + $show(h ));$skip(8); val res$8 = 
	
	h(0);System.out.println("""res8: Lab72.DoubleOption = """ + $show(res$8));$skip(6); val res$9 = 
	h(1);System.out.println("""res9: Lab72.DoubleOption = """ + $show(res$9));$skip(6); val res$10 = 
	h(2);System.out.println("""res10: Lab72.DoubleOption = """ + $show(res$10));$skip(8); val res$11 = 
	inv(2);System.out.println("""res11: Product with Serializable with Lab72.DoubleOption = """ + $show(res$11));$skip(8); val res$12 = 
	f(0.5);System.out.println("""res12: Product with Serializable with Lab72.DoubleOption = """ + $show(res$12));$skip(93); 
	
	def isEmpty(opt: DoubleOption) = opt match {
		case NoDouble => true
		case _ => false
	};System.out.println("""isEmpty: (opt: Lab72.DoubleOption)Boolean""");$skip(132); 

	def get(opt: DoubleOption) = opt match {
		case NoDouble => throw new NoSuchElementException
		case SomeDouble(value) => value
	};System.out.println("""get: (opt: Lab72.DoubleOption)Double""");$skip(19); val res$13 = 

  isEmpty(inv(2));System.out.println("""res13: Boolean = """ + $show(res$13));$skip(16); val res$14 = 
	f(get(inv(2)));System.out.println("""res14: Product with Serializable with Lab72.DoubleOption = """ + $show(res$14));$skip(18); val res$15 = 
  isEmpty(inv(0));System.out.println("""res15: Boolean = """ + $show(res$15))}



	


  
    
    
    
    
    

}
