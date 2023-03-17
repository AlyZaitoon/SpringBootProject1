package com.siemens.proj.dao;

import com.siemens.proj.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher,Long> {

    Teacher findTeacherByMail(String mail);
    List<Teacher> findTeachersByFirstNameContainingOrLastNameContaining(String firstname, String lastname);

    void deleteById(Long Id);

//    @Query(value="insert into Teacher VALUES(:id,:fname,:lname,:mail)",nativeQuery = true)
//    void addTeacher(@Param("id")Long id,@Param("fname")String fname,@Param("lname")String lname,@Param("mail") String mail);


}
