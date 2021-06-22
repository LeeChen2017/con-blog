package org.licc.repository;

import org.licc.domain.User;
import org.springframework.data.repository.CrudRepository;

/**
 * @author licc
 * @date 2021/6/22
 */
public interface UserRepository extends CrudRepository<User,Long>  , CustomInsert<User>  {

}
