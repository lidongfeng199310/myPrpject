package Event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class EventPbulish {
	
	@Autowired
	ApplicationContext context;

	public void publish(String message) {
		context.publishEvent(new TestEvent(this, message));
	}
}