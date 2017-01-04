package com.cg.SampleApplication.general.dataaccess.base.dao;

import com.cg.SampleApplication.general.dataaccess.api.BinaryObjectEntity;
import com.cg.SampleApplication.general.dataaccess.api.dao.BinaryObjectDao;

import javax.inject.Named;

/**
 * Implementation of {@link BinaryObjectDao}.
 *
 */
@Named
public class BinaryObjectDaoImpl extends ApplicationDaoImpl<BinaryObjectEntity> implements BinaryObjectDao {

  @Override
  public Class<BinaryObjectEntity> getEntityClass() {

    return BinaryObjectEntity.class;
  }

}
