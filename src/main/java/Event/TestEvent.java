package Event;

import org.springframework.context.ApplicationEvent;

public class TestEvent extends ApplicationEvent {
	private static final long serialVersionUID = 1L;

	private String message;

	public TestEvent(Object source, String message) {
		super(source);
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
