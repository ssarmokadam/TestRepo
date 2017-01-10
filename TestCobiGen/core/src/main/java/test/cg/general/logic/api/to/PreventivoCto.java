package test.cg.general.logic.api.to;

import test.cg.general.common.api.to.AbstractCto;

/**
 * Composite transport object of Preventivo
 */
public class PreventivoCto extends AbstractCto {

  private static final long serialVersionUID = 1L;

  private PreventivoEto preventivo;

  // private OffertaCto offerta;
  //
  // /**
  // * @return offerta
  // */
  // public OffertaCto getOfferta() {
  //
  // return this.offerta;
  // }
  //
  // /**
  // * @param offerta new value of {@link #getofferta}.
  // */
  // public void setOfferta(OffertaCto offerta) {
  //
  // this.offerta = offerta;
  // }

  public PreventivoEto getPreventivo() {

    return this.preventivo;
  }

  public void setPreventivo(PreventivoEto preventivo) {

    this.preventivo = preventivo;
  }

  // public OffertaEto getOfferta() {
  //
  // return this.offerta;
  // }
  //
  // public void setOfferta(OffertaEto offerta) {
  //
  // this.offerta = offerta;
  // }

}
