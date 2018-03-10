package ch.inetware.openshift.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.data.annotation.ReadOnlyProperty;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * Einfaches Todo-Listen Element.
 *
 * @author Ralph Goebel ralph.goebel@inetware.ch
 * <p>
 * Created by ralph on 03.08.17.
 */
@Entity
public class Todo {

  public Todo() {
  }

  public Todo(String title, String details) {
    this.title = title;
    this.details = details;
  }

  // ID der Aufgabe / Aktivität
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @ApiModelProperty(readOnly = true)
  public Long id;

  // Erfassungsdatum
  @JsonProperty
  @ApiModelProperty(notes = "Erfassungszeitpunkt des Todo-Eintrags")
  @Column(nullable = false)
  public LocalDateTime addedAt;

  // Änderungsdatum
  @JsonProperty
  @ApiModelProperty(notes = "Änderungszeitpunkt des Todo-Eintrags")
  @Column
  public LocalDateTime modifiedAt;

  // Erledigen bis zu diesem Datum
  @JsonProperty
  @ApiModelProperty(notes = "Datum bis zu dem die Aufgabe erledigt werden muss")
  @Column
  public LocalDate dueAtDate;

  // Erledigen bis zu dieser Zeit
  @JsonProperty
  @JsonFormat
  @ApiModelProperty(notes = "Uhrzeit bis zu der die Aufgabe erledigt werden muss")
  @Column
  public LocalTime dueAtTime;

  // Erinnerungszeitpunkt
  @JsonProperty
  @ApiModelProperty(notes = "Zeitpunkt an dem eine Erinnerung an die Aufgabe erfolgen soll")
  @Column
  public LocalDateTime remindAt;

  // Titel der Aufgabe/Aktvität
  @JsonProperty(required = true)
  @ApiModelProperty(notes = "Titel der Aufgabe", required = true)
  @Column(nullable = false)
  public String title;

  // Details
  @JsonProperty
  @ApiModelProperty(notes = "Beschreibung der Aufgabe")
  @Column
  public String details;

}
