object Lab72 {

	abstract class Item
	case class Article(description: String, price: Double) extends Item
	case class Bundle(description: String, discount: Double, items: Item*) extends Item
	
	def price (it: Item): Double = {
		it match {
			case Article(_,p) => p
			case Bundle(_,dis,its@_*) =>  its.map(price).sum - dis
		}
	}                                         //> price: (it: Lab72.Item)Double
	
	val book = Article("Learn Scala", 39.95)  //> book  : Lab72.Article = Article(Learn Scala,39.95)
	val jinro = Article("Jinro Soju", 9.95)   //> jinro  : Lab72.Article = Article(Jinro Soju,9.95)
	
	val gift = Bundle("Book and Booze", 10, book, jinro)
                                                  //> gift  : Lab72.Bundle = Bundle(Book and Booze,10.0,WrappedArray(Article(Learn
                                                  //|  Scala,39.95), Article(Jinro Soju,9.95)))
	val likeFirst = Article("Like First", 9.95)
                                                  //> likeFirst  : Lab72.Article = Article(Like First,9.95)
	val soju = Bundle("Soju Sampler", 5.0, jinro, likeFirst)
                                                  //> soju  : Lab72.Bundle = Bundle(Soju Sampler,5.0,WrappedArray(Article(Jinro So
                                                  //| ju,9.95), Article(Like First,9.95)))
	val special = Bundle("Father's Day Special", 10.0, book, soju)
                                                  //> special  : Lab72.Bundle = Bundle(Father's Day Special,10.0,WrappedArray(Arti
                                                  //| cle(Learn Scala,39.95), Bundle(Soju Sampler,5.0,WrappedArray(Article(Jinro S
                                                  //| oju,9.95), Article(Like First,9.95)))))
	val special2 = Bundle("Father's Day Special", 10.0, Article("Learn Scala", 39.95),
	Bundle("Soju Sampler", 5.0,
		Article("Jinro", 9.95),
		Article("Like First", 9.95)))     //> special2  : Lab72.Bundle = Bundle(Father's Day Special,10.0,WrappedArray(Art
                                                  //| icle(Learn Scala,39.95), Bundle(Soju Sampler,5.0,WrappedArray(Article(Jinro,
                                                  //| 9.95), Article(Like First,9.95)))))
	
	price(book)                               //> res0: Double = 39.95
	price(gift)                               //> res1: Double = 39.900000000000006
	price(special2)                           //> res2: Double = 44.85
	(39.95 + (9.95 + 9.95 - 5.0) - 10.0)      //> res3: Double = 44.85
	price(soju)                               //> res4: Double = 14.899999999999999
	price(special)                            //> res5: Double = 44.85
	
	val Bundle(_,_,Article(des, pr), _) = special2
                                                  //> des  : String = Learn Scala
                                                  //| pr  : Double = 39.95
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
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
	}
	
	def inv(x: Double) = if (x == 0) NoDouble else SomeDouble(1 / x)
                                                  //> inv: (x: Double)Product with Serializable with Lab72.DoubleOption
	
	inv(2)                                    //> res6: Product with Serializable with Lab72.DoubleOption = SomeDouble(0.5)
  inv(0)                                          //> res7: Product with Serializable with Lab72.DoubleOption = NoDouble
	
	import scala.math._
	
	def f(x: Double) = if (x <= 1) SomeDouble(sqrt(1-x)) else NoDouble
                                                  //> f: (x: Double)Product with Serializable with Lab72.DoubleOption
	
	def compose(f: Double => DoubleOption, g: Double => DoubleOption) = {
		(x: Double) => g(x) match {
			case SomeDouble(result) => f(result)
			case NoDouble => NoDouble
		}
	}                                         //> compose: (f: Double => Lab72.DoubleOption, g: Double => Lab72.DoubleOption)
                                                  //| Double => Lab72.DoubleOption
	
	val h = compose(f, inv)                   //> h  : Double => Lab72.DoubleOption = Lab72$$$Lambda$14/546718765@234bef66
	
	h(0)                                      //> res8: Lab72.DoubleOption = NoDouble
	h(1)                                      //> res9: Lab72.DoubleOption = SomeDouble(0.0)
	h(2)                                      //> res10: Lab72.DoubleOption = SomeDouble(0.7071067811865476)
	inv(2)                                    //> res11: Product with Serializable with Lab72.DoubleOption = SomeDouble(0.5)
                                                  //| 
	f(0.5)                                    //> res12: Product with Serializable with Lab72.DoubleOption = SomeDouble(0.707
                                                  //| 1067811865476)
	
	def isEmpty(opt: DoubleOption) = opt match {
		case NoDouble => true
		case _ => false
	}                                         //> isEmpty: (opt: Lab72.DoubleOption)Boolean

	def get(opt: DoubleOption) = opt match {
		case NoDouble => throw new NoSuchElementException
		case SomeDouble(value) => value
	}                                         //> get: (opt: Lab72.DoubleOption)Double

  isEmpty(inv(2))                                 //> res13: Boolean = false
	f(get(inv(2)))                            //> res14: Product with Serializable with Lab72.DoubleOption = SomeDouble(0.707
                                                  //| 1067811865476)
  isEmpty(inv(0))                                 //> res15: Boolean = true



	


  
    
    
    
    
    

}