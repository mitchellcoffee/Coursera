import weak3.Rational


object scratch {import scala.runtime.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(67); val res$0 = 
  new weak3.Rational(1, 2);System.out.println("""res0: weak3.Rational = """ + $show(res$0));$skip(21); val res$1 = 
  new Rational(2, 3);System.out.println("""res1: weak3.Rational = """ + $show(res$1));$skip(51); 
  
  def error(msg: String) = throw new Error(msg);System.out.println("""error: (msg: String)Nothing""");$skip(15); 
  val x = null;System.out.println("""x  : Null = """ + $show(x ));$skip(23); 
  val y: String = null;System.out.println("""y  : String = """ + $show(y ));$skip(26); 
  
  val z: Object = null;System.out.println("""z  : java.lang.Object = """ + $show(z ));$skip(28); val res$2 = 
  
  if (true) 1 else false;System.out.println("""res2: AnyVal = """ + $show(res$2))}
}