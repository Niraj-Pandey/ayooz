package ayooz.ngbeans.helloworld;

import javax.enterprise.context.RequestScoped;

import angularBeans.api.AngularBean;
import angularBeans.api.http.Get;

@AngularBean
@RequestScoped
public class HelloBean {
	
	@Get
	public String getMessage(String name) {
		return "Hello " + name;
	}
}
