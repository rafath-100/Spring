package coach;

public class BaseballCoach implements Coach{
    //define a private field for the dependency
    private FortuneService fortuneService;

    BaseballCoach(){

    }

    //define a constructor for dependency injection
    BaseballCoach(FortuneService fortuneService)
    {
        this.fortuneService = fortuneService;

    }

    @Override
    public String getDailyWorkout(){
        return "Spend 10 minutes on base ball training!";
    }

    @Override
    public String getDailyFortune() {

        //use my fortuneService to get a fortune
        return this.fortuneService.getFortune();
    }
}
