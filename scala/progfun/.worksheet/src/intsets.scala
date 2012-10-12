object intsets {import scala.runtime.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(60); 
  println("Welcome to the Scala worksheet");$skip(52); 
  
  val t1 = new NonEmpty(3, new Empty, new Empty);System.out.println("""t1  : NonEmpty = """ + $show(t1 ));$skip(21); 
  val t2 = t1 incl 4;System.out.println("""t2  : IntSet = """ + $show(t2 ));$skip(52); 
  
  val t3 = new NonEmpty(7, new Empty, new Empty);System.out.println("""t3  : NonEmpty = """ + $show(t3 ));$skip(29); 
  val t4 = t3 incl 5 incl 12;System.out.println("""t4  : IntSet = """ + $show(t4 ));$skip(17); val res$0 = 
  
  t2 union t4;System.out.println("""res0: IntSet = """ + $show(res$0))}
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