/**
 * 
 */
package net.sf.ikms.service;

import net.sf.ikms.domain.User;

/**
 * @author Oxidy
 *
 */
public interface UserMapper {

	User getUser(String userId);
}
