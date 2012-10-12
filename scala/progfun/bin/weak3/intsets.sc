object intsets {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  
  val t1 = new NonEmpty(3, new Empty, new Empty)  //> t1  : NonEmpty = {.3.}
  val t2 = t1 incl 4                              //> t2  : IntSet = {.3{.4.}}
  
  val t3 = new NonEmpty(7, new Empty, new Empty)  //> t3  : NonEmpty = {.7.}
  val t4 = t3 incl 5 incl 12                      //> t4  : IntSet = {{.5.}7{.12.}}
  
  t2 union t4                                     //> res0: IntSet = {{{{.3.}4.}5.}7{.12.}}
}

abstract class IntSet {
  def incl(x: Int): IntSet
  def contains(x: Int): Boolean
  def union(other: IntSet): IntSet
}

class NonEmpty(elem: Int, left: IntSet, right: IntSet) extends IntSet {
  def contains(x: Int): Boolean =
    if (x < elem) left contains x
    else if (x > elem) right contains x
    else true
    
  def incl(x: Int): IntSet =
    if (x < elem) new NonEmpty(elem, left incl x, right)
    else if (x > elem) new NonEmpty(elem, left, right incl x)
    else this
  
  def union(other: IntSet): IntSet = {
    ((left union right) union other) incl elem
  }
  
  override def toString = "{" + left + elem + right + "}"
}


class Empty extends IntSet {
  def contains(x: Int): Boolean = false
  def incl(x: Int): IntSet = new NonEmpty(x, new Empty, new Empty)
  def union(other: IntSet): IntSet = other
  override def toString = "."
}