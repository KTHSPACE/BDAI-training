object Lab51 {

  import java.awt._;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(73); 
  val r= new Rectangle(5, 10, 20, 30);System.out.println("""r  : java.awt.Rectangle = """ + $show(r ));$skip(22); 
  r.translate(10, 20);$skip(4); val res$0 = 
  r;System.out.println("""res0: java.awt.Rectangle = """ + $show(res$0));$skip(52); 
 
  val egg = new geom.Ellipse2D.Double(5,10,20,30);System.out.println("""egg  : java.awt.geom.Ellipse2D.Double = """ + $show(egg ));$skip(6); val res$1 = 
  egg;System.out.println("""res1: java.awt.geom.Ellipse2D.Double = """ + $show(res$1));$skip(37); val res$2 = 
  
  
  //egg.translate(10,20)
  egg;System.out.println("""res2: java.awt.geom.Ellipse2D.Double = """ + $show(res$2))}

}
