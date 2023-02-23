package com.nueral.calculator.service.frontPage;

import com.nueral.calculator.repository.frontPage.FrontPageRepository;
import com.nueral.calculator.utils.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FrontPageService {
    @Autowired
    FrontPageRepository frontPageRepository;
    @Autowired
    FileUtil fileUtil;
}
