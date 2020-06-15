package FinalFlyweight;


class FlyweightPatternEx {
    public static void main(String[] args) throws Exception {
        RobotFactory myfactory = new RobotFactory();
        System.out.println("\n***Flyweight Pattern Example***\n");

        IRobot shape = myfactory.GetRobotFromFactory("small");
        shape.Print();
        for (int i = 0; i < 2; i++) {
            shape = myfactory.GetRobotFromFactory("small");
            shape.Print();
        }
        int NumOfDistinctRobots = myfactory.TotalObjectsCreated();
        System.out.println("\nDistinct Robot objects created till now=  " + NumOfDistinctRobots);

        for (int i = 0; i < 5; i++) {
            shape = myfactory.GetRobotFromFactory("large");
            shape.Print();
        }

        NumOfDistinctRobots = myfactory.TotalObjectsCreated();
        System.out.println("\n Finally no of Distinct Robot objects created:  " + NumOfDistinctRobots);
    }
}
