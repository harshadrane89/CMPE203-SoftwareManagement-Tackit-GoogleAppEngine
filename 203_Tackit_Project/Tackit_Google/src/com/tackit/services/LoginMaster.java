package com.tackit.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.tackit.DTO.User;
import com.tackit.utils.DBManager;

public class LoginMaster {

	public boolean validateUser(String uName, String uPassword) {
		boolean result = true;
		PreparedStatement ps = null;
		Connection con = null;
		ResultSet rs = null;

		try {
			String sql = "SELECT * FROM USER_MASTER WHERE USER_NAME='" + uName
					+ "' AND PASSWORD = '" + uPassword + "'";
			System.out.println("THE QUERY TO VALIDATE USER IS " + sql);
			con = DBManager.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {
				result = false;
				break;
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
		return result;
	}

	
	public boolean checkUname(String uName) {
		boolean result = false;
		PreparedStatement ps = null;
		Connection con = null;
		ResultSet rs = null;

		try {
			String sql = "SELECT * FROM USER_MASTER WHERE USER_NAME='" + uName
					+ "'";
			System.out.println("THE QUERY TO VALIDATE USER IS " + sql);
			con = DBManager.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {
				result = true;
				break;
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
		return result;
	}
	
	public String getUserId() {
		Connection conn = null;
		String sql = null;
		Statement st = null;
		ResultSet rs = null;
		int maxVal = 0;
		try {
			conn = DBManager.getConnection();
			sql = "SELECT MAX(USER_ID) FROM USER_MASTER";
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

	
	public List<String> getGenreList() {
		Connection conn = null;
		String sql = null;
		Statement st = null;
		ResultSet rs = null;
		List<String> genreList=new ArrayList<String>(); 
		try {
			conn = DBManager.getConnection();
			sql = "SELECT * FROM GENRE";
			st = conn.createStatement();
			rs = st.executeQuery(sql);

			while (rs.next()) {
				genreList.add(rs.getString(1));
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

		return genreList;
	}
	
	
	
	public User createUser(User userObj)
	{
		PreparedStatement ps=null;
		Connection con=null;
		userObj.setUserId(getUserId());
		try {
			String sql="INSERT INTO USER_MASTER (First_Name, Last_Name, User_Name, Password, Genre) VALUES (?,?,?,?,?)";
			System.out.println("THE QUERY TO VALIDATE USER IS "+sql);
			con=DBManager.getConnection();
			ps=con.prepareStatement(sql);
			ps.setString(1, userObj.getfName());
			ps.setString(2, userObj.getlName());
			ps.setString(3, userObj.getuName());
			ps.setString(4, userObj.getuPasswd());
			ps.setString(5, getGenre(userObj.getGenre()));
			ps.execute();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			
		}
		finally{
			if(con!=null){
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(ps!=null){
				try {
					ps.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		updateGenre(userObj.getGenre(),userObj.getUserId());
		BoardManager bManager = new BoardManager();
		PinManager pManager=new PinManager();
		userObj.setFeedPinList(pManager.populateUserFeedList(userObj.getUserId()));
		userObj.setuBSuggestionList(bManager.populateSuggestedBoardList(userObj.getUserId()));
		return userObj;
		
	}

	public void updateGenre(List<String> genre, String uId) {
		PreparedStatement ps = null;
		Connection con = null;

		try {
			String sql = "INSERT INTO USERGENREMASTER (User_Id, Genre) VALUES (?,?)";
			System.out.println("THE QUERY TO VALIDATE USER IS " + sql);
			con = DBManager.getConnection();
			for (String genreV : genre) {
				ps = con.prepareStatement(sql);
				ps.setString(1, uId);
				ps.setString(2, genreV);
				ps.execute();
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

	public User loginUser(String uName, String uPassword) {
		PreparedStatement ps = null;
		Connection con = null;
		ResultSet rs = null;
		User userObj = null;
		try {
			String sql = "SELECT * FROM USER_MASTER WHERE USER_NAME='" + uName
					+ "' AND PASSWORD = '" + uPassword + "'";
			System.out.println("THE QUERY TO VALIDATE USER IS " + sql);
			con = DBManager.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			userObj = new User();

			while (rs.next()) {
				userObj.setUserId(rs.getString(1));
				userObj.setfName(rs.getString(2));
				userObj.setlName(rs.getString(3));
				userObj.setuName(rs.getString(4));
				userObj.setuPasswd(rs.getString(5));
				userObj.setrGenre(rs.getString(6));
			}
			
			userObj.setGenre(getUserGenreDetails(userObj.getUserId()));
			
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
		BoardManager bManager = new BoardManager();
		bManager.populateUserBoardList(userObj);
		userObj.setFollowedBoardList(bManager.populateFollowedBoardList(userObj
				.getUserId()));
		PinManager pManager=new PinManager();
		userObj.setFeedPinList(pManager.populateUserFeedList(userObj.getUserId()));
		userObj.setuBSuggestionList(bManager.populateSuggestedBoardList(userObj.getUserId()));
		userObj.setGenreList(getGenreList());
		return userObj;
	}

	public List<String> getUserGenreDetails(String userID)
	{
		List<String> genre=new ArrayList<String>();
		
		Connection conn = null;
		String sql = null;
		Statement st = null;
		ResultSet rs = null;
		int maxVal = 0;
		try {
			conn = DBManager.getConnection();
			sql = "SELECT GENRE FROM USERGENREMASTER WHERE USER_ID ="+userID;
			st = conn.createStatement();
			rs = st.executeQuery(sql);

			while (rs.next()) {
				genre.add(rs.getString("GENRE"));
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
		return genre;
	}
	
	public String getGenre(List<String> genre) {
		String gName = "";
		ArrayList<String> gList = (ArrayList<String>) genre;
		for (String genreN : gList) {
			gName += genreN + ",";
		}
		gName = gName.substring(0, gName.length() - 1);
		return gName;
	}
}