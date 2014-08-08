package kt.c.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import kt.c.util.ConnectionFactory;
import kt.c.util.JDBCClose;
import kt.c.vo.BoardFileVO;
import kt.c.vo.BoardVO;

public class BoardDAO {
	
public int selectBoardNo() {
		
		
		Connection con = new ConnectionFactory().getConnection();
		 
		 StringBuilder sql = new StringBuilder();
		 sql.append("select seq_t_board_no.nextval from dual");
		 int boardNo = 0;
		 PreparedStatement pstmt = null;
		 try {
			 pstmt = con.prepareStatement(sql.toString());
			 ResultSet rs = pstmt.executeQuery();
			 
			 rs.next();
			 boardNo = rs.getInt(1);
		 } catch(Exception e) {
			 e.printStackTrace();
		 } finally {
			 JDBCClose.close(con, pstmt);
		 }
		 
		 return boardNo;

}

	public List<BoardVO> selectAll() {
		
		List<BoardVO> list = new ArrayList<>();
		
		Connection con = new ConnectionFactory().getConnection();
		 
		 StringBuilder sql = new StringBuilder();
		 sql.append("select no, title, writer, ");
		 sql.append("    to_char(reg_date, 'yyyy-mm-dd') reg_date ");
		 sql.append(" from t_board ");
		 sql.append(" order by no desc ");
		 
		 PreparedStatement pstmt = null;
		 try {
			 pstmt = con.prepareStatement(sql.toString());
			 ResultSet rs = pstmt.executeQuery();
			 
			 while(rs.next()) {
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
			 
		 } catch(Exception e) {
			 e.printStackTrace();
		 } finally {
			 JDBCClose.close(con, pstmt);
		 }
		 
		 return list;
	}
	
	public BoardVO selectByNo(int no) {
		
		BoardVO board = new BoardVO();
		
		Connection con = new ConnectionFactory().getConnection();
		 StringBuilder sql = new StringBuilder();
		 sql.append("select no, title, writer, content, view_cnt, ");
		 sql.append("    to_char(reg_date, 'yyyy-mm-dd') reg_date ");
		 sql.append(" from t_board ");
		 sql.append(" where no = ? ");
		 
		 PreparedStatement pstmt = null;
		 
		 try {
			 pstmt = con.prepareStatement(sql.toString());
			 pstmt.setInt(1, no);
			 ResultSet rs = pstmt.executeQuery();
			 rs.next();
			 
			 board.setNo(no);
			 board.setTitle(rs.getString("title"));
			 board.setWriter(rs.getString("writer"));
			 board.setContent(rs.getString("content"));
			 board.setViewCnt(rs.getInt("view_cnt"));
			 board.setRegDate(rs.getString("reg_date"));
			 
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCClose.close(con, pstmt);
		}
		 
		return board;
	}
	
	public void insert(BoardVO board) {
		Connection con = new ConnectionFactory().getConnection();
		StringBuilder sql = new StringBuilder();
		sql.append("insert into t_board(no, title, writer, content )");
		sql.append("  values(?, ?, ?, ?) ");

		PreparedStatement pstmt = null;
		try {
			pstmt = con.prepareStatement(sql.toString());
			int index = 1;
			pstmt.setInt(index++, board.getNo());
			pstmt.setString(index++, board.getTitle());
			pstmt.setString(index++, board.getWriter());
			pstmt.setString(index++, board.getContent());

			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCClose.close(con, pstmt);
		}
	}
	
	public void updateViewCnt(int no) {
		Connection con = new ConnectionFactory().getConnection();
		StringBuilder sb = new StringBuilder();
		sb.append("update t_board ");
		sb.append("  set view_cnt = view_cnt + 1 ");
		sb.append(" where no = ? ");
		PreparedStatement pstmt = null;
		try {
			pstmt = con.prepareStatement(sb.toString());
			pstmt.setInt(1, no);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCClose.close(con, pstmt);
		}
	}
	
	public void update(BoardVO board) {
		
		Connection con = new ConnectionFactory().getConnection();
		String sql = "update t_board ";
		       sql += "  set title = ? ";
		       sql += "    , content = ? ";
		       sql += " where no = ? ";
		PreparedStatement pstmt = null;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, board.getTitle());
			pstmt.setString(2, board.getContent());
			pstmt.setInt(3, board.getNo());
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCClose.close(con, pstmt);
		}
	}
	
	public void delete(int no) {
		Connection con = new ConnectionFactory().getConnection();
		StringBuilder sql = new StringBuilder();
		sql.append("delete t_board ");
		sql.append(" where no = ? ");
		PreparedStatement pstmt = null;
		try {
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setInt(1, no);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCClose.close(con, pstmt);
		}
	}
	
	public void insertFile(BoardFileVO fileVO) {
		Connection con = new ConnectionFactory().getConnection();
		StringBuilder sql = new StringBuilder();
		sql.append("insert into t_board_file( ");
		sql.append("  no, board_no, file_ori_name, file_save_name, file_size) ");
		sql.append("  values(seq_t_board_file_no.nextval, ?, ?, ?, ?) ");

		PreparedStatement pstmt = null;
		try {
			pstmt = con.prepareStatement(sql.toString());
			int index = 1;
			pstmt.setInt(index++, fileVO.getBoardNo());
			pstmt.setString(index++, fileVO.getFileOriName());
			pstmt.setString(index++, fileVO.getFileSaveName());
			pstmt.setInt(index++, fileVO.getFileSize());
			
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCClose.close(con, pstmt);
		}
	}
	
	public List<BoardFileVO> selectFileBoard(int boardNo) {
		
		List<BoardFileVO> list = new ArrayList<>();
		
		Connection con = new ConnectionFactory().getConnection();
		PreparedStatement pstmt = null;
		
		try {
			
			StringBuilder sb = new StringBuilder();
			sb.append("select no, file_ori_name, file_save_name, ");
			sb.append("       file_size ");
			sb.append("  from t_board_file ");
			sb.append(" where board_no = ? ");
			
			pstmt = con.prepareStatement(sb.toString());
			pstmt.setInt(1, boardNo);
			
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
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
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCClose.close(con, pstmt);
		}
		
		return list;
	}
	
	public void deleteFile(int boardNo) {
		Connection con = new ConnectionFactory().getConnection();
		StringBuilder sql = new StringBuilder();
		sql.append("delete t_board_file ");
		sql.append(" where board_no = ? ");
		PreparedStatement pstmt = null;
		try {
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setInt(1, boardNo);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCClose.close(con, pstmt);
		}
	}
}
















