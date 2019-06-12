package pt.repository;

        import pt.domain.Vehicle;
        import org.springframework.stereotype.Repository;

        import java.util.Set;

@Repository
public interface VehicleRepository extends IRepository<Vehicle, String>{

    Set<Vehicle> getAll();

}
