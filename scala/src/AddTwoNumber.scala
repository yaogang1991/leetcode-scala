object AddTwoNumber {
  def main(args: Array[String]): Unit = {
    val l1 = new ListNode(2)
    l1.next = new ListNode(4)
    l1.next.next = new ListNode(3)

    val l2 = new ListNode(5)
    l2.next = new ListNode(6)
    l2.next.next = new ListNode(4)

    var result = addTwoNumber(l1, l2)

    while (result != null) {
      print(result.x + " ")
      result = result.next
    }
  }

  def addTwoNumber(l1: ListNode, l2: ListNode): ListNode = {
    val result = new ListNode(0)
    var (a, b, current, tmp) = (l1, l2, result, 0)
    while (a != null || b != null) {
      val x = if (a == null) 0 else a.x
      val y = if (b == null) 0 else b.x
      current.next = new ListNode((x + y + tmp) % 10)
      tmp = (x + y + tmp) / 10
      current = current.next
      a = if (a != null) a.next else null
      b = if (b != null) b.next else null
    }
    if (tmp > 0) {
      current.next = new ListNode(tmp)
    }
    result.next
  }

  class ListNode(var _x: Int = 0) {
    var next: ListNode = null
    var x: Int = _x
  }
}
