object LengthOfLongestSubstring {

  def main(args: Array[String]): Unit = {
    val s = "aabaab!bb"
    println(lengthOfLongestSubstring(s))
  }

  def lengthOfLongestSubstring(s: String): Int = {
    var list = List[Char]()
    var (max, len) = (0, 0)
    for (i <- s) {
      if (!list.contains(i)) {
        list = list :+ i
      } else {
        len = list.size
        max = if (len > max ) len else max
        list = list.drop(list.lastIndexOf(i) + 1) :+ i
      }
    }
    return if (list.size > max) list.size else max
  }

}
