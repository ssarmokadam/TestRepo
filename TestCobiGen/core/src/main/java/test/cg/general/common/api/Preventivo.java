package test.cg.general.common.api;

/**
 * @author ssarmoka
 */
public interface Preventivo extends ApplicationEntity {

  public Long getOffertaId();

  public void setOffertaId(Long offertaId);

  public Long getIdPreventivo();

  public void setIdPreventivo(Long idPreventivo);

  public String getCodProdotto();

  public void setCodProdotto(String codProdotto);

  public Long getImportoRichiesto();

  public void setImportoRichiesto(Long importoRichiesto);

  public Long getDurataMesi();

  public void setDurataMesi(Long durataMesi);

}
