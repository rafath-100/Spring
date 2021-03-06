package annotations;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SwimJavaConfigDemoApp {
    public static void main(String[] args) {
        //read spring config java class
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SportConfig.class);

        //get the bean from spring container
        SwimCoach theCoach  = context.getBean("swimCoach",SwimCoach.class);
        //we can use default bean ID as "tennnisCoach"

        //call a method on the bean
        System.out.println(theCoach.getDailyWorkout());


        //call method to get the daily fortune
        System.out.println(theCoach.getDailyFortune());

        //calling new methods
        System.out.println("captain: "+theCoach.getCaptain());
        System.out.println("team: "+theCoach.getTeam());

        //close the context
        context.close();
    }
}
