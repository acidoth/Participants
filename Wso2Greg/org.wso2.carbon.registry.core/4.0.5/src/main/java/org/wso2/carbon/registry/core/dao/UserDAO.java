package org.wso2.carbon.registry.core.dao;

import org.wso2.carbon.registry.core.exceptions.RegistryException;

/**
 * Created with IntelliJ IDEA.
 * User: hari
 * Date: 6/28/13
 * Time: 2:48 PM
 * To change this template use File | Settings | File Templates.
 */
public interface UserDAO {

    void setUserFname(String userFname) throws RegistryException;

    void setUserLname(String userLname) throws RegistryException;

    void setUserAge(String userAge) throws RegistryException;

    String getUserAge();

    String getUserLname();

    String getUserFname();

}
