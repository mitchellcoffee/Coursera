import weak3.Rational


object scratch {
  new weak3.Rational(1, 2)                        //> res0: weak3.Rational = 1/2
  new Rational(2, 3)                              //> res1: weak3.Rational = 2/3
  
  def error(msg: String) = throw new Error(msg)   //> error: (msg: String)Nothing
  val x = null                                    //> x  : Null = null
  val y: String = null                            //> y  : String = null
  
  val z: Object = null                            //> z  : java.lang.Object = null
  
  if (true) 1 else false                          //> res2: AnyVal = 1
}