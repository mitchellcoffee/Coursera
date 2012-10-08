package recfun
import common._

object Main {
  def main(args: Array[String]) {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }
  }

  /**
   * Exercise 1
   */
  def pascal(c: Int, r: Int): Int = {
    if (c == 0 || r == c) 1
    else pascal(c-1, r-1) + pascal(c, r-1)
    
  }

  /**
   * Exercise 2
   */
  def balance(chars: List[Char]): Boolean = {
    def balanceIter(chars: List[Char], stack: Int): Boolean = {
      if (stack >= 0)
        if (chars.isEmpty) stack == 0
        else if (chars.head == '(') balanceIter(chars.tail, stack + 1)
        else if (chars.head == ')') balanceIter(chars.tail, stack - 1)
        else balanceIter(chars.tail, stack)
      else false
    }
    
    balanceIter(chars, 0)
  }

  /**
   * Exercise 3
   */
  def countChange(money: Int, coins: List[Int]): Int = {
    if (money == 0) 1
    else if (money < 0 || coins.isEmpty) 0
    else countChange(money - coins.head, coins) + countChange(money, coins.tail)
  }
}
