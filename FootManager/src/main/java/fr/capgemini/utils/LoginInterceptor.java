package fr.capgemini.utils;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginInterceptor extends HandlerInterceptorAdapter {
	
	private List<String> ignoreList;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		String requestedUrl = request.getRequestURI();
		boolean urlAIgnorer = false;
		
		//l'url demand�e est elle dans la liste d'urls � ignorer ?
		for (String urlIgnoree : ignoreList) {
			//l'url cherch�e correspond � une url � ignorer
			if(requestedUrl.contains(urlIgnoree)) {
				urlAIgnorer = true;
				break;
			}
		}
		
		//si ce n'est pas une url � ignorer(typiquement : /login)
		System.out.println("loginInterceptor : " + urlAIgnorer);
		if(!urlAIgnorer) {
			Object user = request.getSession().getAttribute("user");
			System.out.println("User : " + user);
			//on n'a pas de user dans la session, donc l'user n'est pas identifie
			if(user == null) {
				//on redirigie vers le controller login
				request.getRequestDispatcher("/login").forward(request, response);		
			}
		}
		
		return true;
	}

	public List<String> getIgnoreList() {
		return ignoreList;
	}

	public void setIgnoreList(List<String> ignoreList) {
		this.ignoreList = ignoreList;
	}
}