package test.cg.general.dataaccess.base.dao;

import org.springframework.stereotype.Repository;

import io.oasp.module.jpa.dataaccess.api.MutablePersistenceEntity;
import io.oasp.module.jpa.dataaccess.base.AbstractRevisionedDao;
import test.cg.general.dataaccess.api.dao.ApplicationDao;

/**
 * This is the abstract base implementation of {@link ApplicationDao}.
 *
 * @param <ENTITY> is the {@link #getEntityClass() type} of the managed entity.
 *
 */
@Repository
public abstract class ApplicationDaoImpl<ENTITY extends MutablePersistenceEntity<Long>>
    extends AbstractRevisionedDao<ENTITY> implements ApplicationDao<ENTITY> {

  /**
   * The constructor.
   */
  public ApplicationDaoImpl() {

    super();
  }

}
