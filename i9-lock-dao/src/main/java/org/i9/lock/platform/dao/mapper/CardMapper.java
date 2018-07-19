package org.i9.lock.platform.dao.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.i9.lock.platform.model.Card;
import org.i9.lock.platform.model.CardExample;

public interface CardMapper {
    int countByExample(CardExample example);

    int deleteByExample(CardExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Card record);

    int insertSelective(Card record);

    List<Card> selectByExample(CardExample example);

    Card selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Card record, @Param("example") CardExample example);

    int updateByExample(@Param("record") Card record, @Param("example") CardExample example);

    int updateByPrimaryKeySelective(Card record);

    int updateByPrimaryKey(Card record);

	List<Card> getAllCard(Long lockId);

	List<Integer> selectExistOrderNumber(Long lockId);
}