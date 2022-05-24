package coach;

public class MyApp {
    public static void main(String[] args)
    {
//            Coach theCoach = new BaseballCoach();
//            System.out.println(theCoach.getDailyWorkout());

            Coach theCoach = new BaseballCoach();
            System.out.println(theCoach.getDailyWorkout());

            theCoach = new FootballCoach();
            System.out.println(theCoach.getDailyWorkout());

    }
}
