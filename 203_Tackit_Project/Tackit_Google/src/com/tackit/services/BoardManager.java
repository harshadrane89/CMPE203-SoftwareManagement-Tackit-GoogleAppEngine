package com.tackit.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.tackit.DTO.Board;
import com.tackit.DTO.Pin;
import com.tackit.DTO.User;
import com.tackit.utils.DBManager;

public class BoardManager {

	public Board createBoard(Board boardObj, String userId) {
		PreparedStatement ps = null;
		Connection con = null;
		String bId = getBoardId();
		boardObj.setBoardId(Integer.parseInt(bId));
		try {
			String sql = "INSERT INTO BOARD_MGMT (USER_ID,BOARD_ID,GENRE, BOARD_NAME, DESCRIPTION,BOARD_TYPE) VALUES (?,?,?,?,?,?)";
			System.out.println("THE QUERY TO VALIDATE USER IS " + sql);
			con = DBManager.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, userId);
			ps.setString(2, bId);
			ps.setString(3, boardObj.getBoardGenre());
			ps.setString(4, boardObj.getBoardName());
			ps.setString(5, boardObj.getBoardDesc());
			ps.setInt(6, boardObj.getBoardType());
			ps.execute();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();

		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return boardObj;
	}

	public String getBoardId() {
		Connection conn = null;
		String sql = null;
		Statement st = null;
		ResultSet rs = null;
		int maxVal = 0;
		try {
			conn = DBManager.getConnection();
			sql = "SELECT MAX(BOARD_ID) FROM BOARD_MGMT";
			st = conn.createStatement();
			rs = st.executeQuery(sql);

			while (rs.next()) {
				maxVal = rs.getInt(1);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			if (st != null) {
				try {
					st.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		return (maxVal + 1 + "");
	}

	public void updateUserBoardMaster(String uId, String bId) {

		PreparedStatement ps = null;
		Connection con = null;
		try {
			String sql = "INSERT INTO USERBOARDMASTER (USER_ID,BOARD_ID) VALUES (?,?)";
			System.out.println("THE QUERY TO VALIDATE USER IS " + sql);
			con = DBManager.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, uId);
			ps.setString(2, bId);
			ps.execute();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();

		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}

	public void populateUserBoardList(User uObj) {
		PreparedStatement ps = null;
		Connection con = null;
		ResultSet rs = null;
		Board boardObj = null;
		List<Board> bList = new ArrayList<Board>();
		Map<String,String> bMap=new HashMap<String, String> (); 
		try {
			String sql = "SELECT * FROM BOARD_MGMT WHERE USER_ID='" + uObj.getUserId()
					+ "'";
			System.out.println("THE QUERY TO VALIDATE USER IS " + sql);
			con = DBManager.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			boardObj = new Board();

			while (rs.next()) {
				boardObj = new Board();
				boardObj.setBoardId(rs.getInt("Board_Id"));
				boardObj.setBoardName(rs.getString("Board_Name"));
				boardObj.setBoardDesc(rs.getString("Description"));
				boardObj.setBoardGenre(rs.getString("Genre"));
				boardObj.setBoardType(rs.getInt("Board_Type"));
				bMap.put(boardObj.getBoardName(),boardObj.getBoardId()+"" );
				bList.add(boardObj);
			}
			System.out.println(bMap.keySet());
			uObj.setBoardList(bList);
			uObj.setBoardID(bMap);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();

		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}

	
	public List<Board> populateFollowedBoardList(String uID) {
		PreparedStatement ps = null;
		Connection con = null;
		ResultSet rs = null;
		Board boardObj = null;
		List<Board> bList = new ArrayList<Board>();
		try {
			String sql = "SELECT * FROM BOARD_MGMT WHERE BOARD_ID IN(SELECT BOARD_ID FROM USERBOARDMASTER WHERE USER_ID="+uID+" ) ";
			System.out.println("THE QUERY TO VALIDATE USER IS " + sql);
			con = DBManager.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			boardObj = new Board();

			while (rs.next()) {
				boardObj = new Board();
				boardObj.setBoardId(rs.getInt("Board_Id"));
				boardObj.setBoardName(rs.getString("Board_Name"));
				boardObj.setBoardDesc(rs.getString("Description"));
				boardObj.setBoardGenre(rs.getString("Genre"));
				boardObj.setBoardType(rs.getInt("Board_Type"));
				bList.add(boardObj);
			}
			

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();

		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return bList;
	}
	
	public List<Board> populateSuggestedBoardList(String uID) {
		PreparedStatement ps = null;
		Connection con = null;
		ResultSet rs = null;
		Board boardObj = null;
		List<Board> bList = new ArrayList<Board>();
		try {
			String sql = "SELECT * FROM BOARD_MGMT WHERE BOARD_ID NOT IN(SELECT BOARD_ID FROM USERBOARDMASTER WHERE USER_ID="+uID+" ) AND USER_ID NOT IN ("+uID+") AND GENRE IN (SELECT GENRE FROM USERGENREMASTER WHERE USER_ID = "+uID+")";
			System.out.println("THE QUERY TO VALIDATE USER IS " + sql);
			con = DBManager.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			boardObj = new Board();

			while (rs.next()) {
				boardObj = new Board();
				boardObj.setBoardId(rs.getInt("Board_Id"));
				boardObj.setBoardName(rs.getString("Board_Name"));
				boardObj.setBoardDesc(rs.getString("Description"));
				boardObj.setBoardGenre(rs.getString("Genre"));
				boardObj.setBoardType(rs.getInt("Board_Type"));
				bList.add(boardObj);
			}
			

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();

		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return bList;
	}
}
