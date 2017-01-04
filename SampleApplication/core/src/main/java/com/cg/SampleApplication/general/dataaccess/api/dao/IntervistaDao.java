package com.cg.SampleApplication.general.dataaccess.api.dao;

import com.cg.SampleApplication.general.dataaccess.api.IntervistaEntity;
import com.cg.SampleApplication.general.logic.api.to.IntervistaSearchCriteriaTo;

import io.oasp.module.jpa.common.api.to.PaginatedListTo;

/**
 * Data access interface for Intervista entities
 */
public interface IntervistaDao extends ApplicationDao<IntervistaEntity> {

  /**
   * Finds the {@link IntervistaEntity intervistas} matching the given {@link IntervistaSearchCriteriaTo}.
   *
   * @param criteria is the {@link IntervistaSearchCriteriaTo}.
   * @return the {@link PaginatedListTo} with the matching {@link IntervistaEntity} objects.
   */
  PaginatedListTo<IntervistaEntity> findIntervistas(IntervistaSearchCriteriaTo criteria);
}
