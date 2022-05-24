package coach;

public class HappyFortuneService implements FortuneService{
    @Override
    public String getFortune(){
        return "You are in Happy fortune Service, and today is your lucky day!";
    }
}
