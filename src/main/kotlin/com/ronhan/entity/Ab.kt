package com.ronhan.entity

private var aaaa : Int = 1
var bbbb : Int = 2

class Ab {
  private var oo: String = ""
    get() = "oo:$field"
    set(value) {
      field = value?.toUpperCase()
    }

  lateinit var c: String

  fun showOO() {
    println(aa(1, 3))
    println(oo)

    c = """
        who is that
        i'm kotlin
         """
    println(c)
  }

  var aa = fun(left: Int, right: Int): Int? {
    return left + right
  }
}

fun main(args: Array<String>) {
  /*println("hello")
  ok()
  var a = Ab()
  a.showOO()
  a.showO()*/

  //oo(3, { println(2)}, {b -> println(b); b})
  //o98k()

  var arr = arrayOf(1,33,5,71,37,90,13,55,20,31)

  println(arr.contentDeepToString())
  quick_sort(arr, 0, arr.size - 1)

  println(arr.contentDeepToString())
}

fun ok() {
  println("ok")
}

fun Ab.showO(): String {
  return "showO"
}

fun oo(num: Int, a: () -> Unit, b: (i2: Int) -> Int) {
  a.invoke()
  b.invoke(num)
  run {  }

}

var abc = {a: Int, b: String, c: Long -> ""+a+b+c; print("$a, $b, $c")}

var abcE: (Int, String, Long) -> Unit = { a, b, c -> print("$a, $b, $c")}

fun o98k() {
  IntArray(10) { it*it }.forEach(::println)

  html {
    body()
  }
}


class HTML {
  fun body() { println("body") }
}

fun html(init: HTML.() -> Unit): HTML {
  val html = HTML()  // 创建接收者对象
  html.init()        // 将该接收者对象传给该 lambda
  return html
}

fun swap(arr: Array<Int>, first: Int, second: Int) {
  var temp: Int = arr[first]
  arr[first] = arr[second]
  arr[second] = temp
}

fun partion(arr: Array<Int>, low: Int, high: Int): Int {
  var pivot: Int = arr[high]
  var i: Int = low - 1
  var j: Int = low

  while ( j < high) {
    if (arr[j] <= pivot) {
      i++
      swap(arr, i, j)
    }
    j++
  }
  swap(arr, i + 1, high)
  return i + 1
}

fun quick_sort(arr: Array<Int>, low: Int, high: Int) {
  if (low < high) {
    var index = partion(arr, low, high)
    quick_sort(arr, low, index - 1)
    quick_sort(arr, index + 1, high)
  }
}
