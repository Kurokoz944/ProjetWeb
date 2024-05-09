package com.tracolab.backskeleton.services;

import com.tracolab.backskeleton.DAO.MessageDao;
import com.tracolab.backskeleton.models.Message;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class MessageService {
    private final MessageDao messageDao;

    public List<Message> findAll() {
        return messageDao.findAll();
    }
}
