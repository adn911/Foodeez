package org.foodeezz.security.interceptor;

import org.foodeezz.util.AuthenticationHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by bakhtiar.galib on 4/5/15.
 */
public class HttpAuthenticationInterceptor extends HandlerInterceptorAdapter {

    private static final Logger log = LoggerFactory.getLogger(HttpAuthenticationInterceptor.class);

    private static List<String> adminPages = new ArrayList<String>();

    private static List<String> authenticatedUserPages = new ArrayList<String>();

    private static List<String> anonymousUserPages = new ArrayList<String>();

    static
    {
        adminPages.add("restaurants/add");
        adminPages.add("restaurants/remove");
        adminPages.add("restaurants/update");
        adminPages.add("menuItems/add");
        adminPages.add("menuItems/remove");
        adminPages.add("menuItems/update");

        authenticatedUserPages.add("menuItemReviews/add");
        authenticatedUserPages.add("menuItemReviews/remove");

        authenticatedUserPages.add("restaurantReviews/add");
        authenticatedUserPages.add("restaurantReviews/remove");

        anonymousUserPages.add("login");
        anonymousUserPages.add("signup");
    }


    public boolean isRequestedPageForAdminUserOnly(String requestedUri) {

        for(String adminPage:adminPages){
            if(requestedUri.contains(adminPage))
                return true;
        }
        return false;
    }

    public boolean isRequestedPageForAuthenticatedUserOnly(String requestedUri) {

        for(String page: authenticatedUserPages){
            if(requestedUri.contains(page))
                return true;
        }
        return false;
    }

    public boolean isRequestedPageForAnonymousUserOnly(String requestedUri) {

        for(String page:anonymousUserPages){
            if(requestedUri.contains(page))
                return true;
        }
        return false;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String requestedUri = request.getRequestURI().substring(request.getContextPath().length());

        log.debug("At Interceptor ");

        log.debug("Requested URL " + requestedUri);

        if ( AuthenticationHelper.isUserAnonymous(request.getSession())
                && ( isRequestedPageForAuthenticatedUserOnly(requestedUri)
                || isRequestedPageForAdminUserOnly(requestedUri))) {
            response.sendRedirect("/Foodeezz/login");

            return false;
        } else if ( AuthenticationHelper.isUserAuthenticatedButNotAdmin(request.getSession())
                && (isRequestedPageForAdminUserOnly(requestedUri)
                || isRequestedPageForAnonymousUserOnly(requestedUri))) {
            response.sendRedirect("/Foodeezz/");

            return false;

        } else if ( AuthenticationHelper.isUserAdmin(request.getSession())
                && isRequestedPageForAnonymousUserOnly(requestedUri)){
            response.sendRedirect("/Foodeezz/");

            return false;
        }

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
