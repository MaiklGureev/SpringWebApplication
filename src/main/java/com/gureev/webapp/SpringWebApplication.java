package com.gureev.webapp;

import com.gureev.webapp.domain.*;
import com.gureev.webapp.repos.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

//            //разделы
//            for (cServiceSection serviceSection : initDatabaseUtil.getcServiceSections()) {
//                cServiceSectionRepo.save(serviceSection);
//            }
//
//            //классы
//            for (cServiceClass cServiceClass : initDatabaseUtil.getcServiceClasses()) {
//                cServiceClassRepo.save(cServiceClass);
//            }
//
//            //правовые нормы предприятия
//            for (cCompRightNorm cCompRightNorm : initDatabaseUtil.getcCompRightNorms()) {
//                cCompRightNormRepo.save(cCompRightNorm);
//            }
//
//            //адреса компаний
//            for (sAddress sAddress : initDatabaseUtil.getsAddresses()) {
//                sAddressRepo.save(sAddress);
//            }
//
//            //компании
//            for (sCompany sCompany : initDatabaseUtil.getsCompanies()) {
//                sCompanyRepo.save(sCompany);
//            }
            sAddress address10 = new sAddress(10, new AddressJsonb("Бубнова", "11", "9"));
            cCompRightNorm compRightNorm3 = new cCompRightNorm("ООО");
            compRightNorm3.setId(3);
            cServiceSection section4 = new cServiceSection(4, "Строительство");
            sCompany sCompany = new sCompany("СройДом", address10, "635546", compRightNorm3, section4);
            sCompany.setId(11l);
            sCompanyRepo.delete(sCompany);

        };
    }


}
