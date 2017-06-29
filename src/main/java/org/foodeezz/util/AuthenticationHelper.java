package org.foodeezz.util;

import org.foodeezz.persistance.entity.UserType;
import org.foodeezz.persistance.entity.User;

import javax.servlet.http.HttpSession;

/**
 * Created by bakhtiar.galib on 4/5/15.
 */
public class AuthenticationHelper {

    public static User getAuthenticatedUser(HttpSession httpSession) {
        return (User) httpSession.getAttribute("user");
    }

    public static void setAuthenticatedUser(HttpSession httpSession, User user) {
        httpSession.setAttribute("user", user);
    }

    public static boolean isUserAnonymous(HttpSession httpSession) {
        return getAuthenticatedUser(httpSession) == null;
    }

    public static boolean isUserAuthenticatedButNotAdmin(HttpSession httpSession) {
        return getAuthenticatedUser(httpSession) != null && getAuthenticatedUser(httpSession).getUserType() != UserType.SYSTEM_ADMIN;
    }

    public static boolean isUserAdmin(HttpSession httpSession) {
        return getAuthenticatedUser(httpSession) != null && getAuthenticatedUser(httpSession).getUserType() == UserType.SYSTEM_ADMIN;
    }


}
