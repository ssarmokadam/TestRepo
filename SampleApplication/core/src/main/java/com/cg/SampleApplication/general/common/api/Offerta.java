package com.cg.SampleApplication.general.common.api;

/**
 * @author ssarmoka
 */
public interface Offerta extends ApplicationEntity {

  public Long getIntervistaId();

  public void setIntervistaId(Long intervistaId);

  public Long getIdOfferta();

  public void setIdOfferta(Long idOfferta);

  public String getNdg();

  public void setNdg(String ndg);

}
