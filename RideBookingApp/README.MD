Ride Sharing Application
The application allows users to share rides on a route.
Users can either offer a shared ride (Driver) or consume a shared ride (Passenger).
Users will select ride based on the strategy

Requirements:
Application should allow user onboarding.
Add basic user details
Add the user’s vehicle(s) details
Users should be able to offer a shared ride on a route with details.
Ride will have details like vehicle, origin, destination, available seats. (A ride will have no intermediate stops.)
Users can select a ride from multiple offered rides using a selection strategy. (A user can only request a ride)
Preferred VehicleType
Most Vacant.
System should be able to end the ride.
Users can only offer a ride for a given vehicle, once there are no active offered rides for that vehicle type.
Find total rides offered/taken by all users.


Bonus Question:
If the user’s origin/destinations are not available directly but it’s possible via multiple rides, then the application should output multiple rides. (Example: for input: Bangalore to Mumbai, the output can be Bangalore to Goa and Goa to Mumbai) 

Other Notes:
Write a driver class for demo purposes. Which will execute all the commands in one place in the code and test cases. 
Do not use any database or NoSQL store, use in-memory data-structure for now.
Do not create any UI for the application. 
Please prioritize code compilation, execution, and completion.
Work on the expected output first and then add good-to-have features of your own. 

Expectations:
Make sure that you have a working and demonstrable code.
Make sure that the code is functionally correct.
Use of proper abstraction, modeling, separation of concerns is required.
Code should be modular, readable and unit-testable.
Code should easily accommodate new requirements with minimal changes.
Proper exception handling is required.







Blue-Print to solve any LLD problem
Step 1: Understand and List Functional Requirements:Action / Features / Flows
offerRide
selectRide
endRide
printStats
addUser
getUser
addVehicle
getVehicle
Outcome: Methods
Step 2: Identify Core Entities (Nouns → Classes)
Vehicle
Car
Bike
Auto
User
Ride
Location
Outcome: Models classes
Step 3: Define Attributes and Responsibilities for each class
Vehicle
registrationNumber
vehicleType
User
model
User
Id
Name
Gender
RidesOffered
RidesTaken
List<Vehicle>vehicles
Ride
Id
Location
Vehicle
Driver
List<User>Riders
availableSeats
rideStatus
Location
Double lat
Double long
String Address
Outcome: Initial draft for each models
Step 4: Identify Relationships Between Entities
Composition (has-a)
Ride has a Vehicle, Driver
User has a Vehicle
Inheritance (is-a)
Can, Bike, Auto is a Vehicle
Associations
Ride is associated to List<User>riders
Outcome: Composition and hierarchy structure
Step 5: Create Enums and Constants
Gender
RideStatus
VehicleType
Outcome: Cleaner type safety compared to string
Step 6: Design Services (Action-Oriented Classes)
UserService
RideService
Outcome: A class that encapsulates system behavior.
Step 7: Handle Data Flow and Storage (Temporary or Persistent)
Temporary
Map
List
Step 8: Plan Algorithms, Design Patterns or Business Rules
VehicleFactory
UserFactory
RideSelectionStrategy
Outcome: rules or filters you must apply
Step 9: Cover Edge Cases, Exceptions & Validations
Handle:
Invalid inputs
Null values
Exceptions
Outcome: Handling of exceptions and  edge cases
Step 10: Write Code
Start with interfaces and abstract class
Then, create Enums
Then, create Models
Then, create Services
And at the end, create Driver class

