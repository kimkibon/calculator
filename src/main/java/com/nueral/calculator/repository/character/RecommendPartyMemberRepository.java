package com.nueral.calculator.repository.character;

import com.nueral.calculator.entity.character.RecommendParty;
import com.nueral.calculator.entity.character.RecommendPartyMember;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecommendPartyMemberRepository extends JpaRepository<RecommendPartyMember, RecommendParty> {
}