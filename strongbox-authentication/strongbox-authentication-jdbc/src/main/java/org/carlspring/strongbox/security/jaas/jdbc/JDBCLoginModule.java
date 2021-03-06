package org.carlspring.strongbox.security.jaas.jdbc;

import org.carlspring.strongbox.security.jaas.authentication.BaseLoginModule;
import org.carlspring.strongbox.security.jaas.authentication.UserResolver;
import org.carlspring.strongbox.security.encryption.EncryptionUtils;

import javax.security.auth.Subject;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.login.LoginException;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * <p> This LoginModule authenticates users with a password against a database.
 * <p/>
 * <p> If user is successfully authenticated,
 * a <code>UserPrincipal</code> with the user's user name
 * is added to the Subject.
 * <p/>
 * <p> This LoginModule recognizes the debug option.
 * If set to true in the login Configuration,
 * debug messages will be output to the output stream, System.out.
 */
@Component
public class JDBCLoginModule
        extends BaseLoginModule
{

    private static Logger logger = LoggerFactory.getLogger(JDBCLoginModule.class);

    @Autowired
    private UserResolver userResolver;


    /**
     * Initialize this <code>LoginModule</code>.
     * <p/>
     * <p/>
     *
     * @param subject         the <code>Subject</code> to be authenticated. <p>
     * @param callbackHandler a <code>CallbackHandler</code> for communicating
     *                        with the end user (prompting for user names and
     *                        passwords, for example). <p>
     * @param sharedState     shared <code>LoginModule</code> state. <p>
     * @param options         options specified in the login
     *                        <code>Configuration</code> for this particular
     *                        <code>LoginModule</code>.
     */
    @Override
    public void initialize(Subject subject,
                           CallbackHandler callbackHandler,
                           Map<String, ?> sharedState,
                           Map<String, ?> options)
    {
        super.initialize(subject, callbackHandler, sharedState, options);

        userResolver = (UserResolver) getApplicationContext().getBean("userResolver");

        logger.debug("JDBCLoginModule initialized!");
    }

    public void checkUserCredentials(String username, String password)
            throws LoginException
    {
        try
        {
            final String encryptedPassword = EncryptionUtils.encryptWithMD5(getCredentials().getPassword());
            logger.debug("Checking authentication for: " + getPrincipal().getName() + " / " + encryptedPassword + "...");

            setUser(getUserAuthenticator().authenticate(username, encryptedPassword, userResolver));
        }
        catch (Exception e)
        {
            throw new LoginException(e.getMessage());
        }
    }

}
