package com.cg.SampleApplication.general.logic.api.to;

import java.sql.Date;

import com.cg.SampleApplication.general.common.api.Intervista;
import com.cg.SampleApplication.general.common.api.to.AbstractEto;

/**
 * Entity transport object of Intervista
 */
public class IntervistaEto extends AbstractEto implements Intervista {

  private static final long serialVersionUID = 1L;

  private Long idIntervista;

  private String nome;

  private String cognome;

  private Date dataNascita;

  private String ndg;

  private String codAbi;

  private String cellulare;

  private String email;

  private String indirizzo;

  // private Set<OffertaEntity> offers;
  //
  // /**
  // * @return offers
  // */
  // public Set<OffertaEntity> getOffers() {
  //
  // return this.offers;
  // }
  //
  // /**
  // * @param offers new value of {@link #getoffers}.
  // */
  // public void setOffers(Set<OffertaEntity> offers) {
  //
  // this.offers = offers;
  // }

  @Override
  public Long getIdIntervista() {

    return this.idIntervista;
  }

  @Override
  public void setIdIntervista(Long idIntervista) {

    this.idIntervista = idIntervista;
  }

  @Override
  public String getNome() {

    return this.nome;
  }

  @Override
  public void setNome(String nome) {

    this.nome = nome;
  }

  @Override
  public String getCognome() {

    return this.cognome;
  }

  @Override
  public void setCognome(String cognome) {

    this.cognome = cognome;
  }

  @Override
  public Date getDataNascita() {

    return this.dataNascita;
  }

  @Override
  public void setDataNascita(Date dataNascita) {

    this.dataNascita = dataNascita;
  }

  @Override
  public String getNdg() {

    return this.ndg;
  }

  @Override
  public void setNdg(String ndg) {

    this.ndg = ndg;
  }

  @Override
  public String getCodAbi() {

    return this.codAbi;
  }

  @Override
  public void setCodAbi(String codAbi) {

    this.codAbi = codAbi;
  }

  @Override
  public String getCellulare() {

    return this.cellulare;
  }

  @Override
  public void setCellulare(String cellulare) {

    this.cellulare = cellulare;
  }

  @Override
  public String getEmail() {

    return this.email;
  }

  @Override
  public void setEmail(String email) {

    this.email = email;
  }

  @Override
  public String getIndirizzo() {

    return this.indirizzo;
  }

  @Override
  public void setIndirizzo(String indirizzo) {

    this.indirizzo = indirizzo;
  }

  @Override
  public int hashCode() {

    final int prime = 31;
    int result = super.hashCode();
    result = prime * result + ((this.idIntervista == null) ? 0 : this.idIntervista.hashCode());
    result = prime * result + ((this.nome == null) ? 0 : this.nome.hashCode());
    result = prime * result + ((this.cognome == null) ? 0 : this.cognome.hashCode());
    result = prime * result + ((this.dataNascita == null) ? 0 : this.dataNascita.hashCode());
    result = prime * result + ((this.ndg == null) ? 0 : this.ndg.hashCode());
    result = prime * result + ((this.codAbi == null) ? 0 : this.codAbi.hashCode());
    result = prime * result + ((this.cellulare == null) ? 0 : this.cellulare.hashCode());
    result = prime * result + ((this.email == null) ? 0 : this.email.hashCode());
    result = prime * result + ((this.indirizzo == null) ? 0 : this.indirizzo.hashCode());

    return result;
  }

  @Override
  public boolean equals(Object obj) {

    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    // class check will be done by super type EntityTo!
    if (!super.equals(obj)) {
      return false;
    }
    IntervistaEto other = (IntervistaEto) obj;
    if (this.idIntervista == null) {
      if (other.idIntervista != null) {
        return false;
      }
    } else if (!this.idIntervista.equals(other.idIntervista)) {
      return false;
    }
    if (this.nome == null) {
      if (other.nome != null) {
        return false;
      }
    } else if (!this.nome.equals(other.nome)) {
      return false;
    }
    if (this.cognome == null) {
      if (other.cognome != null) {
        return false;
      }
    } else if (!this.cognome.equals(other.cognome)) {
      return false;
    }
    if (this.dataNascita == null) {
      if (other.dataNascita != null) {
        return false;
      }
    } else if (!this.dataNascita.equals(other.dataNascita)) {
      return false;
    }
    if (this.ndg == null) {
      if (other.ndg != null) {
        return false;
      }
    } else if (!this.ndg.equals(other.ndg)) {
      return false;
    }
    if (this.codAbi == null) {
      if (other.codAbi != null) {
        return false;
      }
    } else if (!this.codAbi.equals(other.codAbi)) {
      return false;
    }
    if (this.cellulare == null) {
      if (other.cellulare != null) {
        return false;
      }
    } else if (!this.cellulare.equals(other.cellulare)) {
      return false;
    }
    if (this.email == null) {
      if (other.email != null) {
        return false;
      }
    } else if (!this.email.equals(other.email)) {
      return false;
    }
    if (this.indirizzo == null) {
      if (other.indirizzo != null) {
        return false;
      }
    } else if (!this.indirizzo.equals(other.indirizzo)) {
      return false;
    }

    return true;
  }
}
