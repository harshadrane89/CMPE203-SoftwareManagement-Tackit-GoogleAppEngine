package com.tackit.DTO;

import java.io.Serializable;
import java.util.List;

public class Board implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int boardId;
	String boardName;
	String boardDesc;
	List<Pin> pinList;
	int boardType;
	String boardGenre;
	
	public int getBoardId() {
		return boardId;
	}
	public void setBoardId(int boardId) {
		this.boardId = boardId;
	}
	public int getBoardType() {
		return boardType;
	}
	public void setBoardType(int boardType) {
		this.boardType = boardType;
	}
	public String getBoardGenre() {
		return boardGenre;
	}
	public void setBoardGenre(String boardGenre) {
		this.boardGenre = boardGenre;
	}
	public String getBoardName() {
		return boardName;
	}
	public void setBoardName(String boardName) {
		this.boardName = boardName;
	}
	public String getBoardDesc() {
		return boardDesc;
	}
	public void setBoardDesc(String boardDesc) {
		this.boardDesc = boardDesc;
	}
	public List<Pin> getPinList() {
		return pinList;
	}
	public void setPinList(List<Pin> pinList) {
		this.pinList = pinList;
	}
	
	

}
