package com.gureev.webapp;

import com.gureev.webapp.model.*;

import java.util.ArrayList;
import java.util.List;

public class InitDatabaseUtil {
    
    private List<cServiceSection> ss = new ArrayList<>();
    private List<cCompRightNorm> crn = new ArrayList<>();
    private List<cServiceClass> sc = new ArrayList<>();

    private List<sAddress> adr = new ArrayList<>();
    private List<sCompany> comp = new ArrayList<>();
    
    public InitDatabaseUtil() {
        initDatabase();
    }

    public void initDatabase() {
        cServiceSection section =  new cServiceSection(1,"Сельское, лесное хозяйство, охота, рыболовство и рыбоводство");
        cServiceSection section2 =  new cServiceSection(2,"Добыча полезных ископаемых");
        cServiceSection section3 =  new cServiceSection(3,"Обрабатывающие производства");
        cServiceSection section4 =  new cServiceSection(4,"Строительство");
        cServiceSection section5 =  new cServiceSection(5,"Образование");
        cServiceSection section6 =  new cServiceSection(6,"Предоставление прочих видов услуг");

        ss.add(section);
        ss.add(section2);
        ss.add(section3);
        ss.add(section4);
        ss.add(section5);
        ss.add(section6);

        cCompRightNorm compRightNorm = new cCompRightNorm("ОАО");
        cCompRightNorm compRightNorm2 = new cCompRightNorm("ПАО");
        cCompRightNorm compRightNorm3 = new cCompRightNorm("ООО");
        cCompRightNorm compRightNorm4 = new cCompRightNorm("ЗАО");

        crn.add(compRightNorm);
        crn.add(compRightNorm2);
        crn.add(compRightNorm3);
        crn.add(compRightNorm4);

        sAddress address = new sAddress(1,new AddressJsonb("Самара","Московское шоссе","101","25"));
        sAddress address2 = new sAddress(2,new AddressJsonb("Самара","Гая","23","1"));
        sAddress address3 = new sAddress(3,new AddressJsonb("Самара","Лукачёва","62","6"));
        sAddress address4 = new sAddress(4,new AddressJsonb("Самара","Лукачёва","62","10"));
        sAddress address5 = new sAddress(5,new AddressJsonb("Самара","Революционная","80","3"));
        sAddress address6 = new sAddress(6,new AddressJsonb("Самара","Революционная","45","66"));
        sAddress address7 = new sAddress(7,new AddressJsonb("Самара","Аврора","45","66"));
        sAddress address8 = new sAddress(8,new AddressJsonb("Самара","Аврора","45","50"));
        sAddress address9 = new sAddress(9,new AddressJsonb("Самара","Аврора","45","22"));
        sAddress address10 = new sAddress(10,new AddressJsonb("Самара","Бубнова","11","9"));

        adr.add(address);
        adr.add(address2);
        adr.add(address3);
        adr.add(address4);
        adr.add(address5);
        adr.add(address6);
        adr.add(address7);
        adr.add(address8);
        adr.add(address9);
        adr.add(address10);

        sc.add(new cServiceClass(1,section,"01","Растениеводство и животноводство, охота и предоставление соответствующих услуг в этих областях"));
        sc.add(new cServiceClass(2,section,"01.11.11","Выращивание пшеницы"));
        sc.add(new cServiceClass(3,section,"01.11.12","Выращивание ячменя"));
        sc.add(new cServiceClass(4,section,"01.13.31","Выращивание картофеля"));
        sc.add(new cServiceClass(5,section,"01.14","Выращивание сахарного тростника"));

        sc.add(new cServiceClass(6,section4,"41","Строительство зданий"));
        sc.add(new cServiceClass(7,section4,"41.1","Разработка строительных проектов"));

        sc.add(new cServiceClass(8,section5,"85.30","Обучение профессиональное"));
        sc.add(new cServiceClass(9,section5,"85.41","Образование дополнительное детей и взрослых"));

        sc.add(new cServiceClass(10,section2,"05.10","Добыча и обогащение угля и антрацита"));
        sc.add(new cServiceClass(11,section2,"05.10.11","Добыча антрацита открытым способом"));
        sc.add(new cServiceClass(12,section2,"05.10.2","Обогащение угля"));
        sc.add(new cServiceClass(13,section2,"06.20.1","Добыча природного газа"));

        comp.add(new sCompany("РосСельхозУгодия",address,"662656",compRightNorm3,section));
        comp.add(new sCompany("НефтеБур",address2,"675696",compRightNorm3,section2));
        comp.add(new sCompany("МикроСистемс",address3,"569687",compRightNorm,section6));
        comp.add(new sCompany("УльтимейтТехнолоджи",address4,"225688",compRightNorm3,section6));
        comp.add(new sCompany("Озон",address5,"335469",compRightNorm2,section3));
        comp.add(new sCompany("IBM",address6,"622366",compRightNorm3,section6));
        comp.add(new sCompany("Буквоед",address7,"635336",compRightNorm,section5));
        comp.add(new sCompany("НефтьДобРесурс",address8,"635546",compRightNorm3,section2));
        comp.add(new sCompany("СервисСтройМонтаж",address9,"644366",compRightNorm2,section4));
        comp.add(new sCompany("СройДом",address10,"635546",compRightNorm3,section4));

    }

    public List<cServiceSection> getSs() {
        return ss;
    }

    public List<cCompRightNorm> getCrn() {
        return crn;
    }

    public List<cServiceClass> getSc() {
        return sc;
    }

    public List<sAddress> getAdr() {
        return adr;
    }

    public List<sCompany> getComp() {
        return comp;
    }
}
