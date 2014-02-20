package org.carlspring.strongbox.jaas.ldap;

import org.carlspring.ioc.InjectionException;
import org.carlspring.strongbox.dao.ldap.UsersDao;
import org.carlspring.strongbox.jaas.User;
import org.carlspring.strongbox.jaas.authentication.UserResolutionException;
import org.carlspring.strongbox.jaas.authentication.UserResolver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author mtodorov
 */
@Component
public class LDAPUserRealm
        implements UserResolver
{

    @Autowired
    private UsersDao usersDao;


    @Override
    public User findUser(long userId)
            throws UserResolutionException
    {
        User user = null;
        try
        {
            user = getUsersDao().findUser(userId);
        }
        catch (InjectionException e)
        {
            throw new UserResolutionException(e.getMessage(), e);
        }

        return user;
    }

    @Override
    public User findUser(String username)
            throws UserResolutionException
    {
        User user = null;
        try
        {
            user = getUsersDao().findUser(username);
        }
        catch (InjectionException e)
        {
            throw new UserResolutionException(e.getMessage(), e);
        }

        return user;
    }

    @Override
    public User findUser(String username,
                         String password)
            throws UserResolutionException
    {
        User user = null;
        try
        {
            user = getUsersDao().findUser(username, password);
        }
        catch (InjectionException e)
        {
            throw new UserResolutionException(e.getMessage(), e);
        }

        return user;
    }

    public UsersDao getUsersDao()
            throws InjectionException
    {
        return usersDao;
    }

    public void setUsersDao(UsersDao usersDao)
    {
        this.usersDao = usersDao;
    }

}
