package test.cg.general.dataaccess.api.dao;

import io.oasp.module.jpa.common.api.to.PaginatedListTo;
import test.cg.general.dataaccess.api.OffertaEntity;
import test.cg.general.logic.api.to.OffertaSearchCriteriaTo;

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
