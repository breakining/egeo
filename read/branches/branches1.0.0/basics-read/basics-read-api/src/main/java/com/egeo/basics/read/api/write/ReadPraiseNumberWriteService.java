package com.egeo.basics.read.api.write;

import com.egeo.basics.read.model.dto.ReadPraiseNumberDTO;

public interface ReadPraiseNumberWriteService {

	int decreaseReadPraiseNumber(ReadPraiseNumberDTO readPraiseNumberDTO2, int i);

	int increaseReadPraiseNumber(ReadPraiseNumberDTO readPraiseNumberDTO2, int i);

	int savereadPraiseNumber(ReadPraiseNumberDTO readPraiseNumberDTO);



}
