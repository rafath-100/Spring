package coach;

public class CricketCoach implements Coach{
    private FortuneService fortuneService;

    //no-arg constructor
    CricketCoach(){
        System.out.println("CricketCoach: inside no-arg constructor!");
    }

    //add new fields
    private String captain;
    private String team;

    //captain
    public String getCaptain(){
        return captain;
    }
    public  void setEmail(String captain){
        System.out.println("Cricketcoach: inside setter method - setCaptain");
        this.captain=captain;
    }

    //team
    public String getTeam(){
        return team;
    }

    public void setTeam(String team){
        System.out.println("Cricketcoach: inside setter method - setTeam");
        this.team=team;
    }


    //our setter method
    public void setFortuneService(FortuneService fortuneService) {
        System.out.println("Cricketcoach: inside setter method - setFortuneService");
        this.fortuneService = fortuneService;
    }

    @Override
    public String getDailyWorkout() {
        return "practice knocking for 10 minutes";
    }

    @Override
    public String getDailyFortune() {
        return this.fortuneService.getFortune();
    }
}
