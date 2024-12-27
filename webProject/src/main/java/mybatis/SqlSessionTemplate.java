package mybatis;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SqlSessionTemplate {
	
	public static SqlSession getSqlSession() {
		/*[참고]
		SqlSessionFactory 객체의 openSession()을 호출해서 SqlSession을 얻는다.
		SqlSession은 MyBatis에서 실제 SQL 실행을 담당하는 컴포넌트이다. 
		즉 SQL을 실행하려면 SqlSession이 필요하며, 이 객체가 JDBC 드라이버를 사용한다.
		*/
		
		SqlSession session = null;

		// 해당 리소스 경로(xml파일) 작성	
		String resource = "config/mybatis-config.xml";
		try{
			Reader reader = Resources.getResourceAsReader(resource);
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
			// openSession 매개변수의 값으로 자동 커밋 여부를 지정.
			session = sqlSessionFactory.openSession(true);
			reader.close();
		}catch(IOException e){
			e.printStackTrace();
		}

		return session; // 생성된 SqlSession 리턴
	}
}