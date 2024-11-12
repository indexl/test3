package com.example.demo.repository;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.demo.vo.BookStoreVO;

@Mapper
public interface BookStoreRepository {

	@Delete("""
			TRUNCATE TABLE bookStore
			""")
	void truncateTable();

	@Insert("""
			INSERT INTO bookStore
				SET `name` = #{name}
			""")
	void insertStore(String name);

	@Select("""
			SELECT *
				FROM bookStore
			""")
	List<BookStoreVO> selectBookStores();

	@Update("""
			UPDATE bookStore
				SET `name` = #{modifyName}
				WHERE id = #{id}
			""")
	void modifyStoreName(int id, String modifyName);

}