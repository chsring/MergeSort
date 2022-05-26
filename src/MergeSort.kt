import kotlin.jvm.JvmStatic

/**
 * Description: 二路归并 kotlin实现
 * Created 苏饶
 * Date: 2022/5/26
 * Email: surao@foryou56.com
 */
object MergeSort {
    @JvmStatic
    fun main(args: Array<String>) {
        val array = intArrayOf(1, 8, 6, 7, 2, 4, 11, 17, 6, 48, 3)
        //int [] array ={9,8,7,6,5,4,3,2,1};
        val temp = IntArray(array.size)
        sort(array, temp, 0, array.size - 1)
        println("排序后：")
        for (i in array.indices) {
            print(array[i].toString() + " ")
        }
    }

    /**
     * 总的sort循环。先将问题一分为二，再将问题解决后的两个子问题结果合并
     * 要想清楚 子数组 边界的处理。
     * 如子数组为 下标为(k,k + 1):则再分解为(K),(K+1)。
     * 如子数组下标为(k,k+1,k+2)：则分解为(k,k+1)和(k+2)。再递归调用分解(k,k+1)
     * @param array
     * @param temp
     * @param start
     * @param end
     */
    fun sort(array: IntArray, temp: IntArray, start: Int, end: Int) {
        if (start < end) {
            val mid = (start + end) / 2
            //解决左边子问题
            sort(array, temp, start, mid)
            //解决右边子问题
            sort(array, temp, mid + 1, end)
            //合并两个子问题
            merge(array, temp, start, end, mid)
        }
    }

    /**
     * 归并函数
     * @param array 原始数组
     * @param temp 辅助数组
     * @param start 归并开始坐标
     * @param end 归并结束坐标
     * @param mid = (start + end)/2
     */
    fun merge(array: IntArray, temp: IntArray, start: Int, end: Int, mid: Int) {
        // TODO Auto-generated method stub
        //i：左子问题的操作下标； j：右子问题的操作下标
        var i = start
        var j = mid + 1
        var k = start
        while (i <= mid && j <= end) {
            if (array[i] < array[j]) {
                temp[k] = array[i]
                k++
                i++
            } else {
                temp[k] = array[j]
                k++
                j++
            }
        }
        //左子数组还有元素
        while (i <= mid) {
            temp[k] = array[i]
            k++
            i++
        }
        //右子数字还是元素
        while (j <= end) {
            temp[k] = array[j]
            k++
            j++
        }

        //将辅助数组中排好序的元素复制到原数组
        //注意：辅助数组与原数组一一对应
        for (index in start..end) {
            array[index] = temp[index]
            println("temp[" + index + "]" + "....." + temp[index])
        }
        println("--------------执行结果----------------")
    }
}