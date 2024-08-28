package tw.hightwo.tags;

import java.io.IOException;

import jakarta.servlet.jsp.JspContext;
import jakarta.servlet.jsp.JspException;
import jakarta.servlet.jsp.JspWriter;
import jakarta.servlet.jsp.tagext.JspFragment;
import jakarta.servlet.jsp.tagext.SimpleTagSupport;

public class HelloTag extends SimpleTagSupport{
	private String name;

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public void doTag() throws JspException, IOException {
		JspContext jsp = getJspContext();
		JspWriter out = jsp.getOut();
		
		if(name != null) {
			out.print(String.format("Hello %s", name));
		}
		else {
			out.print(String.format("Hello %s", "World"));
		}
		
		JspFragment body = getJspBody();
		if(body != null) {
			out.print("I am body");
			body.invoke(out);
		}
	}
	
}
