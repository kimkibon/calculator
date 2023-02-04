package com.nueral.calculator.repository.epParty;

import com.nueral.calculator.entity.epParty.EpMember;
import com.nueral.calculator.entity.epParty.id.EpMemberId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EpMemberRepository extends JpaRepository<EpMember, EpMemberId> {
}
