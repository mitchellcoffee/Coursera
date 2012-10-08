object exercise {
  // 2-1
  def factorial(n: Int): Int = {
    def loop(acc: Int, n: Int): Int = {
      if (n == 0) acc
      else loop(acc * n, n - 1)
    }
    loop(1, n)
  }                                               //> factorial: (n: Int)Int
  
  factorial(4)                                    //> res0: Int = 24
  factorial(5)                                    //> res1: Int = 120
  
  // 2-2
  def sum(f: Int => Int, a: Int, b:Int): Int = {
    def loop(a: Int, acc: Int): Int = {
      if (a > b) acc
      else loop(a + 1, acc + f(a))
    }
    loop(a, 0)
  }                                               //> sum: (f: Int => Int, a: Int, b: Int)Int
  
  sum(x=>x*x, 1, 5)                               //> res2: Int = 55
  
  // 2-3
  def product(f: Int => Int)(a: Int, b: Int): Int = {
    if (a > b) 1
    else f(a) * product(f)(a + 1, b)
  }                                               //> product: (f: Int => Int)(a: Int, b: Int)Int
  product(x=>x*x)(1, 3)                           //> res3: Int = 36
  
  def fact(n: Int): Int = {
    product(x=>x)(1, n)
  }                                               //> fact: (n: Int)Int
  fact(4)                                         //> res4: Int = 24
  
  def mapReduce(f: Int => Int, combine: (Int, Int) => Int, zero: Int)(a: Int, b: Int): Int = {
    if (a > b) zero
    else combine(f(a), mapReduce(f, combine, zero)(a + 1, b))
  }                                               //> mapReduce: (f: Int => Int, combine: (Int, Int) => Int, zero: Int)(a: Int, b:
                                                  //|  Int)Int
  def mpProduct(f: Int => Int)(a: Int, b: Int): Int = mapReduce(f, (x, y) => x * y, 1)(a, b)
                                                  //> mpProduct: (f: Int => Int)(a: Int, b: Int)Int
  mpProduct(x=>x)(1, 3)                           //> res5: Int = 6
  
  def mpSum(f: Int => Int)(a: Int, b: Int): Int = mapReduce(f, (x, y) => x + y, 0)(a, b)
                                                  //> mpSum: (f: Int => Int)(a: Int, b: Int)Int
  mpSum(x=>x*x)(1, 3)                             //> res6: Int = 14
  
  
  // 2-4
  
}