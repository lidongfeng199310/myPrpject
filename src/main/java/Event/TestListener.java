package Event;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class TestListener implements ApplicationListener<TestEvent> {

	@Value("${name1}")
	String name;
	
	@Override
	public void onApplicationEvent(TestEvent event) {
		if (event.getMessage().equals(name)) {
            System.out.println("you need to find " + event.getMessage() + ",yes, I'am " + name);
        } else {
            System.out
                .println("you need to find " + event.getMessage() + ",but I'am not " + event.getMessage() + ",I'am " + name);
        }
	}

}
