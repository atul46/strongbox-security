package org.carlspring.strongbox.dao.xml;

import org.carlspring.strongbox.security.jaas.Role;
import org.carlspring.strongbox.security.jaas.User;
import org.carlspring.strongbox.security.jaas.authentication.UserResolutionException;
import org.carlspring.strongbox.security.jaas.authentication.UserResolver;
import org.carlspring.strongbox.security.jaas.authentication.UserStorage;
import org.carlspring.strongbox.security.jaas.authentication.UserStorageException;

/**
 * @author mtodorov
 */
public interface UsersDao extends UserResolver, UserStorage
{

    void createUser(User user)
            throws UserStorageException;

    void updateUser(User user)
            throws UserStorageException;

    void removeUser(User user)
            throws UserStorageException;

    void removeUser(String username)
            throws UserStorageException;

    void assignRole(User user, Role role)
            throws UserStorageException;

    void assignRole(User user, String roleName)
            throws UserStorageException;

    void removeRole(User user, Role role)
            throws UserStorageException;

    void removeRole(User user, String roleName)
            throws UserStorageException;

    boolean contains(String username)
            throws UserResolutionException;

}
