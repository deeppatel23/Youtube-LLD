package Services;

import Enums.VehicleType;
import Factories.UserFactory;
import Factories.VehicleFactory;
import Models.User;
import Models.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class UserService {
    List<User>users;
    static int id;

    UserFactory userFactory;
    VehicleFactory vehicleFactory;
    public UserService() {
        userFactory = new UserFactory();
        vehicleFactory = new VehicleFactory();
        users = new ArrayList<>();
        id = 0;
    }

    public void addUser(String name, String gender, int age) {
        id++;
        User user = userFactory.createUser(name, id, gender, age);
        users.add(user);
    }

    public User getUser(String name) {
        return users
                .stream()
                .filter(user -> user.getName().equalsIgnoreCase(name))
                .findFirst()
                .orElse(null);
    }

    public void addVehicle(String userName, String model, String vehicleNumber, String vehicleType) {
        User user = getUser(userName);
        Vehicle vehicle = vehicleFactory.createVehicle(vehicleNumber, model, vehicleType, user);
        user.addVehicle(vehicle);
    }

    public List<Vehicle> getVehicle(String userName) {
        return users
                .stream()
                .filter(user -> user.getName().equalsIgnoreCase(userName))
                .findFirst()
                .get()
                .getVehicles();
    }
}
