import com.rawrysmode.entities.city.City;
import com.rawrysmode.entities.city.CityService;
import com.rawrysmode.entities.route.RouteService;
import org.junit.jupiter.api.Test;

public class EntitiesTest {

    @Test
    void testCityEntity() {
        CityService cityService = new CityService();
        System.out.println("get all: " + cityService.findAll());

        City entity = new City("Якутия");
        System.out.println(cityService.save(entity));
        System.out.println("get where: " + cityService.findWhere("Якутия"));

        entity.setCityName("Омск");
        System.out.println(cityService.update(entity));
        System.out.println("get where: " + cityService.findWhere("Омск"));

        System.out.println(cityService.delete(entity));
        System.out.println("get where: " + cityService.findWhere("Омск"));
    }

    @Test
    void testRouteEntity() {
        RouteService routeService = new RouteService();
        System.out.println("get all: " + routeService.findAll());

//        City entity = new City("Якутия");
//        System.out.println(routeService.save(entity));
//        System.out.println("get where: " + routeService.findWhere("Якутия"));
//
//        entity.setCityName("Омск");
//        System.out.println(routeService.update(entity));
//        System.out.println("get where: " + routeService.findWhere("Омск"));
//
//        System.out.println(routeService.delete(entity));
//        System.out.println("get where: " + routeService.findWhere("Омск"));
    }
}
