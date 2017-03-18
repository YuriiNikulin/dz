package artcode.spring_aop.tests;

import artcode.spring_aop.dao.CandidatDao;
import artcode.spring_aop.model.Region_spring_aop;
import artcode.spring_aop.service.IService;
import artcode.spring_aop.service.Service;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

/**
 * Created by yurii on 15.03.17.
 */
public class Test1 {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext("artcode.spring_aop");

        IService service = applicationContext.getBean(Service.class);

        List<Region_spring_aop> regions = service.getRegionsWithMaxPopulation();


        for (Region_spring_aop region : regions) {
            System.out.println(region);
        }
    }
}
