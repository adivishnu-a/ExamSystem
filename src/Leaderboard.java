import java.io.*;

public class Leaderboard {
    public static void showBoard() throws IOException {
        Datasource d = new Datasource();
        d.readFile();
        for (int i = 0; i < d.users.size(); i++) {
            for (int j = 1; j < (d.users.size() - i); j++) {
                if (d.users.get(j - 1).medals < d.users.get(j).medals) {
                    //swap elements
                    Student temp = d.users.get(j - 1);
                    d.users.set(j - 1, d.users.get(j));
                    d.users.set(j, temp);
                }
            }
        }
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("----------LEADERBOARD----------");
        System.out.println(" "+"Rank\tUsername\tMedals");
        System.out.println("-------------------------------");
        int rank=0;
        for(Student stu : d.users){
            rank++;
            System.out.println(" "+rank+"\t"+stu.name+"\t"+stu.medals);
        }
    }
}