package com.example.demo.domain.service;

import com.example.demo.domain.Member;
import com.example.demo.domain.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service @Slf4j
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService{

    private final MemberRepository memberRepository;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(String name) throws Exception {
        memberRepository.save(Member.builder()
                .name(name)
                .build());

        if (name.equals("커밋")) {
//            log.info("Exception 발생 기본 트랜잭션 전략상 커밋 O, 롤백 X");
            log.info("rollback 전략 적용 Exception 발생시 커밋 X, 롤백 O");
            throw new Exception();
        } else if (name.equals("롤백1")) {
            log.info("RuntimeException 발생 기본 트랜잭션 전략상 커밋 X, 롤백 O");
            throw new RuntimeException();
        } else if (name.equals("롤백2")) {
            log.info("Error 발생 기본 트랜잭션 전략상 커밋 X, 롤백 O");
            throw new IllegalAccessError();
        }

        log.info("아무 예외도 발생하지 않고 비즈니스 로직 수행 성공");

    }
}
