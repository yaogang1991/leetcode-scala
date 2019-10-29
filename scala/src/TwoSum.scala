object TwoSum {
  def main(args: Array[String]): Unit = {
    val nums = Array(2, 7, 11, 15)
    val target = 9;
    val result = twoSum2(nums, target)
    println(result.toList)
  }

  def twoSum(nums: Array[Int], target: Int): Array[Int] = {
    for (i <- 0 to nums.length -1; j <- i + 1 to nums.length) {
      if (nums(i) + nums(j) == target) {
        return Array[Int](i, j)
      }
    }
    throw new IllegalArgumentException("No Solution")
  }

  def twoSum2(nums: Array[Int], target: Int): Array[Int] = {
    val map = new scala.collection.mutable.HashMap[Int,Int];
    for { i <- Range(0, nums.length)
          tmp = target - nums(i) } {
      if (map.contains(tmp)) {
        return Array[Int](map.get(tmp).get, i)
      }
      map += (nums(i) -> i)
    }
    throw new IllegalArgumentException("No Solution")
  }
}
