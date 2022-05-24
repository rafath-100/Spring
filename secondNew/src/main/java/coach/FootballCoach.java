package coach;

public class FootballCoach implements Coach {
    private FortuneService fortuneService;
    FootballCoach(){

    }
    FootballCoach(FortuneService fortuneService){
        this.fortuneService=fortuneService;
    }

    @Override
    public String getDailyWorkout(){
    return "Spend 10 minutes in Football training!";
    }

    @Override
    public String getDailyFortune() {
        return "Just Do It!"+ this.fortuneService.getFortune();
    }

    //add an init method
    public void init(){
        System.out.println("You are in init method!");
    }

    //add a destory method
    public void destroy(){
        System.out.println("You are in destroy method!");
    }
}
