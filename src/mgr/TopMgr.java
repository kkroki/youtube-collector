package mgr;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

import bean.TopBean;

public class TopMgr {

	private DBMgr pool;

	public TopMgr() {
		pool = DBMgr.getInstance();
	}

	public Vector<TopBean> getTopBean() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		Vector<TopBean> vlist = new Vector<>();
		try {
			con = pool.getConnection();
			sql = "select * from tbl_TopBean";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				TopBean bean = new TopBean();
				bean.setEntry(rs.getString("entry"));
				bean.setArtist(rs.getString("artist"));
				bean.setTitle(rs.getString("title"));
				bean.setRegdate(rs.getString("regdate"));

				vlist.addElement(bean);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt, rs);
		}
		return vlist;
	}

	
	//db저장
	public void insertTop() {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = null;
		try {
			con = pool.getConnection();
			sql = "insert into tbl_top100(entry,artist,title,regdate) values(?,?,?,now())";
			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, "entry");
			pstmt.setString(2, "artist");
			pstmt.setString(3, "title");

			pstmt.executeUpdate();
			return;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt);
		}
	}

}
