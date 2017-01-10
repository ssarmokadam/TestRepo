package test.cg.general.logic.api.to;

import java.util.HashSet;
import java.util.Set;

import test.cg.general.common.api.to.AbstractCto;

/**
 * Composite transport object of Intervista
 */
public class IntervistaCto extends AbstractCto {

  private static final long serialVersionUID = 1L;

  private IntervistaEto intervista;

  private Set<OffertaCto> offers = new HashSet<>();

  /**
   * @return intervista
   */
  public IntervistaEto getIntervista() {

    return this.intervista;
  }

  /**
   * @param intervista new value of {@link #getintervista}.
   */
  public void setIntervista(IntervistaEto intervista) {

    this.intervista = intervista;
  }

  /**
   * @return offers
   */
  public Set<OffertaCto> getOffers() {

    return this.offers;
  }

  /**
   * @param offers new value of {@link #getoffers}.
   */
  public void setOffers(Set<OffertaCto> offers) {

    this.offers = offers;
  }

}
