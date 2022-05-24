package annotations;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;

public class JavaConfigDemoApp {
    public static void main(String[] args) {
        //read spring config java class
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SportConfig.class);

        //get the bean from spring container
        Coach theCoach  = context.getBean("play",Coach.class);
        //we can use default bean ID as "tennnisCoach"

        //call a method on the bean
        System.out.println(theCoach.getDailyWorkout());


        //call method to get the daily fortune
        System.out.println(theCoach.getDailyFortune());

        //close the context
        context.close();
    }
}
