package Event;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class TestListener2 implements ApplicationListener<TestEvent> {

	@Override
	public void onApplicationEvent(TestEvent event) {
		System.out.println("test2:" + event.getMessage());
	}

}
