package artcode.spring.tests;

import artcode.spring.model.Region;
import artcode.spring.service.Service;
import artcode.spring.utils.MyDB;
import artcode.week3.myServer.MyServer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Created by yurii on 09.03.17.
 */
public class Test {
    public static void main(String[] args) {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("/SpringConf/app-context.xml");

        Service server = (Service) context.getBean("Service");

        List<Region> regions = server.getRegionsWithMaxPopulation();

        for (Region region : regions) {
            System.out.println(region.toString());
        }

    }
}
