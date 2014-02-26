package org.carlspring.strongbox.dao.rdbms;

import org.carlspring.strongbox.security.jaas.authentication.UserResolutionException;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author mtodorov
 */
public interface BaseDBDao
{

    String getTableName();

    Connection getConnection()
            throws SQLException;

    long count()
            throws UserResolutionException;

    long count(String whereClause)
            throws UserResolutionException;

    @Deprecated
    void deleteById(String fieldIdName, long fieldIdValue)
            throws SQLException;

    @Deprecated
    void deleteByWhereClause(String whereClause)
            throws SQLException;

}
