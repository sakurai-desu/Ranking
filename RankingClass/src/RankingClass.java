public class RankingClass {
    public static void main(String[] args) {
        Ranking ranking = new Ranking();
        ranking.EntryScore(300, "name300");
        ranking.EntryScore(100, "name100");
        ranking.EntryScore(400, "name400");
        ranking.EntryScore(200, "name200");
        ranking.printRanking();
    }
}
