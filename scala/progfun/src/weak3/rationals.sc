object rationals {

  val x = new Rational(1, 2)                      //> x  : Rational = 1/2
  x.numer                                         //> res0: Int = 1
  x.denom                                         //> res1: Int = 2
  
  val y = new Rational(2, 3)                      //> y  : Rational = 2/3
  x + y                                           //> res2: Rational = 7/6
  
  -x                                              //> res3: Rational = 1/-2
  x - y                                           //> res4: Rational = 1/-6
  
  val a = new Rational(1, 3)                      //> a  : Rational = 1/3
  val b = new Rational(5, 7)                      //> b  : Rational = 5/7
  val c = new Rational(3, 2)                      //> c  : Rational = 3/2
  a - b - c                                       //> res5: Rational = -79/42
  
  b + b                                           //> res6: Rational = 10/7
  b.max(a)                                        //> res7: Rational = 5/7
  
  val d = new Rational(4)                         //> d  : Rational = 4/1
  
  x < y                                           //> res8: Boolean = true
  b max a                                         //> res9: Rational = 5/7
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