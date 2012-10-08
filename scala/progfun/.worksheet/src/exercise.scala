object exercise {import scala.runtime.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(178); 
  // 2-1
  def factorial(n: Int): Int = {
    def loop(acc: Int, n: Int): Int = {
      if (n == 0) acc
      else loop(acc * n, n - 1)
    }
    loop(1, n)
  };System.out.println("""factorial: (n: Int)Int""");$skip(18); val res$0 = 
  
  factorial(4);System.out.println("""res0: Int = """ + $show(res$0));$skip(15); val res$1 = 
  factorial(5);System.out.println("""res1: Int = """ + $show(res$1));$skip(182); 
  
  // 2-2
  def sum(f: Int => Int, a: Int, b:Int): Int = {
    def loop(a: Int, acc: Int): Int = {
      if (a > b) acc
      else loop(a + 1, acc + f(a))
    }
    loop(a, 0)
  };System.out.println("""sum: (f: Int => Int, a: Int, b: Int)Int""");$skip(23); val res$2 = 
  
  sum(x=>x*x, 1, 5);System.out.println("""res2: Int = """ + $show(res$2));$skip(124); 
  
  // 2-3
  def product(f: Int => Int)(a: Int, b: Int): Int = {
    if (a > b) 1
    else f(a) * product(f)(a + 1, b)
  };System.out.println("""product: (f: Int => Int)(a: Int, b: Int)Int""");$skip(24); val res$3 = 
  product(x=>x*x)(1, 3);System.out.println("""res3: Int = """ + $show(res$3));$skip(59); 
  
  def fact(n: Int): Int = {
    product(x=>x)(1, n)
  };System.out.println("""fact: (n: Int)Int""");$skip(10); val res$4 = 
  fact(4);System.out.println("""res4: Int = """ + $show(res$4));$skip(184); 
  
  def mapReduce(f: Int => Int, combine: (Int, Int) => Int, zero: Int)(a: Int, b: Int): Int = {
    if (a > b) zero
    else combine(f(a), mapReduce(f, combine, zero)(a + 1, b))
  };System.out.println("""mapReduce: (f: Int => Int, combine: (Int, Int) => Int, zero: Int)(a: Int, b: Int)Int""");$skip(93); 
  def mpProduct(f: Int => Int)(a: Int, b: Int): Int = mapReduce(f, (x, y) => x * y, 1)(a, b);System.out.println("""mpProduct: (f: Int => Int)(a: Int, b: Int)Int""");$skip(24); val res$5 = 
  mpProduct(x=>x)(1, 3);System.out.println("""res5: Int = """ + $show(res$5));$skip(92); 
  
  def mpSum(f: Int => Int)(a: Int, b: Int): Int = mapReduce(f, (x, y) => x + y, 0)(a, b);System.out.println("""mpSum: (f: Int => Int)(a: Int, b: Int)Int""");$skip(22); val res$6 = 
  mpSum(x=>x*x)(1, 3);System.out.println("""res6: Int = """ + $show(res$6))}
}