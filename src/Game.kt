import java.util.*

fun main () {
    val options = arrayOf("Rock", "Paper", "Scissors")
    val gameChoice = getGameChoice(options)
    val userChoice = getUserChoice(options)
    printResult(userChoice, gameChoice)
}

fun getGameChoice(optionsParams: Array<String>): String {
    return optionsParams[(optionsParams.size * Math.random()).toInt()]
}

fun getUserChoice(optionsParams: Array<String>): String {
    var isValidChoice = false
    var userChoice = ""
    while(!isValidChoice) {
        println("Please enter one of the following:")
        for (item in optionsParams)
            print(" $item")
        println(".")
        var userInput = readlnOrNull()
        userInput = userInput?.replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString() }
        if (userInput != null && userInput in optionsParams) {
            isValidChoice = true
            userChoice = userInput
        }
        if (!isValidChoice) println("You must enter a valid choice")
    }
    return userChoice
}

fun printResult(userChoice: String, gameChoice: String) {
    val result: String = if (userChoice == gameChoice) "Tie!"
    else if ((userChoice == "Rock") && (gameChoice == "Scissors") ||
        (userChoice == "Paper") && (gameChoice == "Rock") ||
        (userChoice == "Scissors") && (gameChoice == "Paper")) "User wins!"
    else "You lose!"
    println("You chose $userChoice. I chose $gameChoice. $result")
}