public class Game {

    public static String decideWinner(String move1, String move2) {
        if (move1.equals(move2)) {
            return "Empate!";
        }

        switch (move1) {
            case "PEDRA":
                return move2.equals("TESOURA") ? "Jogador 1 vence!" : "Jogador 2 vence!";
            case "PAPEL":
                return move2.equals("PEDRA") ? "Jogador 1 vence!" : "Jogador 2 vence!";
            case "TESOURA":
                return move2.equals("PAPEL") ? "Jogador 1 vence!" : "Jogador 2 vence!";
            default:
                return "Jogada inválida!";
        }
    }
}
