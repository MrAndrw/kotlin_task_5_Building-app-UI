// // 2. Use nullable variables
// fun main() {
//     var number: Int? = 10
//     println(number) // 10
//     number = null
//     println(number) // null
// }
// // 3. Handle nullable variables
// fun main() {
//     var favoriteActor: String = "Sandra Oh"
//     println(favoriteActor.length) // 9
// }

// fun main() {
//     //var favoriteActor: String? = "Sandra Oh"
//     var favoriteActor: String? = null
//     println(favoriteActor?.length)
// }
// fun main() {
//     //var favoriteActor: String? = "Sandra Oh"
//     var favoriteActor: String? = null
//     println(favoriteActor!!.length) // ошибка при null
// }
// fun main() {
//     var favoriteActor: String? = null
//     //var favoriteActor: String? = "Sandra Oh"
//     if(favoriteActor != null) {
//       println("The number of characters in your favorite actor's name is ${favoriteActor.length}.")
//     } else {
//       println("You didn't input a name.")
//     }
// }
// fun main() {
//     var favoriteActor: String? = "Sandra Oh"
//     val lengthOfName = if (favoriteActor != null) {
//       favoriteActor.length
//     } else {
//       0
//     }
//     println("The number of characters in your favorite actor's name is $lengthOfName.")
// }
fun main() {
    var favoriteActor: String? = "Sandra Oh"
    val lengthOfName = favoriteActor?.length ?: 0
    println("The number of characters in your favorite actor's name is $lengthOfName.") // 9
}
