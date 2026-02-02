package gameCharacter
class GameCharacter(
    val name: String
) {
    var state: CharacterState = CharacterState.Inaction

    fun changeState(newState: CharacterState) {
        state = newState
    }
}