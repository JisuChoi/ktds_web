package kt.c.dao;

import java.util.List;

import kt.c.vo.BoardFileVO;
import kt.c.vo.BoardVO;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("boardDAO")
public class BoardDAO {
	@Autowired
	SqlSessionFactory sqlSessionFactory;

	public int selectBoardNo() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();

		try {
			return sqlSession.selectOne("kt.c.dao.BoardDAO.selectBoardNo");
			
		} catch(Exception e) {
			throw e;

		} finally {
			try {sqlSession.close();} catch (Exception e) {}
		}
	}

	public List<BoardVO> selectAll() throws Exception {
		// SqlSessionFactory 객체로부터 SqlSession 객체를 얻는다.
		// => SqlSession 객체는 맵퍼 파일에 있는 SQL문을 실행한다. => 물론 내부에서 JDBC를 사용하여 처리한다.
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		try {
			//첫 번째 파라미터: 맵퍼 파일에 정의된 네임스페이스이름 + . + SQL문 아이디
			//두 번째 파라미터: SQL문을 수행하는데 필요한 데이터를 객체에 담아서 넘긴다. 없으면 넘기지 않는다.
			return sqlSession.selectList("kt.c.dao.BoardDAO.selectAll");
			
		} catch(Exception e) {
			throw e;

		} finally {
			try {sqlSession.close();} catch (Exception e) {}
		}
	}

	public BoardVO selectByNo(int no) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();

		try {
			return sqlSession.selectOne("kt.c.dao.BoardDAO.selectByNo", no);
			
		} catch(Exception e) {
			throw e;

		} finally {
			try {sqlSession.close();} catch (Exception e) {}
		}
	}

	public void insert(BoardVO board) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		try {
			sqlSession.insert("kt.c.dao.BoardDAO.insert", board);
			sqlSession.commit();
			
		} catch(Exception e) {
			throw e;

		} finally {
			try {sqlSession.close();} catch (Exception e) {}
		}
	}

	public void updateViewCnt(int no) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		try {
			// 두 번째 파라미터 반드시 객체가 들어가야 한다.
			// JDK5에 추가된 기능: 기본 타입에 대해 Auto Boxing 기능 제공.
			// 기본형(byte,short,int,...) => 
			//					wrapper 객체(java.lang.Byte, java.lang.Short, ...)로 변환됨
			// int 값이 Integer 객체로 자동 포장되어 전달된다.
			sqlSession.update("kt.c.dao.BoardDAO.updateViewCnt", no /*new Integer(no)*/);
			
			// insert, update, delete인 경우 정상 실행했을 때 서버에 실행 결과를 적용할 것을 요청해야 한다.
			sqlSession.commit();
			
		} catch(Exception e) {
			throw e;

		} finally {
			try {sqlSession.close();} catch (Exception e) {}
		}
	}

	public void update(BoardVO board) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();

		try {
			sqlSession.update("kt.c.dao.BoardDAO.update", board);
			sqlSession.commit();
			
		} catch(Exception e) {
			throw e;

		} finally {
			try {sqlSession.close();} catch (Exception e) {}
		}
	}

	public void delete(int no) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();

		try {
			sqlSession.delete("kt.c.dao.BoardDAO.delete", no);
			sqlSession.commit();
			
		} catch(Exception e) {
			throw e;

		} finally {
			try {sqlSession.close();} catch (Exception e) {}
		}
	}

	public void insertFile(BoardFileVO fileVO) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		try {
			sqlSession.insert("kt.c.dao.BoardDAO.insertFile", fileVO);
			sqlSession.commit();
			
		} catch(Exception e) {
			throw e;

		} finally {
			try {sqlSession.close();} catch (Exception e) {}
		}		
	}

	public List<BoardFileVO> selectFileBoard(int boardNo) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();

		try {
			return sqlSession.selectList("kt.c.dao.BoardDAO.selectFileBoard", boardNo);
			
		} catch(Exception e) {
			throw e;

		} finally {
			try {sqlSession.close();} catch (Exception e) {}
		}
	}

	public void deleteFile(int boardNo) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();

		try {
			sqlSession.delete("kt.c.dao.BoardDAO.deleteFile", boardNo);
			sqlSession.commit();
			
		} catch(Exception e) {
			throw e;

		} finally {
			try {sqlSession.close();} catch (Exception e) {}
		}
	}
}
















