package annotations;

import org.springframework.stereotype.Component;

import java.util.Random;

//used to setup auto scanning
@Component
public class RandomFortuneService implements FortuneService{

    //create an array of strings
    private String[] data = {
            "My name is Rafath Ali",
            "I play for Sunrisers Hyderabad",
            "Every year I participate in the IPL"
    };

    //create a random generator
    private Random myRandom = new Random();

    @Override
    public String getFortune() {
        //pick a random string from the array
        int index = myRandom.nextInt(data.length);

        String theFortune = data[index];

        return theFortune;
    }
}
