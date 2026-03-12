import java.util.HashMap;
import java.util.Map;

class TriviaGame {
	
    private int round;
    
    private final Map<String, Integer> score;
	
	// Singleton
	private static TriviaGame instance;
	
	private TriviaGame() {
		round = 1;
		score = new HashMap<>();
	}
	
	public static TriviaGame getInstance() {
		if (instance == null) {
			instance = new TriviaGame();
		} 
		return instance;
	}	
	// Fin

    public void answerCorrect(String player) {
        score.put(player, score.getOrDefault(player, 0) + 10);
    }

    public void nextRound() {
        round++;
    }

    public int getRound() { 
    	return round; 
    }

    public int getScore(String player) {
        return score.getOrDefault(player, 0);
    }
}

class PlayerService {
	
	//private TriviaGame game;
	
	public PlayerService() {
		//game = TriviaGame.getInstance();
	}
	
    public void submitCorrectAnswer(String player) {
    	TriviaGame.getInstance().answerCorrect(player);
    }
}

class AdminService {
	
	private TriviaGame game;
	
	public AdminService() {
		game = TriviaGame.getInstance();
	}	
	
    public void advanceRound() {
        game.nextRound();
    }
}

class ScoreboardService {
	
	private TriviaGame game;
	
	public ScoreboardService() {
		game = TriviaGame.getInstance();
	}	
	

    public int scoreOf(String player) {
        return game.getScore(player);
    }

    public int currentRound() {
        return game.getRound();
    }
}
