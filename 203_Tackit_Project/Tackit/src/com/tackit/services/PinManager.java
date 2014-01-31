package com.tackit.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.tackit.DTO.Board;
import com.tackit.DTO.Pin;
import com.tackit.utils.DBManager;

public class PinManager {

	//Populate pins for a particular board
	public List<Pin> populateUserBoardPinList(String bID) {

		PreparedStatement ps = null;
		Connection con = null;
		ResultSet rs = null;
		Pin pinObj = null;
		List<Pin> pList = new ArrayList<Pin>();
		try {
			String sql = "SELECT * FROM PIN_MGMT WHERE BOARD_ID ='" + bID
					+ "' ORDER BY DATEPOSTED DESC";
			System.out.println("THE QUERY TO VALIDATE USER IS " + sql);
			con = DBManager.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {
				pinObj = new Pin();
				pinObj.setImgLocation(rs.getString("Img_Src"));
				pinObj.setPinDescription(rs.getString("Description"));
				pinObj.setPinName(rs.getString("Name"));
				pinObj.setPinLink(rs.getString("Link"));
				pList.add(pinObj);
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
		return pList;
	}
	
	//Populate the pins added by user
	public List<Pin> populateUserPinList(String uID) {

		PreparedStatement ps = null;
		Connection con = null;
		ResultSet rs = null;
		Pin pinObj = null;
		List<Pin> pList = new ArrayList<Pin>();
		try {
			String sql = "SELECT * FROM PIN_MGMT WHERE USER_ID ='" + uID
					+ "' ORDER BY DATEPOSTED DESC";
			System.out.println("THE QUERY TO VALIDATE USER IS " + sql);
			con = DBManager.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {
				pinObj = new Pin();
				pinObj.setImgLocation(rs.getString("Img_Src"));
				pinObj.setPinDescription(rs.getString("Description"));
				pinObj.setPinName(rs.getString("Name"));
				pinObj.setPinLink(rs.getString("Link"));
				pList.add(pinObj);
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
		return pList;
	}
	
	//populate the pins to be seen on dashboard based on the Genre selected by user at signup
	public List<Pin> populateUserFeedList(String uID) {

		PreparedStatement ps = null;
		Connection con = null;
		ResultSet rs = null;
		Pin pinObj = null;
		List<Pin> pList = new ArrayList<Pin>();
		try {
			String sql = "SELECT * FROM PIN_MGMT WHERE GENRE in (SELECT GENRE FROM USERGENREMASTER WHERE USER_ID="
					+ uID
					+ ") AND USER_ID NOT IN ("
					+ uID
					+ ")ORDER BY DATEPOSTED DESC";

			System.out.println("THE QUERY TO VALIDATE USER IS " + sql);
			con = DBManager.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {
				pinObj = new Pin();
				
				pinObj.setImgLocation(rs.getString("Img_Src"));
				pinObj.setPinDescription(rs.getString("Description"));
				pinObj.setPinName(rs.getString("Name"));
				pinObj.setPinLink(rs.getString("Link"));
				pinObj.setpGenre(rs.getString("Genre"));
				pList.add(pinObj);
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
		System.out.println("The size of data is " + pList.size());
		return pList;
	}

	//Populate pins for dashboard for private board followed or created
	public List<Pin> populateUserPvtFeedList(String uID) {

		PreparedStatement ps = null;
		Connection con = null;
		ResultSet rs = null;
		Pin pinObj = null;
		List<Pin> pList = new ArrayList<Pin>();
		try {
			String sql = "SELECT * FROM tackit.PIN_MGMT WHERE GENRE in (SELECT GENRE FROM USERGENREMASTER WHERE USER_ID='"
					+ uID
					+ "') AND BOARD_ID IN (SELECT BOARD_ID FROM tackit.BOARD_MGMT WHERE BOARD_TYPE = 0) ORDER BY DATEPOSTED DESC";
			System.out.println("THE QUERY TO VALIDATE USER IS " + sql);
			con = DBManager.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {
				pinObj = new Pin();
				pinObj.setImgLocation(rs.getString("Img_Src"));
				pinObj.setPinDescription(rs.getString("Description"));
				pinObj.setPinName(rs.getString("Name"));
				pinObj.setPinLink(rs.getString("Link"));
				pList.add(pinObj);
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
		return pList;
	}

	// public void createPin(Pin pin,String uId,String bId)
	// {
	// PreparedStatement ps = null;
	// Connection con = null;
	//
	// try {
	// String sql =
	// "INSERT INTO PIN_MGMT (USER_ID,BOARD_ID,PIN_ID,GENRE, BOARD_NAME, DESCRIPTION,BOARD_TYPE) VALUES (?,?,?,?,?,?)";
	// System.out.println("THE QUERY TO VALIDATE USER IS " + sql);
	// con = DBManager.getConnection();
	// ps = con.prepareStatement(sql);
	// ps.setString(1, userId);
	// ps.setString(2, bId);
	// ps.setString(3, boardObj.getBoardGenre());
	// ps.setString(4, boardObj.getBoardName());
	// ps.setString(5, boardObj.getBoardDesc());
	// ps.setInt(6, boardObj.getBoardType());
	// ps.execute();
	//
	// } catch (Exception e) {
	// // TODO: handle exception
	// e.printStackTrace();
	//
	// } finally {
	// if (con != null) {
	// try {
	// con.close();
	// } catch (SQLException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	// }
	// if (ps != null) {
	// try {
	// ps.close();
	// } catch (SQLException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	// }
	// }
	//
	// }

//	public List<Pin> populateGenreBoardPinList(String genre) {
//
//		PreparedStatement ps = null;
//		Connection con = null;
//		ResultSet rs = null;
//		Pin pinObj = null;
//		List<Pin> pList = new ArrayList<Pin>();
//		try {
//			String sql = "SELECT * FROM PIN_MGMT WHERE GENRE ='" + genre
//					+ "' ORDER BY DATEPOSTED DESC";
//			System.out.println("THE QUERY TO VALIDATE USER IS " + sql);
//			con = DBManager.getConnection();
//			ps = con.prepareStatement(sql);
//			rs = ps.executeQuery();
//
//			while (rs.next()) {
//				pinObj = new Pin();
//				pinObj.setImgLocation(rs.getString("Img_Src"));
//				pinObj.setPinDescription(rs.getString("Description"));
//				pinObj.setPinName(rs.getString("Name"));
//				pinObj.setPinLink(rs.getString("Link"));
//				pList.add(pinObj);
//			}
//
//		} catch (Exception e) {
//			// TODO: handle exception
//			e.printStackTrace();
//
//		} finally {
//			if (con != null) {
//				try {
//					con.close();
//				} catch (SQLException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			}
//			if (rs != null) {
//				try {
//					rs.close();
//				} catch (SQLException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			}
//			if (ps != null) {
//				try {
//					ps.close();
//				} catch (SQLException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			}
//		}
//		return pList;
//	}

	//get pinid for new pin entries
	public String generatePinId() {
		Connection conn = null;
		String sql = null;
		Statement st = null;
		ResultSet rs = null;
		int maxVal = 0;
		try {
			conn = DBManager.getConnection();
			sql = "SELECT MAX(PIN_ID) FROM PIN_MGMT";
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

	//Creating a new pin
	public boolean createNewPin(Pin pinObj) {
		boolean result = true;
		PreparedStatement ps = null;
		Connection con = null;
		String pId = generatePinId();
		try {
			String sql = "INSERT INTO PIN_MGMT (USER_ID,BOARD_ID,PIN_ID,LINK,IMG_SRC,DESCRIPTION,NAME,GENRE) VALUES (?,?,?,?,?,?,?,(SELECT GENRE FROM BOARD_MGMT WHERE BOARD_ID = "+pinObj.getPinBid()+" ))";

			con = DBManager.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, pinObj.getPinUid());
			ps.setString(2, pinObj.getPinBid());
			ps.setString(3, pId);
			ps.setString(4, pinObj.getPinLink());
			ps.setString(5, pinObj.getImgLocation());
			ps.setString(6, pinObj.getPinDescription());
			ps.setString(7, pinObj.getPinName());
			
			System.out
					.println("THE QUERY TO VALIDATE USER IS " + ps.toString());
			result = ps.execute();

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
		return result;
	}
}
