package me.dvsgn

fun main() {
    statefulExample()
}

fun statefulExample() {
    class BankAccount {
        var balance = 0.0
            private set

        inner class InsufficientFunds: Exception()

        fun deposit(depositAmount: Double) {
            balance += depositAmount
        }

        @Throws(InsufficientFunds::class)
        fun withdraw(withdrawAmount: Double) {
            if (balance < withdrawAmount) {
                throw InsufficientFunds()
            }
            balance -= withdrawAmount
        }
    }

    val account = BankAccount()

    println(account.balance) // 0.0
    account.deposit(100.0)
    println(account.balance) // 100.0
    account.withdraw(50.0)
    println(account.balance) // 50.0
    account.withdraw(60.0)
}
