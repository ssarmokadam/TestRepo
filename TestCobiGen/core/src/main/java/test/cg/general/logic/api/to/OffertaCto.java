package test.cg.general.logic.api.to;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import test.cg.general.common.api.to.AbstractCto;

/**
 * Composite transport object of Offerta
 */
public class OffertaCto extends AbstractCto {

  private static final long serialVersionUID = 1L;

  private OffertaEto offerta;

  // private IntervistaEto intervista;

  private Set<PreventivoEto> preventivo = new HashSet<>();

  public OffertaEto getOfferta() {

    return this.offerta;
  }

  public void setOfferta(OffertaEto offerta) {

    this.offerta = offerta;
  }

  /**
   * @return preventivo
   */
  public Set<PreventivoEto> getPreventivo() {

    return this.preventivo;
  }

  /**
   * @param preventivo new value of {@link #getpreventivo}.
   */
  public void setPreventivo(Set<PreventivoEto> preventivo) {

    this.preventivo = preventivo;
  }

  // /**
  // * @return preventivo
  // */
  // public Set<PreventivoCto> getPreventivo() {
  //
  // return this.preventivo;
  // }
  //
  // /**
  // * @param preventivo new value of {@link #getpreventivo}.
  // */
  // public void setPreventivo(Set<PreventivoCto> preventivo) {
  //
  // this.preventivo = preventivo;
  // }

  // /**
  // * @return intervista
  // */
  // public IntervistaCto getIntervista() {
  //
  // return this.intervista;
  // }
  //
  // /**
  // * @param intervista new value of {@link #getintervista}.
  // */
  // public void setIntervista(IntervistaCto intervista) {
  //
  // this.intervista = intervista;
  // }

  // public IntervistaEto getIntervista() {
  //
  // return this.intervista;
  // }
  //
  // public void setIntervista(IntervistaEto intervista) {
  //
  // this.intervista = intervista;
  // }

  // public Set<PreventivoEto> getPreventivo() {
  //
  // return this.preventivo;
  // }
  //
  // public void setPreventivo(Set<PreventivoEto> preventivo) {
  //
  // this.preventivo = preventivo;
  // }

  @Override
  public int hashCode() {

    return Objects.hash(getOfferta().getId());
  }

  @Override
  public boolean equals(Object obj) {

    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    OffertaCto other = (OffertaCto) obj;
    if (!Objects.equals(getOfferta().getId(), other.getOfferta().getId())) {
      return false;
    }
    return true;
  }
}
