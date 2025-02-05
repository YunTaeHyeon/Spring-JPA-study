package com.project.carrot.config;

import com.project.carrot.Service.MemberItemService;
import com.project.carrot.Service.MemberService;
import com.project.carrot.repository.JPAMemberItemRepository;
import com.project.carrot.repository.JPAMemberRepository;
import com.project.carrot.repository.MemberItemRepository;
import com.project.carrot.repository.MemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

@Configuration
public class SpringConfig {

    private final DataSource dataSource;
    private final EntityManager em;

    public SpringConfig(DataSource dataSource, EntityManager em) {
        this.dataSource = dataSource;
        this.em = em;
    }


    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository(){
        return new JPAMemberRepository(em);
    }

    @Bean
    public MemberItemService memberItemService(){return new MemberItemService(memberItemRepository());}

    @Bean
    public MemberItemRepository memberItemRepository(){return new JPAMemberItemRepository(em);}
    }
