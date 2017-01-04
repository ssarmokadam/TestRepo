package com.cg.SampleApplication.general.dataaccess.api.dao;

import com.cg.SampleApplication.general.dataaccess.api.OffertaEntity;
import com.cg.SampleApplication.general.logic.api.to.OffertaSearchCriteriaTo;

import io.oasp.module.jpa.common.api.to.PaginatedListTo;

/**
 * Data access interface for Offerta entities
 */
public interface OffertaDao extends ApplicationDao<OffertaEntity> {

  /**
   * Finds the {@link OffertaEntity offertas} matching the given {@link OffertaSearchCriteriaTo}.
   *
   * @param criteria is the {@link OffertaSearchCriteriaTo}.
   * @return the {@link PaginatedListTo} with the matching {@link OffertaEntity} objects.
   */
  PaginatedListTo<OffertaEntity> findOffertas(OffertaSearchCriteriaTo criteria);
}
