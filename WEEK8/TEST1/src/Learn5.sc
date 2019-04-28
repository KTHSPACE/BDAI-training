object Lab5 {

 import java.awt._
  val r= new Rectangle(5, 10, 20, 30)             //> r  : java.awt.Rectangle = java.awt.Rectangle[x=5,y=10,width=20,height=30]
  r.translate(10, 20)
  r                                               //> res0: java.awt.Rectangle = java.awt.Rectangle[x=15,y=30,width=20,height=30]
  
  trait RectangleLike {
  	def setFrame(x: Double, y: Double, w: Double, h: Double): Unit
  	def getX: Double
  	def getY: Double
  	def getWidth: Double
  	def getHeight: Double
  	def translate(dx: Double, dy: Double) { setFrame(getX+dx, getY+dy, getWidth, getHeight) }
  	override def toString = f"(${getX}, ${getY})"
  }
  

  val egg = new geom.Ellipse2D.Double(5,10,20,30) with RectangleLike
                                                  //> egg  : java.awt.geom.Ellipse2D.Double with Lab5.RectangleLike = (5.0, 10.0)
                                                  //| 
  egg.translate(10,20)
  egg                                             //> res1: java.awt.geom.Ellipse2D.Double with Lab5.RectangleLike = (15.0, 30.0)
                                                  //| 
  
  
  
  
  
  
  
  
  
  
  
  
  
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
  }
  
  var myfile = new File("C:\\Users\\HenryPark\\test.txt")
                                                  //> myfile  : java.io.File = C:\Users\HenryPark\test.txt
  var in = new FileInputStream("C:\\Users\\HenryPark\\test.txt") with Buffered
                                                  //> java.io.FileNotFoundException: C:\Users\HenryPark\test.txt (지정된 경로를 �
                                                  //| ＠� 수 없습니다)
                                                  //| 	at java.io.FileInputStream.open0(Native Method)
                                                  //| 	at java.io.FileInputStream.open(Unknown Source)
                                                  //| 	at java.io.FileInputStream.<init>(Unknown Source)
                                                  //| 	at java.io.FileInputStream.<init>(Unknown Source)
                                                  //| 	at Lab5$$anon$3.<init>(Lab5.scala:66)
                                                  //| 	at Lab5$.$anonfun$main$1(Lab5.scala:66)
                                                  //| 	at org.scalaide.worksheet.runtime.library.WorksheetSupport$.$anonfun$$ex
                                                  //| ecute$1(WorksheetSupport.scala:76)
                                                  //| 	at org.scalaide.worksheet.runtime.library.WorksheetSupport$.redirected(W
                                                  //| orksheetSupport.scala:65)
                                                  //| 	at org.scalaide.worksheet.runtime.library.WorksheetSupport$.$execute(Wor
                                                  //| ksheetSupport.scala:76)
                                                  //| 	at Lab5$.main(Lab5.scala:3)
                                                  //| 	at Lab5.main(Lab5.scala)
  in.read
  
  
  var in2 = new FileInputStream("C:\\Users\\HenryPark\\test.txt") with Buffered with ConsoleLogger
  in2.read
  in2.read
  
  
  
  
  
  
  
  
  
}