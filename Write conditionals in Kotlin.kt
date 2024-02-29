// // 2. Use if/else statements to express conditions
// val number = 1
// fun main() {
//     println(1 == 1) // true
// }
// fun main() {
//     println(1 < 1) // false
// }
// fun main() {
//     val trafficLightColor = "Red"

//     if (trafficLightColor == "Red") {
//         println("Stop") // stop, потому что trafficLightColor = Red
//     } 
// }
// fun main() {
//     //val trafficLightColor = "Red"
// 	val trafficLightColor = "Green"
//     if (trafficLightColor == "Red") {
//         println("Stop") // выведет Stop при Red
//     } else {
//         println("Go") // Выведет go при Green
//     }
// }
// fun main() {
//     val trafficLightColor = "Yellow"

//     if (trafficLightColor == "Red") {
//         println("Stop")
//     } else if (trafficLightColor == "Yellow") {
//         println("Slow") // выведет Slow, потому что trafficLightColor = Yellow
//     } else {
//         println("Go")
//     }
// }
// fun main() {
//     val trafficLightColor = "Black"
// //     val trafficLightColor = "Yellow"
// //     val trafficLightColor = "Green"

//     if (trafficLightColor == "Red") {
//         println("Stop")
//     } else if (trafficLightColor == "Yellow") {
//         println("Slow")
//     } else if (trafficLightColor == "Green") {
//         println("Go")
//     } else {
//         println("Invalid traffic-light color") // при Black
//     }

// }

// // 3. Use a when statement for multiple branches
// fun main() {
//     val trafficLightColor = "Black"
// //     val trafficLightColor = "Yellow"

//     when (trafficLightColor) {
//         "Red" -> println("Stop")
//         "Yellow" -> println("Slow")
//         "Green" -> println("Go")
//         else -> println("Invalid traffic-light color")
//     }
// }
// fun main() {
//     val x = 3

//     when (x) {
//         2 -> println("x is a prime number between 1 and 10.")
//         3 -> println("x is a prime number between 1 and 10.")
//         5 -> println("x is a prime number between 1 and 10.")
//         7 -> println("x is a prime number between 1 and 10.")
//         else -> println("x isn't a prime number between 1 and 10.")
//     }
// }
// fun main() {
//     val x = 3
// //     val x = 5
// //     val x = 7

//     when (x) {
//         2, 3, 5, 7 -> println("x is a prime number between 1 and 10.")
//         else -> println("x isn't a prime number between 1 and 10.")
//     }
// }
// fun main() {
//     val x = 4

//     when (x) {
//         2, 3, 5, 7 -> println("x is a prime number between 1 and 10.")
//         in 1..10 -> println("x is a number between 1 and 10, but not a prime number.")
//         else -> println("x isn't a prime number between 1 and 10.")
//     }
// }
// fun main() {
//     val x: Any = 20

//     when (x) {
//         2, 3, 5, 7 -> println("x is a prime number between 1 and 10.")
//         in 1..10 -> println("x is a number between 1 and 10, but not a prime number.")
//         is Int -> println("x is an integer number, but not between 1 and 10.")
//         else -> println("x isn't an integer number.")
//     }
// }
// fun main() {
//     val trafficLightColor = "Yellow"
//    // val trafficLightColor = "Amber"

//     when (trafficLightColor) {
//         "Red" -> println("Stop")
//         "Yellow", "Amber" -> println("Slow")
//         "Green" -> println("Go")
//         else -> println("Invalid traffic-light color")
//     }
// }



// 4. Use if/else and when as expressions

fun main() {
    val trafficLightColor = "Amber"

    val message = when(trafficLightColor) {
        "Red" -> "Stop"
        "Yellow", "Amber" -> "Slow"
        "Green" -> "Go"
        else -> "Invalid traffic-light color"
    }
    println(message) // выведет Slow
}