package annotations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("play")
@Scope("prototype")
public class TennisCoach implements Coach{

    //3rd INJECTION- FIELD
    @Autowired
    @Qualifier("randomFortuneService")
    private FortuneService fortuneService;

    //1st INJECTION- CONSTRUCTOR
//    @Autowired
//    public TennisCoach(FortuneService theFortuneService){
//        fortuneService = theFortuneService;
//    }

    //2nd INJECTION- SETTER
    //default constructor
    public TennisCoach(){
        System.out.println(">> TennisCoach: inside default constructor");
    }

    //define my init method
    public void init(){
        System.out.println(">> TennisCoach: inside of init()");
    }






    //define a setter method
//    @Autowired
//    public void setFortuneService(FortuneService theFortuneService){
//        System.out.println(">> TennisCoach: inside setFortuneService() method");
//        fortuneService = theFortuneService;
//    }


    @Override
    public String getDailyWorkout() {
        return "Play a tennis match with your friend!";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }
}
