package oit.is.z0256.kaizi.janken.model;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface MatchMapper{
  @Select("SELECT * from matches")
  ArrayList<Match> selectAllMatch();

  @Select("SELECT * from matches where is_active = #{is_active}")
  Match selectByIs_active(boolean is_active);

  @Insert("INSERT INTO matches (user_1,user_2,user_1_hand,user_2_hand) VALUES (#{user_1},#{user_2},#{user_1_hand},#{user_2_hand});")
  @Options(useGeneratedKeys = true, keyColumn = "id", keyProperty = "id")
  void insertMatch(Match match);

}
