package com.mattiz.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.mattiz.Exception.MattizException;
import com.mattiz.beans.AuthorDTO;

public class MattizDAO {
	private static DataSource ds;

	public static final String DATASOURCE_LOOKUP_NAME = "java:dbpool";

	public MattizDAO() {
		try {
			InitialContext ctx = null;
			ctx = new InitialContext();
			ds = (DataSource) ctx.lookup(DATASOURCE_LOOKUP_NAME);
		} catch (javax.naming.NamingException jnx) {
			// log an error declaring connection could not be created
			// object MattizDAO could not be initialized
		}
	}

	public void addAuthor(AuthorDTO author) throws MattizException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = ds.getConnection();
			String qry = "insert into authors values(?,?);";
			ps = conn.prepareStatement(qry);
			ps.setString(1, author.getIsbnCode());
			ps.setString(2, author.getAuthor());
			// other examples of setters for prepared statement below:
			// ps.setInt(3, 0);
			// ps.setDate(4, new java.sql.Date(1 - 1 - 2007));
			// ps.setTime(5, new java.sql.Time(1 - 1 - 2007));
			// ps.setDouble(6, 1);
			ps.execute();// in case this is an insert/ update
			// PreparedStatement ps, ResultSet rs, Connection conn can be reused
			// with new values for another query
		} catch (SQLException e) {
			throw new MattizException();
		} finally {
			closeStatements(rs, ps, conn);
		}
	}

	public ArrayList getAuthors(int start, int end) throws MattizException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList authorsList;
		try {
			conn = ds.getConnection();
			String qry = "select * from authors;";
			ps = conn.prepareStatement(qry);
			rs = ps.executeQuery();// in case this is a select
			authorsList = new ArrayList();
			int counter = 0;
			while (rs.next()) {
				counter++;// loop till counter>=start
				if (counter >= start && counter <= end) {
					AuthorDTO authorDTO = new AuthorDTO(rs
							.getString("isbn_code"));
					authorDTO.setAuthor(rs.getString("author"));
					authorsList.add(authorDTO);
				} else if (counter > end) {// break out of loop when
					// counter>end
					break;
				}
			}
			// PreparedStatement ps, ResultSet rs, Connection conn can be reused
			// for another query
		} catch (SQLException e) {
			throw new MattizException();
		} finally {
			closeStatements(rs, ps, conn);
		}
		return authorsList;
	}

	public int getNumberOfRows() throws MattizException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int rowCount = 0;
		try {
			conn = ds.getConnection();
			String qry = "select count(*) from authors;";
			ps = conn.prepareStatement(qry);
			rs = ps.executeQuery();
			if (rs.next()) {
				rowCount = rs.getInt(1);
			}
		} catch (SQLException e) {
			throw new MattizException();
		} finally {
			closeStatements(rs, ps, conn);
		}
		return rowCount;
	}

	private void closeStatements(ResultSet rs, PreparedStatement ps,
			Connection conn) throws MattizException {
		if (rs != null) {
			try {
				rs.close();
			} catch (Exception e) {
				throw new MattizException();
			}
			rs = null;
		}
		if (ps != null) {
			try {
				ps.close();
			} catch (Exception e) {
				throw new MattizException();
			}
			ps = null;
		}
		if (conn != null) {
			try {
				conn.close();
			} catch (Exception e) {
				throw new MattizException();
			}
			conn = null;
		}
	}
}
