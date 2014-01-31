package com.tackit.DTO;

import java.io.Serializable;
import java.util.List;

public class Pin  implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String pinId;
	String pinUid;
	String pinBid;
	String pinName;
	String imgLocation;
	String pinDescription;
	String pinLink;
	String pGenre;
	List<String> comments;
	
	
	public String getPinId() {
		return pinId;
	}
	public void setPinId(String pinId) {
		this.pinId = pinId;
	}
	public String getPinUid() {
		return pinUid;
	}
	public void setPinUid(String pinUid) {
		this.pinUid = pinUid;
	}
	public String getPinBid() {
		return pinBid;
	}
	public void setPinBid(String pinBid) {
		this.pinBid = pinBid;
	}
	public String getpGenre() {
		return pGenre;
	}
	public void setpGenre(String pGenre) {
		this.pGenre = pGenre;
	}
	public String getPinLink() {
		return pinLink;
	}
	public void setPinLink(String pinLink) {
		this.pinLink = pinLink;
	}
	public String getPinName() {
		return pinName;
	}
	public void setPinName(String pinName) {
		this.pinName = pinName;
	}
	public String getImgLocation() {
		return imgLocation;
	}
	public void setImgLocation(String imgLocation) {
		this.imgLocation = imgLocation;
	}
	public String getPinDescription() {
		return pinDescription;
	}
	public void setPinDescription(String pinDescription) {
		this.pinDescription = pinDescription;
	}
	public List<String> getComments() {
		return comments;
	}
	public void setComments(List<String> comments) {
		this.comments = comments;
	}
	
}
