package Event;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestMain {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(TestConfig.class);
		EventPbulish eventPbulish = context.getBean(EventPbulish.class);
		eventPbulish.publish("zhangsan");
		context.close();
	}
}