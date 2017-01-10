package test.cg.general.dataaccess.api;

import java.sql.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToMany;

import test.cg.general.common.api.Intervista;

@Entity
@javax.persistence.Table(name = "INTERVISTA")
public class IntervistaEntity extends ApplicationPersistenceEntity implements Intervista {

  @Column(name = "IDINTERVISTA")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long idIntervista;

  @Column(name = "NOME")
  private String nome;

  @Column(name = "COGNOME")
  private String cognome;

  @Column(name = "DATANASCITA")
  private Date dataNascita;

  @Column(name = "NDG")
  private String ndg;

  @Column(name = "CODABI")
  private String codAbi;

  @Column(name = "CELLULARE")
  private String cellulare;

  @Column(name = "EMAIL")
  private String email;

  @Column(name = "INDIRIZZO")
  private String indirizzo;

  private Set<OffertaEntity> offers;

  private static final long serialVersionUID = 1L;

  /**
   * @return idIntervista
   */
  public Long getIdIntervista() {

    return this.idIntervista;
  }

  /**
   * @param idIntervista new value of {@link #getidIntervista}.
   */
  public void setIdIntervista(Long idIntervista) {

    this.idIntervista = idIntervista;
  }

  /**
   * @return nome
   */
  public String getNome() {

    return this.nome;
  }

  /**
   * @param nome new value of {@link #getnome}.
   */
  public void setNome(String nome) {

    this.nome = nome;
  }

  /**
   * @return cognome
   */
  public String getCognome() {

    return this.cognome;
  }

  /**
   * @param cognome new value of {@link #getcognome}.
   */
  public void setCognome(String cognome) {

    this.cognome = cognome;
  }

  /**
   * @return dataNascita
   */
  public Date getDataNascita() {

    return this.dataNascita;
  }

  /**
   * @param dataNascita new value of {@link #getdataNascita}.
   */
  public void setDataNascita(Date dataNascita) {

    this.dataNascita = dataNascita;
  }

  /**
   * @return ndg
   */
  public String getNdg() {

    return this.ndg;
  }

  /**
   * @param ndg new value of {@link #getndg}.
   */
  public void setNdg(String ndg) {

    this.ndg = ndg;
  }

  /**
   * @return codAbi
   */
  public String getCodAbi() {

    return this.codAbi;
  }

  /**
   * @param codAbi new value of {@link #getcodAbi}.
   */
  public void setCodAbi(String codAbi) {

    this.codAbi = codAbi;
  }

  /**
   * @return cellulare
   */
  public String getCellulare() {

    return this.cellulare;
  }

  /**
   * @param cellulare new value of {@link #getcellulare}.
   */
  public void setCellulare(String cellulare) {

    this.cellulare = cellulare;
  }

  /**
   * @return email
   */
  public String getEmail() {

    return this.email;
  }

  /**
   * @param email new value of {@link #getemail}.
   */
  public void setEmail(String email) {

    this.email = email;
  }

  /**
   * @return indirizzo
   */
  public String getIndirizzo() {

    return this.indirizzo;
  }

  /**
   * @param indirizzo new value of {@link #getindirizzo}.
   */
  public void setIndirizzo(String indirizzo) {

    this.indirizzo = indirizzo;
  }

  /**
   * @return offers
   */
  @OneToMany(mappedBy = "intervista", cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
  public Set<OffertaEntity> getOffers() {

    return this.offers;
  }

  /**
   * @param offers new value of {@link #getoffers}.
   */
  public void setOffers(Set<OffertaEntity> offers) {

    this.offers = offers;
  }

}
