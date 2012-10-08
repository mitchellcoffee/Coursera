import math.abs


object fixpoint {
  val tolerance = 0.0001                          //> tolerance  : Double = 1.0E-4
  def isCloseEnough(x: Double, y: Double) =
    abs((x - y) / x) /x < tolerance               //> isCloseEnough: (x: Double, y: Double)Boolean
  def fixedPoint(f: Double => Double)(firstGuess: Double) = {
    def iterate(guess: Double): Double = {
      val next = f(guess)
      if (isCloseEnough(guess, next)) next
      else iterate(next)
    }
    iterate(firstGuess)
  }                                               //> fixedPoint: (f: Double => Double)(firstGuess: Double)Double
  
  fixedPoint(x => 1 + x/2)(1)                     //> res0: Double = 1.999755859375
  fixedPoint(x => 1.0 / 2 * x + 1)(2)             //> res1: Double = 2.0
  
  
  def sqrt(x: Double) = fixedPoint(y => (y + x/y)/2)(1.0)
                                                  //> sqrt: (x: Double)Double
  sqrt(2)                                         //> res2: Double = 1.4142135623746899
  
  
  def averageDamp(f: Double => Double)(x: Double): Double = (x + f(x)) / 2
                                                  //> averageDamp: (f: Double => Double)(x: Double)Double
  def sqrt2(x: Double) =
    fixedPoint(averageDamp(y => x/y))(1)          //> sqrt2: (x: Double)Double
    
  sqrt2(3)                                        //> res3: Double = 1.7320508100147274
  
  
}