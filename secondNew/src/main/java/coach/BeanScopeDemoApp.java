package coach;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanScopeDemoApp {
    public static void main(String[] args) {

        //load spring config file
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beanScope-applicationContext.xml");

        //retrieve bean from spring container
        Coach theCoach = context.getBean("myCoach",Coach.class);

        Coach alphaCoach = context.getBean("myCoach",Coach.class);

        //check if they are same
        boolean result = (theCoach == alphaCoach);

        System.out.println("\n Pointing to the same object "+result);

        System.out.println("\n Memory location for theCoach "+theCoach);

        System.out.println("\n Memory location for alphaCoach "+alphaCoach +"\n");

        //close the context
        context.close();
    }
}
