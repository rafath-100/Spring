package annotations;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationBeanScopeDemoApp {
    public static void main(String[] args) {

        //load spring config file
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        //retrieve bean from spring container
        Coach theCoach = context.getBean("playTennis",Coach.class);

        Coach alphaCoach = context.getBean("playTennis",Coach.class);

        //check if they are the same
        boolean result = (theCoach == alphaCoach);

        //print the result
        System.out.println("\n Pointing to the same object: "+result);

        System.out.println("\n Memory location for theCoach "+theCoach);

        System.out.println("\n Memory location for alphaCoach "+alphaCoach);

        //close the context
        context.close();
    }
}
