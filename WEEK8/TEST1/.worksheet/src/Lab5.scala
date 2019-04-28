object Lab5 {

 import java.awt._;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(71); 
  val r= new Rectangle(5, 10, 20, 30);System.out.println("""r  : java.awt.Rectangle = """ + $show(r ));$skip(22); 
  r.translate(10, 20);$skip(4); val res$0 = 
  r
  
  trait RectangleLike {
  	def setFrame(x: Double, y: Double, w: Double, h: Double): Unit
  	def getX: Double
  	def getY: Double
  	def getWidth: Double
  	def getHeight: Double
  	def translate(dx: Double, dy: Double) { setFrame(getX+dx, getY+dy, getWidth, getHeight) }
  	override def toString = f"(${getX}, ${getY})"
  };System.out.println("""res0: java.awt.Rectangle = """ + $show(res$0));$skip(401); 
  

  val egg = new geom.Ellipse2D.Double(5,10,20,30) with RectangleLike;System.out.println("""egg  : java.awt.geom.Ellipse2D.Double with Lab5.RectangleLike = """ + $show(egg ));$skip(23); 
  egg.translate(10,20);$skip(6); val res$1 = 
  egg
  
  
  
  
  
  
  
  
  
  
  
  
  
  import java.io._
  
  trait Logged {
  	def log(msg: String) {}
  }
  
  trait ConsoleLogger extends Logged {
  	override def log(msg: String) { println(msg)}
  }
  
  trait Buffered extends InputStream with Logged {
  	val SIZE = 1024
  	private var end = 0
  	private val buffer = new Array[Byte](SIZE)
  	private var pos = 0
  	
  	override def read() = {
  		if (pos == end) {
  			log("Buffer was empty")
  			end = super.read(buffer, 0, SIZE)
  			pos = 0
  		}
  		if (pos == end) -1
  		else {
  			pos += 1
  			buffer(pos - 1)
  		}
   	}
  };System.out.println("""res1: java.awt.geom.Ellipse2D.Double with Lab5.RectangleLike = """ + $show(res$1));$skip(655); 
  
  var myfile = new File("C:\\Users\\HenryPark\\test.txt");System.out.println("""myfile  : java.io.File = """ + $show(myfile ));$skip(79); 
  var in = new FileInputStream("C:\\Users\\HenryPark\\test.txt") with Buffered;System.out.println("""in  : java.io.FileInputStream with Lab5.Buffered = """ + $show(in ));$skip(10); val res$2 = 
  in.read;System.out.println("""res2: Int = """ + $show(res$2));$skip(105); 
  
  
  var in2 = new FileInputStream("C:\\Users\\HenryPark\\test.txt") with Buffered with ConsoleLogger;System.out.println("""in2  : java.io.FileInputStream with Lab5.Buffered with Lab5.ConsoleLogger = """ + $show(in2 ));$skip(11); val res$3 = 
  in2.read;System.out.println("""res3: Int = """ + $show(res$3));$skip(11); val res$4 = 
  in2.read;System.out.println("""res4: Int = """ + $show(res$4))}
  
  
  
  
  
  
  
  
  
}
