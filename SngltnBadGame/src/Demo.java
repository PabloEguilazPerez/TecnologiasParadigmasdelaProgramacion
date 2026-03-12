public class Demo {

    public static void main(String[] args) {

    	
    	
        AdminService admin = new AdminService();
        PlayerService player = new PlayerService();
        ScoreboardService scoreboard = new ScoreboardService();

        System.out.println("=== TRIVIA GAME DEMO ===");
        System.out.println("EXPECTED (shared game state):");
        System.out.println(" - Round after admin advances: 2");
        System.out.println(" - Score of Ana after correct answer: 10");
        System.out.println();

        System.out.println("ACTUAL:");
        admin.advanceRound();
        player.submitCorrectAnswer("Ana");

        System.out.println(" - Current round: " + scoreboard.currentRound());
        System.out.println(" - Score of Ana: " + scoreboard.scoreOf("Ana"));

        System.out.println();
        System.out.println("INTERPRETATION:");
        System.out.println("If round=2 and score=10 → shared instance (correct design).");
        System.out.println("If round=1 and score=0  → multiple instances (design error).");
    }
}

