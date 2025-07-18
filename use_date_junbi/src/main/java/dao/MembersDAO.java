package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import model.Member;
import model.MemberForm;

public class MembersDAO {
	private final String JDBC_URL = "jdbc:h2:tcp://localhost/~/example";
	private final String DB_USER = "sa";
	private final String DB_PASS = "";
	
	public List<Member> findAll() {
		List<Member> memberList = new ArrayList<>();
		
		try {
			Class.forName("org.h2.Driver");
		} catch (ClassNotFoundException e) {
			throw new IllegalStateException(
					"DBドライバーの読込に失敗しました");
		}
		
		try (Connection conn = 
				DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
			String sql = "SELECT id, name, birthday FROM members";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			ResultSet rs = pStmt.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				Date sqlBirthday = rs.getDate("birthday");
				LocalDate birthday = sqlBirthday.toLocalDate();
				Member member = new Member(id, name, birthday);
				memberList.add(member);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return memberList;
	}
	
	public boolean create(MemberForm memberForm) {
		String dateTxt = memberForm.getBirthday().replaceAll("/", "-");
		Date sqlBirthday = Date.valueOf(dateTxt);
		try {
			Class.forName("org.h2.Driver");
		} catch (ClassNotFoundException e) {
			throw new IllegalStateException(
					"DBドライバーの読込に失敗しました");
		}
		
		try (Connection conn = 
				DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
			String sql =
					"""
					INSERT INTO members (name, birthday) VALUES (?, ?)
					""";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, memberForm.getName());
			pStmt.setDate(2, sqlBirthday);
			int result = pStmt.executeUpdate();
			if (result != 1) {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public Member findMemberById(int id) {
		Member member = null;
		try {
			Class.forName("org.h2.Driver");
		} catch (ClassNotFoundException e) {
			throw new IllegalStateException(
					"DBドライバーの読込に失敗しました");
		}
		
		try (Connection conn = 
				DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
			String sql = 
					"""
					SELECT id, name, birthday FROM members
					WHERE id = ?
					""";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setInt(1, id);
			ResultSet rs = pStmt.executeQuery();
			if (rs.next()) {
				String name = rs.getString("name");
				Date sqlBirthday = rs.getDate("birthday");
				LocalDate birthday = sqlBirthday.toLocalDate();
				member = new Member(id, name, birthday);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return member;
	}
}
