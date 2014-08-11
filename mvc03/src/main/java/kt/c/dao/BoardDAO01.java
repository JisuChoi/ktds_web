package kt.c.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import kt.c.util.ConnectionFactory;
import kt.c.vo.BoardFileVO;
import kt.c.vo.BoardVO;

public class BoardDAO01 {

	ConnectionFactory connectionFactory;

	public void setConnectionFactory(ConnectionFactory connectionFactory) {
		this.connectionFactory = connectionFactory;
	}

	public int selectBoardNo() throws Exception {

		StringBuilder sql = new StringBuilder();
		sql.append("select seq_t_board_no.nextval from dual");
		int boardNo = 0;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = connectionFactory.getConnection();
			pstmt = con.prepareStatement(sql.toString());
			rs = pstmt.executeQuery();

			rs.next();
			boardNo = rs.getInt(1);
			return boardNo;
			
		} catch (Exception e) {
			throw e;
		} finally {
			try {
				rs.close();
				pstmt.close();
				connectionFactory.returnConnection(con);
			} catch (Exception e) {
			}
		}
	}

	public List<BoardVO> selectAll() throws Exception {

		List<BoardVO> list = new ArrayList<>();

		StringBuilder sql = new StringBuilder();
		sql.append("select no, title, writer, ");
		sql.append("    to_char(reg_date, 'yyyy-mm-dd') reg_date ");
		sql.append(" from t_board ");
		sql.append(" order by no desc ");

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = connectionFactory.getConnection();
			pstmt = con.prepareStatement(sql.toString());
			rs = pstmt.executeQuery();

			while (rs.next()) {
				int no = rs.getInt("no");
				String title = rs.getString("title");
				String writer = rs.getString("writer");
				String regDate = rs.getString("reg_date");

				BoardVO board = new BoardVO();
				board.setNo(no);
				board.setTitle(title);
				board.setWriter(writer);
				board.setRegDate(regDate);

				list.add(board);
			}
			return list;

		} catch (Exception e) {
			throw e;
		} finally {
			try {
				rs.close();
				pstmt.close();
				connectionFactory.returnConnection(con);
			} catch (Exception e) {
			}
		}
	}

	public BoardVO selectByNo(int no) throws Exception {

		BoardVO board = new BoardVO();

		StringBuilder sql = new StringBuilder();
		sql.append("select no, title, writer, content, view_cnt, ");
		sql.append("    to_char(reg_date, 'yyyy-mm-dd') reg_date ");
		sql.append(" from t_board ");
		sql.append(" where no = ? ");

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = connectionFactory.getConnection();
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setInt(1, no);
			rs = pstmt.executeQuery();
			rs.next();

			board.setNo(no);
			board.setTitle(rs.getString("title"));
			board.setWriter(rs.getString("writer"));
			board.setContent(rs.getString("content"));
			board.setViewCnt(rs.getInt("view_cnt"));
			board.setRegDate(rs.getString("reg_date"));

			return board;
		} catch (Exception e) {
			throw e;
		} finally {
			try {
				rs.close();
				pstmt.close();
				connectionFactory.returnConnection(con);
			} catch (Exception e) {
			}
		}
	}

	public void insert(BoardVO board) throws Exception {

		StringBuilder sql = new StringBuilder();
		sql.append("insert into t_board(no, title, writer, content )");
		sql.append("  values(?, ?, ?, ?) ");

		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = connectionFactory.getConnection();
			pstmt = con.prepareStatement(sql.toString());
			int index = 1;
			pstmt.setInt(index++, board.getNo());
			pstmt.setString(index++, board.getTitle());
			pstmt.setString(index++, board.getWriter());
			pstmt.setString(index++, board.getContent());
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			throw e;
		} finally {
			try {
				pstmt.close();
				connectionFactory.returnConnection(con);
			} catch (Exception e) {
			}
		}
	}

	public void updateViewCnt(int no) throws Exception {

		StringBuilder sb = new StringBuilder();
		sb.append("update t_board ");
		sb.append("  set view_cnt = view_cnt + 1 ");
		sb.append(" where no = ? ");

		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = connectionFactory.getConnection();
			pstmt = con.prepareStatement(sb.toString());
			pstmt.setInt(1, no);
			pstmt.executeUpdate();
		} catch (Exception e) {
			throw e;
		} finally {
			try {
				pstmt.close();
				connectionFactory.returnConnection(con);
			} catch (Exception e) {
			}
		}
	}

	public void update(BoardVO board) throws Exception {

		String sql = "update t_board ";
		sql += "  set title = ? ";
		sql += "    , content = ? ";
		sql += " where no = ? ";

		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = connectionFactory.getConnection();
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, board.getTitle());
			pstmt.setString(2, board.getContent());
			pstmt.setInt(3, board.getNo());
			pstmt.executeUpdate();
		} catch (Exception e) {
			throw e;
		} finally {
			try {
				pstmt.close();
				connectionFactory.returnConnection(con);
			} catch (Exception e) {
			}
		}
	}

	public void delete(int no) throws Exception {

		StringBuilder sql = new StringBuilder();
		sql.append("delete t_board ");
		sql.append(" where no = ? ");

		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = connectionFactory.getConnection();
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setInt(1, no);
			pstmt.executeUpdate();
		} catch (Exception e) {
			throw e;
		} finally {
			try {
				pstmt.close();
				connectionFactory.returnConnection(con);
			} catch (Exception e) {
			}
		}
	}

	public void insertFile(BoardFileVO fileVO) throws Exception {

		StringBuilder sql = new StringBuilder();
		sql.append("insert into t_board_file( ");
		sql.append("  no, board_no, file_ori_name, file_save_name, file_size) ");
		sql.append("  values(seq_t_board_file_no.nextval, ?, ?, ?, ?) ");

		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = connectionFactory.getConnection();
			pstmt = con.prepareStatement(sql.toString());
			int index = 1;
			pstmt.setInt(index++, fileVO.getBoardNo());
			pstmt.setString(index++, fileVO.getFileOriName());
			pstmt.setString(index++, fileVO.getFileSaveName());
			pstmt.setInt(index++, fileVO.getFileSize());

			pstmt.executeUpdate();
		} catch (Exception e) {
			throw e;
		} finally {
			try {
				pstmt.close();
				connectionFactory.returnConnection(con);
			} catch (Exception e) {
			}
		}
	}

	public List<BoardFileVO> selectFileBoard(int boardNo) throws Exception {

		List<BoardFileVO> list = new ArrayList<>();

		StringBuilder sb = new StringBuilder();
		sb.append("select no, file_ori_name, file_save_name, ");
		sb.append("       file_size ");
		sb.append("  from t_board_file ");
		sb.append(" where board_no = ? ");

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = connectionFactory.getConnection();
			pstmt = con.prepareStatement(sb.toString());
			rs = pstmt.executeQuery();
			pstmt.setInt(1, boardNo);

			while (rs.next()) {
				int no = rs.getInt("no");
				String fileOriName = rs.getString("file_ori_name");
				String fileSaveName = rs.getString("file_save_name");
				int fileSize = rs.getInt("file_size");

				BoardFileVO fileVO = new BoardFileVO();
				fileVO.setNo(no);
				fileVO.setFileOriName(fileOriName);
				fileVO.setFileSaveName(fileSaveName);
				fileVO.setFileSize(fileSize);
				list.add(fileVO);
			}
			return list;

		} catch (Exception e) {
			throw e;
		} finally {
			try {
				rs.close();
				pstmt.close();
				connectionFactory.returnConnection(con);
			} catch (Exception e) {
			}
		}

	}

	public void deleteFile(int boardNo) throws Exception {

		StringBuilder sql = new StringBuilder();
		sql.append("delete t_board_file ");
		sql.append(" where board_no = ? ");

		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = connectionFactory.getConnection();
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setInt(1, boardNo);
			pstmt.executeUpdate();
		} catch (Exception e) {
			throw e;
		} finally {
			try {
				pstmt.close();
				connectionFactory.returnConnection(con);
			} catch (Exception e) {
			}
		}
	}
}
