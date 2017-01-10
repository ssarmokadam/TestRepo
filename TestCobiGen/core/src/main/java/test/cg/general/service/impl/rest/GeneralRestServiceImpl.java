package test.cg.general.service.impl.rest;

import javax.inject.Inject;
import javax.inject.Named;

import io.oasp.module.jpa.common.api.to.PaginatedListTo;
import test.cg.general.logic.api.General;
import test.cg.general.logic.api.to.IntervistaCto;
import test.cg.general.logic.api.to.IntervistaEto;
import test.cg.general.logic.api.to.IntervistaSearchCriteriaTo;
import test.cg.general.logic.api.to.OffertaEto;
import test.cg.general.logic.api.to.OffertaSearchCriteriaTo;
import test.cg.general.logic.api.to.PreventivoEto;
import test.cg.general.logic.api.to.PreventivoSearchCriteriaTo;
import test.cg.general.service.api.rest.GeneralRestService;

/**
 * The service implementation for REST calls in order to execute the logic of component {@link General}.
 */
@Named("GeneralRestService")
public class GeneralRestServiceImpl implements GeneralRestService {

  @Inject
  private General general;

  @Override
  public IntervistaEto getIntervista(long id) {

    return this.general.findIntervista(id);
  }

  @Override
  public IntervistaEto saveIntervista(IntervistaEto intervista) {

    return this.general.saveIntervista(intervista);
  }

  @Override
  public void deleteIntervista(long id) {

    this.general.deleteIntervista(id);
  }

  @Override
  public PaginatedListTo<IntervistaEto> findIntervistasByPost(IntervistaSearchCriteriaTo searchCriteriaTo) {

    return this.general.findIntervistaEtos(searchCriteriaTo);
  }

  @Override
  public OffertaEto getOfferta(long id) {

    return this.general.findOfferta(id);
  }

  @Override
  public OffertaEto saveOfferta(OffertaEto offerta) {

    return this.general.saveOfferta(offerta);
  }

  @Override
  public void deleteOfferta(long id) {

    this.general.deleteOfferta(id);
  }

  @Override
  public PaginatedListTo<OffertaEto> findOffertasByPost(OffertaSearchCriteriaTo searchCriteriaTo) {

    return this.general.findOffertaEtos(searchCriteriaTo);
  }

  @Override
  public PreventivoEto getPreventivo(long id) {

    return this.general.findPreventivo(id);
  }

  @Override
  public PreventivoEto savePreventivo(PreventivoEto preventivo) {

    return this.general.savePreventivo(preventivo);
  }

  @Override
  public void deletePreventivo(long id) {

    this.general.deletePreventivo(id);
  }

  @Override
  public PaginatedListTo<PreventivoEto> findPreventivosByPost(PreventivoSearchCriteriaTo searchCriteriaTo) {

    return this.general.findPreventivoEtos(searchCriteriaTo);
  }

  @Override
  public IntervistaCto getIntervista1(long id) {

    return this.general.findIntervista1(id);
  }

}
