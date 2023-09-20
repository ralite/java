package fr.hb.ewan.plages.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import fr.hb.ewan.plages.business.File;
import fr.hb.ewan.plages.dao.FileDao;
import fr.hb.ewan.plages.service.FileService;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class FileServiceImpl implements FileService {

	private FileDao fileDao;
	
	@Override
	public List<File> recupererFiles() {
		return fileDao.findAll();
	}

}
