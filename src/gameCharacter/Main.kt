// Файл: Main.kt
package gameCharacter

fun main() {
    val mage = GameCharacter("Мерлин")
    println("Маг ${mage.name} уже идет...")
    mage.changeState(CharacterState.Inaction)
    handleState(mage.state)
    mage.changeState(CharacterState.Running)
    handleState(mage.state)
    mage.changeState(CharacterState.Attack(damage = 75))
    handleState(mage.state)
    mage.changeState(CharacterState.Attack(damage = 120))
    handleState(mage.state)
    println("\nЭто были все заклинания Мерлина!")
}
fun handleState(state: CharacterState) {
    when (state) {
        CharacterState.Inaction -> {
            println("Мерлин погружается в медитацию...")
            println("Восстанавливает ману и готовит заклинания\n")
        }
        CharacterState.Running -> {
            println("Мерлин исчезает в густом тумане")
            println("И появляется в другом месте\n")
        }
        is CharacterState.Attack -> {
            println("Мерлин кастует древнее заклинание!")
            when {
                state.damage < 50 -> {
                    println("Лёгкое заклинание: ${state.damage} ед. силы")
                    println("Вспышка света пронзает всю комнату\n")
                }
                state.damage < 100 -> {
                    println("Сильное заклинание: ${state.damage} ед. силы")
                    println("Стены начинают трястись от такой магической энергии!\n")
                }
                else -> {
                    println("Супер-дупер-легендарное заклинание: ${state.damage} ед. силы")
                    println("Вся вселенная схлопывается и стирается в порошок!\n")
                }
            }
        }
        is CharacterState.Death -> {
            println("Мерлин с унижением падает на колени...")
            println("Причина поражения: ${state.reason}")
            println("Магический свет угасает в его глазах, и он проваливается в темноту\n")
        }
    }
}