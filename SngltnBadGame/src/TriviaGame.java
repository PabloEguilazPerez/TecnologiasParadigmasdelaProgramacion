import java.util.HashMap;
import java.util.Map;

class TriviaGame {
    private int round = 1;
    private final Map<String, Integer> score = new HashMap<>();

    public void answerCorrect(String player) {
        score.put(player, score.getOrDefault(player, 0) + 10);
    }

    public void nextRound() {
        round++;
    }

    public int getRound() { return round; }

    public int getScore(String player) {
        return score.getOrDefault(player, 0);
    }
}

class PlayerService {
	private TriviaGame game;
	
	public PlayerService() {
		game = new TriviaGame();
	}
	
    public void submitCorrectAnswer(String player) {
        game.answerCorrect(player);
    }
}

class AdminService {
	private TriviaGame game;
	
	public AdminService() {
		game = new TriviaGame();
	}	
	
    public void advanceRound() {
        game.nextRound();
    }
}

class ScoreboardService {
	
	private TriviaGame game;
	
	public ScoreboardService() {
		game = new TriviaGame();
	}	
	

    public int scoreOf(String player) {
        return game.getScore(player);
    }

    public int currentRound() {
        return game.getRound();
    }
}
