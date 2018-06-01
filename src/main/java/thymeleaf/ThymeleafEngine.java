package thymeleaf;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.StringTemplateResolver;

public class ThymeleafEngine {
	
	private String model;
	
	private TemplateEngine templateEngine;
	
	public String process(String template,Context context){
		return process(template, context, TemplateMode.HTML.name());
	}
	
	public String process(String template,Context context,String model){
		this.model = model;
		buildTemplateEngine();
		return templateEngine.process(template, context);
	}
	
	public void buildTemplateEngine(){
		if(templateEngine == null){
			templateEngine = new TemplateEngine();
			templateEngine.setTemplateResolver(buildResolvere());
		}
	}
	
	public StringTemplateResolver  buildResolvere(){
		StringTemplateResolver resolver = new StringTemplateResolver();
		resolver.setTemplateMode(model);
		resolver.setCacheable(Boolean.FALSE);
		return resolver;
	}

}
