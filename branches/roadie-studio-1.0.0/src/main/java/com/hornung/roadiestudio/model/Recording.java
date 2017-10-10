package com.hornung.roadiestudio.model;

import java.io.Serializable;
import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the en_recordings database table.
 * 
 */
@Entity
@Table(name="en_recordings")
@NamedQuery(name="Recording.findAll", query="SELECT r FROM Recording r")
public class Recording implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="COD_RECORDING")
	private int codRecording;

	@Column(name="DESCRIPTION")
	private String description;

	@Column(name="HOUR_QUANTITY")
	private BigDecimal hourQuantity;

	@Column(name="HOUR_VALUE")
	private BigDecimal hourValue;

	@Column(name="IS_FOR_SHOW")
	private byte isForShow;

	@Column(name="IS_INSTRUMENT")
	private byte isInstrument;

	@Column(name="IS_TO_FIX")
	private byte isToFix;
	
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat (pattern="dd/MM/yyyy HH:mm")
	@Column(name="START_DATETIME")
	private Date startDatetime;
	
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat (pattern="dd/MM/yyyy HH:mm")
	@Column(name="END_DATETIME")
	private Date endDatetime;

	//bi-directional many-to-one association to Band
	@ManyToOne
	@JoinColumn(name="COD_BAND")
	private Band Band;

	//bi-directional many-to-one association to Room
	@ManyToOne
	@JoinColumn(name="COD_ROOM")
	private Room Room;

	//bi-directional many-to-one association to Stock
	@ManyToOne
	@JoinColumn(name="COD_STOCK")
	private Stock Stock;

	public Recording() {
	}

	public int getCodRecording() {
		return this.codRecording;
	}

	public void setCodRecording(int codRecording) {
		this.codRecording = codRecording;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BigDecimal getHourQuantity() {
		return this.hourQuantity;
	}

	public void setHourQuantity(BigDecimal hourQuantity) {
		this.hourQuantity = hourQuantity;
	}

	public BigDecimal getHourValue() {
		return this.hourValue;
	}

	public void setHourValue(BigDecimal hourValue) {
		this.hourValue = hourValue;
	}

	public byte getIsForShow() {
		return this.isForShow;
	}

	public void setIsForShow(byte isForShow) {
		this.isForShow = isForShow;
	}

	public byte getIsInstrument() {
		return this.isInstrument;
	}

	public void setIsInstrument(byte isInstrument) {
		this.isInstrument = isInstrument;
	}

	public byte getIsToFix() {
		return this.isToFix;
	}

	public void setIsToFix(byte isToFix) {
		this.isToFix = isToFix;
	}

	public Band getBand() {
		return this.Band;
	}

	public void setBand(Band Band) {
		this.Band = Band;
	}

	public Room getRoom() {
		return this.Room;
	}

	public void setRoom(Room Room) {
		this.Room = Room;
	}

	public Stock getStock() {
		return this.Stock;
	}

	public void setStock(Stock Stock) {
		this.Stock = Stock;
	}

	public Date getStartDatetime() {
		return startDatetime;
	}

	public void setStartDatetime(Date startDatetime) {
		this.startDatetime = startDatetime;
	}

	public Date getEndDatetime() {
		return endDatetime;
	}

	public void setEndDatetime(Date endDatetime) {
		this.endDatetime = endDatetime;
	}

}