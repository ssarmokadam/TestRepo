package test.cg.general.dataaccess.impl.dao;

import javax.inject.Named;

import com.mysema.query.alias.Alias;
import com.mysema.query.jpa.impl.JPAQuery;
import com.mysema.query.types.path.EntityPathBase;

import io.oasp.module.jpa.common.api.to.PaginatedListTo;
import test.cg.general.dataaccess.api.OffertaEntity;
import test.cg.general.dataaccess.api.dao.OffertaDao;
import test.cg.general.dataaccess.base.dao.ApplicationDaoImpl;
import test.cg.general.logic.api.to.OffertaSearchCriteriaTo;

/**
 * This is the implementation of {@link OffertaDao}.
 */
@Named
public class OffertaDaoImpl extends ApplicationDaoImpl<OffertaEntity> implements OffertaDao {

  /**
   * The constructor.
   */
  public OffertaDaoImpl() {

    super();
  }

  @Override
  public Class<OffertaEntity> getEntityClass() {

    return OffertaEntity.class;
  }

  @Override
  public PaginatedListTo<OffertaEntity> findOffertas(OffertaSearchCriteriaTo criteria) {

    OffertaEntity offerta = Alias.alias(OffertaEntity.class);
    EntityPathBase<OffertaEntity> alias = Alias.$(offerta);
    JPAQuery query = new JPAQuery(getEntityManager()).from(alias);

    Long idOfferta = criteria.getIdOfferta();
    if (idOfferta != null) {
      query.where(Alias.$(offerta.getIdOfferta()).eq(idOfferta));
    }
    String ndg = criteria.getNdg();
    if (ndg != null) {
      query.where(Alias.$(offerta.getNdg()).eq(ndg));
    }
    Long intervista = criteria.getIntervistaId();
    if (intervista != null) {
      if (offerta.getIntervista() != null) {
        query.where(Alias.$(offerta.getIntervista().getId()).eq(intervista));
      }
    }
    return findPaginated(criteria, query, alias);
  }

}