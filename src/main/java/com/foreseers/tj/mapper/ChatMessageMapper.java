package com.foreseers.tj.mapper;

import com.foreseers.tj.model.ChatMessage;
import com.foreseers.tj.model.ChatMessageExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ChatMessageMapper {
    long countByExample(ChatMessageExample example);

    int deleteByExample(ChatMessageExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ChatMessage record);

    int insertSelective(ChatMessage record);

    List<ChatMessage> selectByExample(ChatMessageExample example);

    ChatMessage selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ChatMessage record, @Param("example") ChatMessageExample example);

    int updateByExample(@Param("record") ChatMessage record, @Param("example") ChatMessageExample example);

    int updateByPrimaryKeySelective(ChatMessage record);

    int updateByPrimaryKey(ChatMessage record);

    
    //批量更新聊天记录
	void insertBatch(List<ChatMessage> chatMessageList);
}