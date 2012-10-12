object rationals {import scala.runtime.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(48); 

  val x = new Rational(1, 2);System.out.println("""x  : Rational = """ + $show(x ));$skip(10); val res$0 = 
  x.numer;System.out.println("""res0: Int = """ + $show(res$0));$skip(10); val res$1 = 
  x.denom;System.out.println("""res1: Int = """ + $show(res$1));$skip(32); 
  
  val y = new Rational(2, 3);System.out.println("""y  : Rational = """ + $show(y ));$skip(8); val res$2 = 
  x + y;System.out.println("""res2: Rational = """ + $show(res$2));$skip(8); val res$3 = 
  
  -x;System.out.println("""res3: Rational = """ + $show(res$3));$skip(8); val res$4 = 
  x - y;System.out.println("""res4: Rational = """ + $show(res$4));$skip(32); 
  
  val a = new Rational(1, 3);System.out.println("""a  : Rational = """ + $show(a ));$skip(29); 
  val b = new Rational(5, 7);System.out.println("""b  : Rational = """ + $show(b ));$skip(29); 
  val c = new Rational(3, 2);System.out.println("""c  : Rational = """ + $show(c ));$skip(12); val res$5 = 
  a - b - c;System.out.println("""res5: Rational = """ + $show(res$5));$skip(11); val res$6 = 
  
  b + b;System.out.println("""res6: Rational = """ + $show(res$6));$skip(11); val res$7 = 
  b.max(a);System.out.println("""res7: Rational = """ + $show(res$7));$skip(29); 
  
  val d = new Rational(4);System.out.println("""d  : Rational = """ + $show(d ));$skip(11); val res$8 = 
  
  x < y;System.out.println("""res8: Boolean = """ + $show(res$8));$skip(10); val res$9 = 
  b max a;System.out.println("""res9: Rational = """ + $show(res$9))}
}

class Rational(x: Int, y: Int) {
  require(y != 0, "denominator must be non-zero")

  def this(x: Int) = this(x, 1)
  
  private def gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)
  private val g = gcd(x, y)
//  def numer = x;
//  def denom = y;
  def numer = x / g;
  def denom = y / g;
  
  def + (that: Rational) =
    new Rational(
      numer * that.denom + that.numer * denom,
      denom * that.denom)
      
//  override def toString = {
//    val g = gcd(x, y)
//    numer / g + "/" + denom / g
//  }
  
  override def toString = numer + "/" + denom
  
  def unary_- : Rational = new Rational(-numer, denom)
  /*
  def sub(that: Rational) =
    new Rational(
      numer * that.denom - that.numer * denom,
      denom * that.denom)
  */
  def - (that: Rational) = this + -that
  
//  def less(that:Rational) = numer * that.denom < that.numer * denom
  
  def <(that:Rational) = numer * that.denom < that.numer * denom
  def max(that: Rational) = if (this < that) that else this
  
  
}