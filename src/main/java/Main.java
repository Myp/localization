import conf.Application;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import service.HelloService;

public class Main {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(Application.class);

        HelloService service  = ctx.getBean(HelloService.class);

        System.out.println(service.sayGreeting());

        System.out.println(service.sayHi("Tommy"));
    }
}
