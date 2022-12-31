package com.nueral.calculator.service.skin;

import com.nueral.calculator.dto.character.SkinSaveDto;
import com.nueral.calculator.repository.skin.SkinRepository;
import com.nueral.calculator.utils.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SkinService {
    @Autowired
    SkinRepository skinRepository;
    @Autowired
    private FileUtil fileUtil;

    public void saveSkins(List<SkinSaveDto> skinSaveDtoList) throws Exception {
        for (SkinSaveDto dto : skinSaveDtoList) {
            fileUtil.saveProfile(dto.getCharacterName(), dto.getType(), dto.getMultipartFile());
        }
    }
}
