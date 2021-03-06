package com.gureev.webapp;


import com.gureev.webapp.model.*;
import com.gureev.webapp.repos.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringWebApplication {

    private InitDatabaseUtil initDatabaseUtil = new InitDatabaseUtil();


    public static void main(String[] args) {
        SpringApplication.run(SpringWebApplication.class, args);
    }


    @Bean
    public CommandLineRunner init(cServiceSectionRepo cServiceSectionRepo,
                                  cServiceClassRepo cServiceClassRepo,
                                  cCompRightNormRepo cCompRightNormRepo,
                                  sAddressRepo sAddressRepo,
                                  sCompanyRepo sCompanyRepo) {
        return args -> {

            //разделы
            for (cServiceSection ss : initDatabaseUtil.getSs()) {
                cServiceSectionRepo.save(ss);
            }

            //классы
            for (cServiceClass sc : initDatabaseUtil.getSc()) {
                cServiceClassRepo.save(sc);
            }

            //правовые нормы предприятия
            for (cCompRightNorm crn : initDatabaseUtil.getCrn()) {
                cCompRightNormRepo.save(crn);
            }

            //адреса компаний
            for (sAddress sAddress : initDatabaseUtil.getAdr()) {
                sAddressRepo.save(sAddress);
            }

            //компании
            for (sCompany comp : initDatabaseUtil.getComp()) {
                sCompanyRepo.save(comp);
            }

        };
    }


}
