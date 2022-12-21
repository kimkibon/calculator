package com.nueral.calculator.repository.authKey;

import com.nueral.calculator.entity.authKey.AuthKey;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthKeyRepository extends JpaRepository<AuthKey , Integer> {
}
