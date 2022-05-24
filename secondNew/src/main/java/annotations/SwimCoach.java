package annotations;

import org.springframework.beans.factory.annotation.Value;

public class SwimCoach implements Coach{

    private FortuneService fortuneService;

    @Value("${foo.captain}")
    private String captain;

    @Value("${foo.team}")
    private String team;

    public SwimCoach(FortuneService theFortuneService){
        this.fortuneService = theFortuneService;
    }
    @Override
    public String getDailyWorkout() {
        return "swim 200 meters as a warm up.";
    }

    @Override
    public String getDailyFortune() {
        return this.fortuneService.getFortune();
    }

    public String getCaptain(){
        return "Virat Kohli";
    }

    public String getTeam(){
        return "RCB";
    }
}
