package com.tracolab.backskeleton.services;

import com.tracolab.backskeleton.DAO.MessagerieDao;
import com.tracolab.backskeleton.models.Messagerie;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class MessagerieService {
    private final MessagerieDao messagerieDao;

    public List<Messagerie> findAll() {
        return messagerieDao.findAll();
    }
}
