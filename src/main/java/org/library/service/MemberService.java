package org.library.service;

import org.library.model.Member;
import org.library.dto.MemberReserveHistoryDto;

import java.util.List;

public interface MemberService extends BaseService<Member, Integer> {

    Member loadByNationalId(String nationalId);
    List<MemberReserveHistoryDto> loadByNationalId1(String nationalId);
}
