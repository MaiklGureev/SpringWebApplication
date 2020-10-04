package com.gureev.webapp;

import com.gureev.webapp.domain.*;

import java.util.ArrayList;
import java.util.List;

public class InitDatabaseUtil {
    
    private List<cServiceSection> cServiceSections = new ArrayList<>();
    private List<cCompRightNorm> cCompRightNorms = new ArrayList<>();
    private List<cServiceClass> cServiceClasses = new ArrayList<>();

    private List<sAddress> sAddresses = new ArrayList<>();
    private List<sCompany> sCompanies = new ArrayList<>();
    
    public InitDatabaseUtil() {
        initDatabase();
    }

    public   void initDatabase() {
        cServiceSection section =  new cServiceSection(1,"Сельское, лесное хозяйство, охота, рыболовство и рыбоводство");
        cServiceSection section2 =  new cServiceSection(2,"Добыча полезных ископаемых");
        cServiceSection section3 =  new cServiceSection(3,"Обрабатывающие производства");
        cServiceSection section4 =  new cServiceSection(4,"Строительство");
        cServiceSection section5 =  new cServiceSection(5,"Образование");
        cServiceSection section6 =  new cServiceSection(6,"Предоставление прочих видов услуг");

        cServiceSections.add(section);
        cServiceSections.add(section2);
        cServiceSections.add(section3);
        cServiceSections.add(section4);
        cServiceSections.add(section5);
        cServiceSections.add(section6);

        cCompRightNorm compRightNorm = new cCompRightNorm("ОАО");
        cCompRightNorm compRightNorm2 = new cCompRightNorm("ПАО");
        cCompRightNorm compRightNorm3 = new cCompRightNorm("ООО");
        cCompRightNorm compRightNorm4 = new cCompRightNorm("ЗАО");

        cCompRightNorms.add(compRightNorm);
        cCompRightNorms.add(compRightNorm2);
        cCompRightNorms.add(compRightNorm3);
        cCompRightNorms.add(compRightNorm4);

        sAddress address = new sAddress(1,new AddressJsonb("Московское шоссе","101","25"));
        sAddress address2 = new sAddress(2,new AddressJsonb("Гая","23","1"));
        sAddress address3 = new sAddress(3,new AddressJsonb("Лукачёва","62","6"));
        sAddress address4 = new sAddress(4,new AddressJsonb("Лукачёва","62","10"));
        sAddress address5 = new sAddress(5,new AddressJsonb("Революционная","80","3"));
        sAddress address6 = new sAddress(6,new AddressJsonb("Революционная","45","66"));
        sAddress address7 = new sAddress(7,new AddressJsonb("Аврора","45","66"));
        sAddress address8 = new sAddress(8,new AddressJsonb("Аврора","45","50"));
        sAddress address9 = new sAddress(9,new AddressJsonb("Аврора","45","22"));
        sAddress address10 = new sAddress(10,new AddressJsonb("Бубнова","11","9"));

        sAddresses.add(address);
        sAddresses.add(address2);
        sAddresses.add(address3);
        sAddresses.add(address4);
        sAddresses.add(address5);
        sAddresses.add(address6);
        sAddresses.add(address7);
        sAddresses.add(address8);
        sAddresses.add(address9);
        sAddresses.add(address10);

        cServiceClasses.add(new cServiceClass(1,section,"01","Растениеводство и животноводство, охота и предоставление соответствующих услуг в этих областях"));
        cServiceClasses.add(new cServiceClass(2,section,"01.11.11","Выращивание пшеницы"));
        cServiceClasses.add(new cServiceClass(3,section,"01.11.12","Выращивание ячменя"));
        cServiceClasses.add(new cServiceClass(4,section,"01.13.31","Выращивание картофеля"));
        cServiceClasses.add(new cServiceClass(5,section,"01.14","Выращивание сахарного тростника"));

        cServiceClasses.add(new cServiceClass(6,section4,"41","Строительство зданий"));
        cServiceClasses.add(new cServiceClass(7,section4,"41.1","Разработка строительных проектов"));

        cServiceClasses.add(new cServiceClass(8,section5,"85.30","Обучение профессиональное"));
        cServiceClasses.add(new cServiceClass(9,section5,"85.41","Образование дополнительное детей и взрослых"));

        cServiceClasses.add(new cServiceClass(10,section2,"05.10","Добыча и обогащение угля и антрацита"));
        cServiceClasses.add(new cServiceClass(11,section2,"05.10.11","Добыча антрацита открытым способом"));
        cServiceClasses.add(new cServiceClass(12,section2,"05.10.2","Обогащение угля"));
        cServiceClasses.add(new cServiceClass(13,section2,"06.20.1","Добыча природного газа"));

        sCompanies.add(new sCompany("РосСельхозУгодия",address,"662656",compRightNorm3,section));
        sCompanies.add(new sCompany("НефтеБур",address2,"675696",compRightNorm3,section2));
        sCompanies.add(new sCompany("МикроСистемс",address3,"569687",compRightNorm,section6));
        sCompanies.add(new sCompany("УльтимейтТехнолоджи",address4,"225688",compRightNorm3,section6));
        sCompanies.add(new sCompany("Озон",address5,"335469",compRightNorm2,section3));
        sCompanies.add(new sCompany("IBM",address6,"622366",compRightNorm3,section6));
        sCompanies.add(new sCompany("Буквоед",address7,"635336",compRightNorm,section5));
        sCompanies.add(new sCompany("НефтьДобРесурс",address8,"635546",compRightNorm3,section2));
        sCompanies.add(new sCompany("СервисСтройМонтаж",address9,"644366",compRightNorm2,section4));
        sCompanies.add(new sCompany("СройДом",address10,"635546",compRightNorm3,section4));

    }

    public List<cServiceSection> getcServiceSections() {
        return cServiceSections;
    }

    public void setcServiceSections(List<cServiceSection> cServiceSections) {
        this.cServiceSections = cServiceSections;
    }

    public List<cCompRightNorm> getcCompRightNorms() {
        return cCompRightNorms;
    }

    public void setcCompRightNorms(List<cCompRightNorm> cCompRightNorms) {
        this.cCompRightNorms = cCompRightNorms;
    }

    public List<cServiceClass> getcServiceClasses() {
        return cServiceClasses;
    }

    public void setcServiceClasses(List<cServiceClass> cServiceClasses) {
        this.cServiceClasses = cServiceClasses;
    }

    public List<sAddress> getsAddresses() {
        return sAddresses;
    }

    public void setsAddresses(List<sAddress> sAddresses) {
        this.sAddresses = sAddresses;
    }

    public List<sCompany> getsCompanies() {
        return sCompanies;
    }

    public void setsCompanies(List<sCompany> sCompanies) {
        this.sCompanies = sCompanies;
    }
}
