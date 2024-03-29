package com.tackit.DTO;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class User implements Serializable{
	/**
	 * 
	 */
	
	//Contains all the user - related elements related elements
	private static final long serialVersionUID = 1L;
	String userId;
	String fName;
	String lName;
	String uName;
	String uPasswd;
	List<String> genre=new ArrayList<String>();
	String rGenre;
	List<Board> boardList=new ArrayList<Board>();
	Map<String,String> boardID=new HashMap<String, String>();
	List<Board> followedBoardList=new ArrayList<Board>();
	List<Board> uBSuggestionList=new ArrayList<Board>();
	List<Pin> boardPinList=new  ArrayList<Pin>();
	List<Pin> feedPinList=new  ArrayList<Pin>();
	List<String> genreList=new ArrayList<String>();
	
	
	public Map<String, String> getBoardID() {
		return boardID;
	}

	public void setBoardID(Map<String, String> boardID) {
		this.boardID = boardID;
	}

	public List<String> getGenreList() {
		return genreList;
	}

	public void setGenreList(List<String> genreList) {
		this.genreList = genreList;
	}

	public List<Pin> getBoardPinList() {
		return boardPinList;
	}

	public void setBoardPinList(List<Pin> boardPinList) {
		this.boardPinList = boardPinList;
	}

	public List<Pin> getFeedPinList() {
		return feedPinList;
	}

	public void setFeedPinList(List<Pin> feedPinList) {
		this.feedPinList = feedPinList;
	}

	public List<Board> getFollowedBoardList() {
		return followedBoardList;
	}

	public void setFollowedBoardList(List<Board> followedBoardList) {
		this.followedBoardList = followedBoardList;
	}

	public List<Board> getBoardList() {
		return boardList;
	}

	public void setBoardList(List<Board> boardList) {
		this.boardList = boardList;
	}

	public List<Board> getuBSuggestionList() {
		return uBSuggestionList;
	}

	public void setuBSuggestionList(List<Board> uBSuggestionList) {
		this.uBSuggestionList = uBSuggestionList;
	}

	public String getrGenre() {
		return rGenre;
	}

	public void setrGenre(String rGenre) {
		this.rGenre = rGenre;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public String getuName() {
		return uName;
	}

	public void setuName(String uName) {
		this.uName = uName;
	}

	public String getuPasswd() {
		return uPasswd;
	}

	public void setuPasswd(String uPasswd) {
		this.uPasswd = uPasswd;
	}

	public List<String> getGenre() {
		return genre;
	}

	public void setGenre(List<String> genre) {
		this.genre = genre;
	}

}
