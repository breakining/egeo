package com.egeo.basics.user.api.write;

import java.util.List;

import com.egeo.basics.user.model.dto.UserPlatformDTO;

public interface UserPlatformWriteService {

    String saveWithTx(UserPlatformDTO dto);

    String updateWithTx(UserPlatformDTO dto);

    String deleteByUserIdAndPidWithTx(UserPlatformDTO dto);

    int delUserPlatformWithTx(UserPlatformDTO platformDTO);

    int setUserPlatformWithTx(List<String> setUserPlatform, Long id);

    String updateAllWithTx(UserPlatformDTO dto);

}
	