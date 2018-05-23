package Event;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class TestListener1 implements ApplicationListener<TestEvent> {

	@Override
	public void onApplicationEvent(TestEvent event) {
		System.out.println("test1:" + event.getMessage());
	}

}
