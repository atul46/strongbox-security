package org.carlspring.strongbox.jaas;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;

/**
 * @author mtodorov
 */
public class Role implements Serializable
{

    @XStreamOmitField
    private long roleId;

    @XStreamAlias(value = "name")
    private String name;

    @XStreamAlias(value = "description")
    private String description;

    /**
     * The repository this role is associated with.
     */
    @XStreamAlias(value = "repository")
    private String repository;

    /**
     * Nested roles.
     */
    @XStreamAlias(value = "roles")
    private List<String> roles = new ArrayList<String>();

    @XStreamAlias(value = "privileges")
    private List<String> privileges = new ArrayList<String>();


    public Role()
    {
    }

    public Role(String name,
                String description)
    {
        this.name = name;
        this.description = description;
    }

    public long getRoleId()
    {
        return roleId;
    }

    public void setRoleId(long roleId)
    {
        this.roleId = roleId;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public String getRepository()
    {
        return repository;
    }

    public void setRepository(String repository)
    {
        this.repository = repository;
    }

    public List<String> getRoles()
    {
        return roles;
    }

    public void setRoles(List<String> roles)
    {
        this.roles = roles;
    }

    public boolean addRole(String role)
    {
        return roles.add(role);
    }

    public boolean removeRole(String role)
    {
        return roles.remove(role);
    }

    public boolean containsRole(String role)
    {
        return roles.contains(role);
    }

    public List<String> getPrivileges()
    {
        return privileges;
    }

    public void setPrivileges(List<String> privileges)
    {
        this.privileges = privileges;
    }

    public boolean addPrivilege(String privilege)
    {
        return privileges.add(privilege);
    }

    public boolean removePrivilege(String privilege)
    {
        return privileges.remove(privilege);
    }

    public boolean containsPrivilege(String privilege)
    {
        return privileges.contains(privilege);
    }

    @Override
    public String toString()
    {
        return "Role{" +
               "roleId=" + roleId +
               ", name='" + name + '\'' +
               ", description='" + description + '\'' +
               ", repository='" + repository + '\'' +
               ", roles=" + roles +
               ", privileges=" + privileges +
               '}';
    }

}
