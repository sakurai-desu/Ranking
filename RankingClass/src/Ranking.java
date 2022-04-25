import java.util.ArrayList;
import java.util.List;

public class Ranking {

    private final int TOP_RANK = 1;
    private final String RANKING_MESSAGE = "%d位:%d,%s\n";
    private List<Integer> scores = new ArrayList<>();
    private List<String> names = new ArrayList<>();

    public void EntryScore(int score, String name) {
        int scoreRank = 0;
        scoresManager(scores, score, scoreRank, name);
    }

    private void scoresManager(List<Integer> scoreList, int newScore, int scoreRank, String name) {
        if (isFirstPerson(scoreList)) {
            addList(newScore, name);
            return;
        }
        if (!isExitsLargerNewScore(scoreList, newScore)) {
            addList(newScore, name);
            return;
        }
        addList(returnRank(scoreList, newScore, scoreRank), newScore, name);
    }

    private int returnRank(List<Integer> currentScoreList, int newScore, int scoreRank) {
        scoreRank = 0;
        for (int score : currentScoreList) {
            if (isLargeNewScore(score, newScore)) {
                return scoreRank;
            }
            scoreRank++;
        }
        return scoreRank;
    }

    private boolean isFirstPerson(List<Integer> ScoreList) {
        return ScoreList.size() == 0;
    }

    private void addList(int loopCount, int newScore, String name) {
        this.scores.add(loopCount, newScore);
        this.names.add(loopCount, name);
    }

    private void addList(int Score, String name) {
        this.scores.add(Score);
        this.names.add(name);
    }

    private boolean isExitsLargerNewScore(List<Integer> currentScoreList, int newScore) {
        for (int Score : currentScoreList) {
            if (isLargeNewScore(Score, newScore)) {
                return true;
            }
        }
        return false;
    }

    private boolean isLargeNewScore(int Score, int newScore) {
        return Score < newScore;
    }

    public void printRanking() {
        int rankCount = TOP_RANK;
        for (int i = 0; i < this.scores.size(); i++) {
            System.out.printf(RANKING_MESSAGE, rankCount, scores.get(i), names.get(i));
            rankCount++;
        }
    }
}