package test.cg.general.logic.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

import javax.inject.Inject;
import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.oasp.module.jpa.common.api.to.PaginatedListTo;
import test.cg.general.dataaccess.api.IntervistaEntity;
import test.cg.general.dataaccess.api.OffertaEntity;
import test.cg.general.dataaccess.api.PreventivoEntity;
import test.cg.general.dataaccess.api.dao.IntervistaDao;
import test.cg.general.dataaccess.api.dao.OffertaDao;
import test.cg.general.dataaccess.api.dao.PreventivoDao;
import test.cg.general.logic.api.General;
import test.cg.general.logic.api.to.IntervistaCto;
import test.cg.general.logic.api.to.IntervistaEto;
import test.cg.general.logic.api.to.IntervistaSearchCriteriaTo;
import test.cg.general.logic.api.to.OffertaCto;
import test.cg.general.logic.api.to.OffertaEto;
import test.cg.general.logic.api.to.OffertaSearchCriteriaTo;
import test.cg.general.logic.api.to.PreventivoEto;
import test.cg.general.logic.api.to.PreventivoSearchCriteriaTo;
import test.cg.general.logic.base.AbstractComponentFacade;

/**
 * Implementation of component interface of general
 */
@Named
public class GeneralImpl extends AbstractComponentFacade implements General {

  /**
   * Logger instance.
   */
  private static final Logger LOG = LoggerFactory.getLogger(GeneralImpl.class);

  /**
   * @see #getIntervistaDao()
   */
  @Inject
  private IntervistaDao intervistaDao;

  /**
   * @see #getOffertaDao()
   */
  @Inject
  private OffertaDao offertaDao;

  /**
   * @see #getPreventivoDao()
   */
  @Inject
  private PreventivoDao preventivoDao;

  /**
   * The constructor.
   */
  public GeneralImpl() {

    super();
  }

  @Override
  public IntervistaEto findIntervista(Long id) {

    LOG.debug("Get Intervista with id {} from database.", id);
    return getBeanMapper().map(getIntervistaDao().findOne(id), IntervistaEto.class);
  }

  @Override
  public PaginatedListTo<IntervistaEto> findIntervistaEtos(IntervistaSearchCriteriaTo criteria) {

    criteria.limitMaximumPageSize(MAXIMUM_HIT_LIMIT);
    PaginatedListTo<IntervistaEntity> intervistas = getIntervistaDao().findIntervistas(criteria);
    return mapPaginatedEntityList(intervistas, IntervistaEto.class);
  }

  @Override
  public boolean deleteIntervista(Long intervistaId) {

    IntervistaEntity intervista = getIntervistaDao().find(intervistaId);
    getIntervistaDao().delete(intervista);
    LOG.debug("The intervista with id '{}' has been deleted.", intervistaId);
    return true;
  }

  @Override
  public IntervistaEto saveIntervista(IntervistaEto intervista) {

    Objects.requireNonNull(intervista, "intervista");
    IntervistaEntity intervistaEntity = getBeanMapper().map(intervista, IntervistaEntity.class);

    // initialize, validate intervistaEntity here if necessary
    getIntervistaDao().save(intervistaEntity);
    LOG.debug("Intervista with id '{}' has been created.", intervistaEntity.getId());

    return getBeanMapper().map(intervistaEntity, IntervistaEto.class);
  }

  /**
   * Returns the field 'intervistaDao'.
   *
   * @return the {@link IntervistaDao} instance.
   */
  public IntervistaDao getIntervistaDao() {

    return this.intervistaDao;
  }

  @Override
  public OffertaEto findOfferta(Long id) {

    LOG.debug("Get Offerta with id {} from database.", id);
    return getBeanMapper().map(getOffertaDao().findOne(id), OffertaEto.class);
  }

  @Override
  public PaginatedListTo<OffertaEto> findOffertaEtos(OffertaSearchCriteriaTo criteria) {

    criteria.limitMaximumPageSize(MAXIMUM_HIT_LIMIT);
    PaginatedListTo<OffertaEntity> offertas = getOffertaDao().findOffertas(criteria);
    return mapPaginatedEntityList(offertas, OffertaEto.class);
  }

  @Override
  public boolean deleteOfferta(Long offertaId) {

    OffertaEntity offerta = getOffertaDao().find(offertaId);
    getOffertaDao().delete(offerta);
    LOG.debug("The offerta with id '{}' has been deleted.", offertaId);
    return true;
  }

  @Override
  public OffertaEto saveOfferta(OffertaEto offerta) {

    Objects.requireNonNull(offerta, "offerta");
    OffertaEntity offertaEntity = getBeanMapper().map(offerta, OffertaEntity.class);

    // initialize, validate offertaEntity here if necessary
    getOffertaDao().save(offertaEntity);
    LOG.debug("Offerta with id '{}' has been created.", offertaEntity.getId());

    return getBeanMapper().map(offertaEntity, OffertaEto.class);
  }

  /**
   * Returns the field 'offertaDao'.
   *
   * @return the {@link OffertaDao} instance.
   */
  public OffertaDao getOffertaDao() {

    return this.offertaDao;
  }

  @Override
  public PreventivoEto findPreventivo(Long id) {

    LOG.debug("Get Preventivo with id {} from database.", id);
    return getBeanMapper().map(getPreventivoDao().findOne(id), PreventivoEto.class);
  }

  @Override
  public PaginatedListTo<PreventivoEto> findPreventivoEtos(PreventivoSearchCriteriaTo criteria) {

    criteria.limitMaximumPageSize(MAXIMUM_HIT_LIMIT);
    PaginatedListTo<PreventivoEntity> preventivos = getPreventivoDao().findPreventivos(criteria);
    return mapPaginatedEntityList(preventivos, PreventivoEto.class);
  }

  @Override
  public boolean deletePreventivo(Long preventivoId) {

    PreventivoEntity preventivo = getPreventivoDao().find(preventivoId);
    getPreventivoDao().delete(preventivo);
    LOG.debug("The preventivo with id '{}' has been deleted.", preventivoId);
    return true;
  }

  @Override
  public PreventivoEto savePreventivo(PreventivoEto preventivo) {

    Objects.requireNonNull(preventivo, "preventivo");
    PreventivoEntity preventivoEntity = getBeanMapper().map(preventivo, PreventivoEntity.class);

    // initialize, validate preventivoEntity here if necessary
    getPreventivoDao().save(preventivoEntity);
    LOG.debug("Preventivo with id '{}' has been created.", preventivoEntity.getId());

    return getBeanMapper().map(preventivoEntity, PreventivoEto.class);
  }

  /**
   * Returns the field 'preventivoDao'.
   *
   * @return the {@link PreventivoDao} instance.
   */
  public PreventivoDao getPreventivoDao() {

    return this.preventivoDao;
  }

  @Override
  public IntervistaCto findIntervista1(long id) {

    LOG.debug("Get Intervista with id {} from database.", id);

    // 1.get intervista Eto
    IntervistaEntity inertvista = getIntervistaDao().findOne(id);
    IntervistaEto interVistaEto = getBeanMapper().map(inertvista, IntervistaEto.class);

    // 2.get offerta eto
    OffertaSearchCriteriaTo criteria = new OffertaSearchCriteriaTo();
    criteria.setIntervistaId(id);
    List<OffertaEntity> offertaEntityList = getOffertaDao().findOffertas(criteria).getResult();
    List<OffertaEto> offertaEtoList = getBeanMapper().mapList(offertaEntityList, OffertaEto.class);

    IntervistaCto intervistaCto = new IntervistaCto();
    intervistaCto.setIntervista(interVistaEto);

    // set offertaEto in offertaCto object
    List<OffertaCto> offertaCtoSet = new ArrayList<>();
    OffertaCto offertaCto;
    Iterator<OffertaEto> itr = offertaEtoList.iterator();
    while (itr.hasNext()) {
      OffertaEto offertaEtoObj = itr.next();
      offertaCto = new OffertaCto();
      offertaCto.setOfferta(offertaEtoObj);

      PreventivoSearchCriteriaTo preventivoCiteria = new PreventivoSearchCriteriaTo();
      preventivoCiteria.setOffertaId(offertaEtoObj.getId());

      List<PreventivoEntity> preventivoEntityList = new ArrayList<>();
      preventivoEntityList = getPreventivoDao().findPreventivos(preventivoCiteria).getResult();
      if (preventivoEntityList != null && !preventivoEntityList.isEmpty()) {
        List<PreventivoEto> PreventivoEtoList = new ArrayList<>();
        PreventivoEtoList = getBeanMapper().mapList(preventivoEntityList, PreventivoEto.class); // PreventivoetoList
                                                                                                // with
                                                                                                // respective
                                                                                                // offertaId
        offertaCto.getPreventivo().addAll(PreventivoEtoList);
      }

      offertaCtoSet.add(offertaCto);

    }
    intervistaCto.getOffers().addAll(offertaCtoSet);

    return intervistaCto;
  }

}
