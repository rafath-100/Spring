package coach;

import org.springframework.context.support.ClassPathXmlApplicationContext;

//example on setter injection
public class SetterDemoApp {
    public static void main(String[] args) {

        //load the spring config file
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        //retrieve bean from spring container
        CricketCoach theCoach = context.getBean("myCricketCoach",CricketCoach.class);

        //call methods on the bean
        System.out.println(theCoach.getDailyWorkout());

        System.out.println(theCoach.getDailyFortune());

        //call to our new methods to get literal values

        System.out.println("Favourite Player: "+theCoach.getCaptain());
        System.out.println("Favourite Team: "+theCoach.getTeam());
        //close the context
        context.close();
    }
}
