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
		
		//l'url demandée est elle dans la liste d'urls à ignorer ?
		for (String urlIgnoree : ignoreList) {
			//l'url cherchée correspond à une url à ignorer
			if(requestedUrl.contains(urlIgnoree)) {
				urlAIgnorer = true;
				break;
			}
		}
		
		//si ce n'est pas une url à ignorer(typiquement : /login)
		if(!urlAIgnorer) {
			Object user = request.getSession().getAttribute("user");
			
			//on n'a pas de user dans la session, donc l'user n'est pas identifié
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